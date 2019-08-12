package net.jakutenshi.model.entities.enums;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Position extends EnumString {
    public Position(ResultSet rs) throws SQLException {
        super(rs);
        super.setName(rs.getString("name"));
    }
}
