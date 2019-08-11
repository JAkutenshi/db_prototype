package net.jakutenshi.model.entities;

import jdk.vm.ci.meta.Constant;
import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.utils.Constants;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import static net.jakutenshi.utils.Constants.*;

public class ArrivalMethod extends SQLEntity {
    private int    driverID;
    private int    autoTypeID;
    private String    autoNumber;
    private Date arrivingTime;
    private int    frequency;
    private String arrivesFrom;

    public ArrivalMethod() {
        super(-1);
        this.driverID     = -1;
        this.autoTypeID   = -1;
        this.autoNumber   = NONE;
        this.arrivingTime = DATE_NONE;
        this.frequency    = -1;
        this.arrivesFrom  = NONE;
    }

    public ArrivalMethod(ResultSet rs) throws SQLException {
        super(rs);
        this.driverID     = rs.getInt("driver_id");
        this.autoTypeID   = rs.getInt("auto_type_id");
        this.autoNumber   = rs.getString("auto_number");
        try {
            this.arrivingTime = Constants.TIME_FORMAT.parse(rs.getString("arriving_time"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.frequency    = rs.getInt("frequency");
        this.arrivesFrom  = rs.getString("arrives_from");
    }

    public ArrivalMethod(int id, int driverID, int autoTypeID,
                         String autoNumber, Date arrivingTime, int frequency, String arrivesFrom) {
        super(id);
        this.driverID     = driverID;
        this.autoTypeID   = autoTypeID;
        this.autoNumber   = autoNumber;
        this.arrivingTime = arrivingTime;
        this.frequency    = frequency;
        this.arrivesFrom  = arrivesFrom;
    }

    @Override
    public Object getAttribute(int column) {
        switch (column) {
            case 0: return Model.EMPLOYEES.getEntity(driverID).getName();
            case 1: return Model.AUTO_TYPES.getEntity(autoTypeID).getName();
            case 2: return getAutoNumber();
            case 3: return TIME_FORMAT.format(getArrivingTime());
            case 4: return getFrequency();
            case 5: return getArrivesFrom();
            default: return null;
        }
    }

    @Override
    public PreparedStatement prepare(PreparedStatement st) throws SQLException {
        st.setInt(1,    getID());
        st.setInt(2,    getDriverID());
        st.setInt(3,    getAutoTypeID());
        st.setString(4, getAutoNumber());
        st.setString(5, TIME_FORMAT.format(getArrivingTime()));
        st.setInt(6,    getFrequency());
        st.setString(7, getArrivesFrom());
        return st;
    }

    @Override
    public String toString() {
        return autoNumber + " в " + TIME_FORMAT.format(arrivingTime) + " по адресу " + arrivesFrom; //ToDo time format
    }

    public String getDescription() {
        return toString();
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public int getAutoTypeID() {
        return autoTypeID;
    }

    public void setAutoTypeID(int autoTypeID) {
        this.autoTypeID = autoTypeID;
    }

    public String getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(String autoNumber) {
        this.autoNumber = autoNumber;
    }

    public Date getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(Date arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getArrivesFrom() {
        return arrivesFrom;
    }

    public void setArrivesFrom(String arrivesFrom) {
        this.arrivesFrom = arrivesFrom;
    }
}
