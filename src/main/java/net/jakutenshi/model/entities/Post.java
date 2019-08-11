package net.jakutenshi.model.entities;

import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static net.jakutenshi.utils.Constants.*;

public class Post extends SQLEntity {
    private int    objectID;
    private String name;
    private String address;
    private String phoneNum;
    private int    number;
    private int    guardsChangingFreq;
    private double surcharge;
    private double checkage;
    private int    arrivalMethodID;

    public Post() {
        super(-1);
        this.objectID           = -1;
        this.name               = NONE;
        this.address            = NONE;
        this.phoneNum           = PHONE_NONE;
        this.number             = -1;
        this.guardsChangingFreq = -1;
        this.surcharge          = -1.0;
        this.checkage           = -1.0;
        this.arrivalMethodID    = -1;
    }

    public Post(int id, int objectID, String name, String address, String phoneNum,
                int number, int guardsChangingFreq, double surcharge, double checkage, int arrivalMethodID) {
        super(id);
        this.objectID           = objectID;
        this.name               = name;
        this.address            = address;
        this.phoneNum           = phoneNum;
        this.number             = number;
        this.guardsChangingFreq = guardsChangingFreq;
        this.surcharge          = surcharge;
        this.checkage           = checkage;
        this.arrivalMethodID    = arrivalMethodID;
    }

    public Post(ResultSet rs) throws SQLException {
        super(rs);
        this.objectID           = rs.getInt("object_id");
        this.name               = rs.getString("name");
        this.address            = rs.getString("address");
        this.phoneNum           = rs.getString("phone_num");
        this.number             = rs.getInt("number");
        this.guardsChangingFreq = rs.getInt("guards_changing_freq");
        this.surcharge          = rs.getDouble("surcharge");
        this.checkage           = rs.getDouble("checkage");
        this.arrivalMethodID    = rs.getInt("arrival_method_id");
    }

    @Override
    public Object getAttribute(int column) {
        switch (column) {
            case 0: return Model.ORG_OBJECTS.getEntity(objectID).getName();
            case 1: return getName();
            case 2: return getAddress();
            case 3: return getPhoneNum();
            case 4: return getNumber();
            case 5: return getGuardsChangingFreq();
            case 6: return getSurcharge();
            case 7: return getCheckage();
            case 8: return Model.ARRIVAL_METHODS.getEntity(arrivalMethodID).getDescription(); //ToDo
            default: return null;
        }
    }

    @Override
    public PreparedStatement prepare(PreparedStatement st) throws SQLException {
        st.setInt(1, getObjectID());
        st.setString(2, getName());
        st.setString(3, getAddress());
        st.setString(4, getPhoneNum());
        st.setInt(5, getNumber());
        st.setInt(6, getGuardsChangingFreq());
        st.setDouble(7, getSurcharge());
        st.setDouble(8, getCheckage());
        st.setInt(9, getArrivalMethodID());
        return st;
    }

    @Override
    public String toString() {
        return name + " | " + address + " | " + phoneNum;
    }

    public String getDescription() {
        return toString();
    }

    public int getObjectID() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID = objectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGuardsChangingFreq() {
        return guardsChangingFreq;
    }

    public void setGuardsChangingFreq(int guardsChangingFreq) {
        this.guardsChangingFreq = guardsChangingFreq;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }

    public double getCheckage() {
        return checkage;
    }

    public void setCheckage(double checkage) {
        this.checkage = checkage;
    }

    public int getArrivalMethodID() {
        return arrivalMethodID;
    }

    public void setArrivalMethodID(int arrivalMethodID) {
        this.arrivalMethodID = arrivalMethodID;
    }
}
