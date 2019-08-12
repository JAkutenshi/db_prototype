package net.jakutenshi.model.entities.enums;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryType extends EnumString {
    public SalaryType(ResultSet rs) throws SQLException {
        super(rs);
        super.setName(rs.getString("type_name"));
    }
}
