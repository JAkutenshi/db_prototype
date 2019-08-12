package net.jakutenshi.model.sql;

import net.jakutenshi.model.access.PreparedValues;
import net.jakutenshi.utils.GenericClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class SQLEntity implements PreparedValues {
    private long id;

    public SQLEntity() {
        this.id = -1;
    }

    public SQLEntity(int id) {
        this.id = id;
    }

    public SQLEntity(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
    }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

    public Object getAttribute(int column) {
        switch (column) {
            case 0:
                return id;
            default:
                return null;
        }
    }
}
