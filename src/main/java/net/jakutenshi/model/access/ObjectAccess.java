package net.jakutenshi.model.access;

import net.jakutenshi.model.sql.DBTables;
import net.jakutenshi.model.sql.SQLEntity;

import net.jakutenshi.model.tables.TableDescription;
import net.jakutenshi.utils.DBConnection;
import net.jakutenshi.utils.BuildQueriesUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ObjectAccess {
    static <T extends SQLEntity> void insert(TableDescription desc, T entity) {
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(
                BuildQueriesUtils.buildSQLInsertQuery(desc))
        ) {
            entity.prepare(st);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static <T extends SQLEntity> void delete(TableDescription desc, T entity) {
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(
                BuildQueriesUtils.buildSQLDeleteQuery(desc, entity.getID()))
        ) {
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    static void delete(TableDescription desc, int id) {
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(
                BuildQueriesUtils.buildSQLDeleteQuery(desc, id))
        ) {
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    static <T extends SQLEntity> void update(TableDescription desc, T entity) {
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(
                BuildQueriesUtils.buildSQLUpdateQuery(desc, entity.getID()))
        ) {
            entity.prepare(st);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    static SQLEntity get(TableDescription desc, int id) {
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(BuildQueriesUtils.buildSQLGet(desc, id));
            ResultSet rs = st.executeQuery()
        ) {
            return desc.getMeta().getEntity(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    };

    static ArrayList<SQLEntity> getAll(TableDescription desc) {
        ArrayList<SQLEntity> list = new ArrayList<>();
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(BuildQueriesUtils.buildSQLGetAll(desc));
            ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                list.add(desc.getMeta().getEntity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    };
}
