package net.jakutenshi.model.entities;

import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Absence extends SQLEntity {
    private int dutyID;
    private int reasonID;

    public Absence() {
        super(-1);
        this.dutyID   = -1;
        this.reasonID = -1;
    }

    public Absence(ResultSet rs) throws SQLException {
        super(rs);
        this.dutyID = rs.getInt("duty_id");
        this.reasonID = rs.getInt("reason_id");
    }

    public Absence(int id, int dutyID, int reasonID) {
        super(id);
        this.dutyID = dutyID;
        this.reasonID = reasonID;
    }

    @Override
    public Object getAttribute(int column) {
        switch (column){
            case 0:
                return "#" + getDutyID();
            case 1:
                return Model.ABSENCE_REASONS.getEntity(reasonID).getName();
            default:
                return null;
        }
    }

    @Override
    public PreparedStatement prepare(PreparedStatement st) throws SQLException {
        st.setInt(1, dutyID);
        st.setInt(2, reasonID);
        return st;
    }

    public int getDutyID() {
        return dutyID;
    }

    public void setDutyID(int dutyID) {
        this.dutyID = dutyID;
    }

    public int getReasonID() {
        return reasonID;
    }

    public void setReasonID(int reasonID) {
        this.reasonID = reasonID;
    }
}
