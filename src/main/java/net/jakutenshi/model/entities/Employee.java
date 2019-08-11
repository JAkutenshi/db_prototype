package net.jakutenshi.model.entities;

import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.Model;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import static net.jakutenshi.utils.Constants.*;

public class Employee extends SQLEntity {
    private String  secondName;
    private String  firstName;
    private String  middleName;
    private String  phoneNumber;
    private Date    PSDExpirationDate;
    private Date    trainingExpirationDate;
    private boolean isReserved;
    private int     mainPostID;
    private int     categoryID;
    private int     positionID;
    private String  note;


    public Employee() {
        super(-1);
        this.secondName               = NONE;
        this.firstName                = NONE;
        this.middleName               = NONE;
        this.phoneNumber              = PHONE_NONE;
        this.PSDExpirationDate        = DATE_NONE;
        this.trainingExpirationDate   = DATE_NONE;
        this.isReserved               = false;
        this.mainPostID               = -1;
        this.categoryID               = -1;
        this.positionID               = -1;
        this.note                     = NONE;
    }

    public Employee(int id, String secondName, String firstName, String middleName,
                    String phoneNumber, Date PSDExpirationDate, Date trainingExpirationDate,
                    boolean isReserved, int mainPostID, int categoryID, int positionID, String note) {
        super(id);
        this.secondName               = secondName;
        this.firstName                = firstName;
        this.middleName               = middleName;
        this.phoneNumber              = phoneNumber;
        this.PSDExpirationDate        = PSDExpirationDate;
        this.trainingExpirationDate   = trainingExpirationDate;
        this.isReserved               = isReserved;
        this.mainPostID               = mainPostID;
        this.categoryID               = categoryID;
        this.positionID               = positionID;
        this.note                     = note;
    }

    public Employee(ResultSet rs) throws SQLException {
        super(rs);
        this.secondName               = rs.getString("second_name");
        this.firstName                = rs.getString("first_name");
        this.middleName               = rs.getString("middle_name");
        this.phoneNumber              = rs.getString("phone_number");
        try {
            this.PSDExpirationDate        = SQLITE_DATE_FORMAT.parse(rs.getString("PSD_expiration_date"));
            this.trainingExpirationDate   = SQLITE_DATE_FORMAT.parse(rs.getString("training_expiration_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.isReserved               = rs.getBoolean("is_reserved");
        this.mainPostID               = rs.getInt("main_post_id");
        this.categoryID               = rs.getInt("category_id");
        this.positionID               = rs.getInt("position_id");
        this.note                     = rs.getString("note");
    }

    @Override
    public Object getAttribute(int column) {
        switch (column) {
            case 0: return getSecondName();
            case 1: return getFirstName();
            case 2: return getMiddleName();
            case 3: return getPhoneNumber();
            case 4: return DATE_FORMAT.format(getPSDExpirationDate());
            case 5: return DATE_FORMAT.format(getTrainingExpirationDate());
            case 6: return isReserved();
            case 7: return Model.POSTS.getEntity(mainPostID).getDescription();
            case 8: return Model.CATEGORIES.getEntity(categoryID).getName();
            case 9: return Model.POSITIONS.getEntity(positionID).getName();
            case 10: return getNote();
            default: return null;
        }
    }

    @Override
    public PreparedStatement prepare(PreparedStatement st) throws SQLException {
        st.setString(1, getSecondName());
        st.setString(2, getFirstName());
        st.setString(3, getMiddleName());
        st.setString(4, getPhoneNumber());
        st.setString(5, SQLITE_DATE_FORMAT.format(getPSDExpirationDate()));
        st.setString(6, SQLITE_DATE_FORMAT.format(getTrainingExpirationDate()));
        st.setBoolean(7, isReserved());
        st.setInt(8, getMainPostID());
        st.setInt(9, getCategoryID());
        st.setInt(10, getPositionID());
        st.setString(11, getNote());
        return st;
    }

    public String getName() {
        return secondName + " " + firstName + " " + middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getPSDExpirationDate() {
        return PSDExpirationDate;
    }

    public void setPSDExpirationDate(Date PSDExpirationDate) {
        this.PSDExpirationDate = PSDExpirationDate;
    }

    public Date getTrainingExpirationDate() {
        return trainingExpirationDate;
    }

    public void setTrainingExpirationDate(Date trainingExpirationDate) {
        this.trainingExpirationDate = trainingExpirationDate;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public int getMainPostID() {
        return mainPostID;
    }

    public void setMainPostID(int mainPostID) {
        this.mainPostID = mainPostID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
