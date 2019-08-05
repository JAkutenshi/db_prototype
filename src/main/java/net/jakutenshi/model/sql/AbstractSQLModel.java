package net.jakutenshi.model.sql;

import com.sun.tools.javac.util.Pair;
import net.jakutenshi.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;


public abstract class AbstractSQLModel<T> {

    T[] table;
    public AbstractSQLModel(Pair<String, SQLiteType>[] columns, String sql) {
        ArrayList<T> data = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet result = statement.executeQuery();
        ) {
            while (result.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    abstract void InsertEntity(T entity);
    abstract void DeleteEntity(String sqlCondition);
    abstract void DeleteEntity(T entity);
    abstract void UpdateEntity(String sqlCondition);
    abstract void UpdateEntity(T entity);

}
