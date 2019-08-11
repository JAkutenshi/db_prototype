package net.jakutenshi.model.entities.enums;

import net.jakutenshi.model.sql.SQLEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

import static net.jakutenshi.utils.Constants.NONE;

public abstract class EnumString extends SQLEntity {
    private String name;

    public EnumString() {
        super(-1);
        this.name = NONE;
    }

    public EnumString(ResultSet rs) throws SQLException {
        super(rs);
    }

    public EnumString(int id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public Object getAttribute(int column) {
        switch (column) {
            case 0:
                return name;
            default:
                return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
