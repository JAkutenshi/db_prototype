package net.jakutenshi.model.entities;

import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.utils.Boolean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;

import static net.jakutenshi.utils.Constants.*;

public class Duty extends SQLEntity {
    private int     id;
    private int     securityID;
    private int     postID;
    private Date    date;
    private int     totalHours;
    private int     nightHours;
    private Boolean isHoliday;
    private int     positionID;
    private int     categoryID;
    private int     salaryTypeID;
    private double  salary;

    public Duty() {
        this.id           = -1;
        this.securityID   = -1;
        this.postID       = -1;
        this.date         = DATE_NONE;
        this.positionID   = -1;
        this.totalHours   = -1;
        this.nightHours   = -1;
        this.isHoliday    = new Boolean(false);
        this.categoryID   = -1;
        this.salaryTypeID = -1;
        this.salary       = -1.0;
    }

    public Duty(int id, int securityID, int postID, Date date, int totalHours, int nightHours,
                boolean isHoliday, int positionID,  int categoryID, int salaryTypeID, double salary) {
        this.id           = id;
        this.securityID   = securityID;
        this.postID       = postID;
        this.date         = date;
        this.positionID   = positionID;
        this.totalHours   = totalHours;
        this.nightHours   = nightHours;
        this.isHoliday    = new Boolean(isHoliday);
        this.categoryID   = categoryID;
        this.salaryTypeID = salaryTypeID;
        this.salary       = salary;
    }

    public Duty(ResultSet rs) throws SQLException {
        super(rs);
        this.securityID   = rs.getInt("security_id");
        this.postID       = rs.getInt("post_id");
        try {
            this.date     = SQLITE_DATE_FORMAT.parse(rs.getString("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.positionID   = rs.getInt("position_id");
        this.totalHours   = rs.getInt("total_hours");
        this.nightHours   = rs.getInt("night_hours");
        this.isHoliday    = new Boolean(rs.getBoolean("is_holiday"));
        this.categoryID   = rs.getInt("category_id");
        this.salaryTypeID = rs.getInt("salary_type_id");
        this.salary       = rs.getDouble("salary");
    }

    @Override
    public Object getAttribute(int column) {
        switch (column) {
            case 0: return getID();
            case 1: return Model.EMPLOYEES.getEntity(securityID).getName();
            case 2: return Model.POSTS.getEntity(postID).getDescription();
            case 3: return Model.POSITIONS.getEntity(positionID).getName();
            case 4: return Model.CATEGORIES.getEntity(categoryID).getName();
            case 5: return DATE_FORMAT.format(getDate());
            case 6: return getTotalHours();
            case 7: return getNightHours();
            case 8: return isHoliday().toString();
            case 9: return Model.SALARY_TYPES.getEntity(salaryTypeID).getName();
            case 10: return getSalary();
            default: return null;

        }
    }

    @Override
    public PreparedStatement prepare(PreparedStatement st) throws SQLException {
        st.setInt(1, getPostID());
        st.setString(2, SQLITE_DATE_FORMAT.format(getDate())); // ToDo
        st.setInt(3, getPositionID());
        st.setInt(4, getTotalHours());
        st.setInt(5, getNightHours());
        st.setBoolean(6, isHoliday().isTrue());
        st.setInt(7, getCategoryID());
        st.setInt(8, getSalaryTypeID());
        st.setDouble(9, getSalary());
        return st;
    }

    public int getSecurityID() {
        return securityID;
    }

    public void setSecurityID(int id) {
        this.securityID = id;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int post_id) {
        this.postID = post_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public int getNightHours() {
        return nightHours;
    }

    public void setNightHours(int nightHours) {
        this.nightHours = nightHours;
    }

    public Boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday.setValue(holiday);
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getSalaryTypeID() {
        return salaryTypeID;
    }

    public void setSalaryTypeID(int salaryTypeID) {
        this.salaryTypeID = salaryTypeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
