package net.jakutenshi.model.entities;

import java.util.Date;

import static net.jakutenshi.utils.Constants.*;

public class Duty {
    private int     id;
    private int     securityID;
    private int     postID;
    private Date    date;
    private int     totalHours;
    private int     nightHours;
    private boolean isHoliday;
    private int     positionID;
    private int     categoryID;
    private double  salary;

    public Duty() {
        this.id          = -1;
        this.securityID  = -1;
        this.postID      = -1;
        this.date        = DATE_NONE;
        this.positionID  = -1;
        this.totalHours  = -1;
        this.nightHours  = -1;
        this.isHoliday   = false;
        this.categoryID  = -1;
        this.salary      = -1.0;
    }

    public Duty(int id, int securityID, int postID, Date date, int totalHours, int nightHours,
                boolean isHoliday, int positionID,  int categoryID, double salary) {
        this.id          = id;
        this.securityID  = securityID;
        this.postID      = postID;
        this.date        = date;
        this.positionID  = positionID;
        this.totalHours  = totalHours;
        this.nightHours  = nightHours;
        this.isHoliday   = isHoliday;
        this.categoryID  = categoryID;
        this.salary      = salary;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
