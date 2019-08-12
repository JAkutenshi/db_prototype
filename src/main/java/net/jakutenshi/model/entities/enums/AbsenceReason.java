package net.jakutenshi.model.entities.enums;

import net.jakutenshi.model.entities.Absence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbsenceReason extends EnumString {
    public AbsenceReason(ResultSet rs) throws SQLException {
        super(rs);
        super.setName(rs.getString("reason_name"));
    }
}
