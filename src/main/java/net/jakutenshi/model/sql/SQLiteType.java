package net.jakutenshi.model.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum SQLiteType {
    INTEGER,
    TEXT,
    NUMERIC,
    DATE;

    public <T> T getValue(ResultSet result, String name) {
        try {
            switch (this) {
                case INTEGER:
                    return (T) Integer.valueOf(result.getInt(name));
                case DATE:
                    return (T) result.getDate(name);
                case TEXT:
                    return (T) result.getString(name);
                case NUMERIC:
                    return (T) Float.valueOf(result.getFloat(name));
                default:
                    return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
