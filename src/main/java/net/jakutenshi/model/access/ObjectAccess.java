package net.jakutenshi.model.access;

import net.jakutenshi.model.sql.DBTables;
import net.jakutenshi.model.sql.SQLEntity;

import net.jakutenshi.model.tables.TableDescription;
import net.jakutenshi.utils.DBConnection;
import net.jakutenshi.utils.BuildQueriesUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public interface ObjectAccess {
    static <T extends SQLEntity> long insert(TableDescription desc, T entity) {
        try(PreparedStatement st = entity.prepare(DBConnection.getConnection().prepareStatement(
                BuildQueriesUtils.buildSQLInsertQuery(desc),
                Statement.RETURN_GENERATED_KEYS))
        ) {
            if (st.executeUpdate() == 0) {
                return -1;
            }
            return st.getGeneratedKeys().getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    static <T extends SQLEntity> boolean delete(TableDescription desc, T entity) {
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(
                BuildQueriesUtils.buildSQLDeleteQuery(desc, entity.getID()))
        ) {
            return st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    };

    static boolean delete(TableDescription desc, long id) {
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(
                BuildQueriesUtils.buildSQLDeleteQuery(desc, id))
        ) {
            return st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    };

    static <T extends SQLEntity> boolean update(TableDescription desc, T entity) {
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(
                BuildQueriesUtils.buildSQLUpdateQuery(desc, entity.getID()))
        ) {
            return entity.prepare(st).execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    };

    static SQLEntity get(TableDescription desc, long id) {
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
        ArrayList<SQLEntity> res = new ArrayList<>();
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(BuildQueriesUtils.buildSQLGetAll(desc));
            ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                res.add(desc.getMeta().getEntity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    };

    static ArrayList<SQLEntity> getAllWhere(TableDescription desc, String whereQuery) {
        ArrayList<SQLEntity> res = new ArrayList<>();
        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(BuildQueriesUtils.buildSQLGetAll(desc));
            ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                res.add(desc.getMeta().getEntity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    };

}
