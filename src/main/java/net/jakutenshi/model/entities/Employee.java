package net.jakutenshi.model.entities;

import java.util.Date;

import static net.jakutenshi.utils.Constants.*;

public class Employee {
    private int     id;
    private String  second_name;
    private String  first_name;
    private String  middle_name;
    private String  phone_number;
    private Date    PSD_expiration_date;
    private Date    training_expiration_date;
    private boolean is_reserved;
    private int     mainPostID;
    private int     categoryID;
    private int     positionID;
    private String  note;


    public Employee() {
        this.id                       = -1;
        this.second_name              = NONE;
        this.first_name               = NONE;
        this.middle_name              = NONE;
        this.phone_number             = PHONE_NONE;
        this.PSD_expiration_date      = DATE_NONE;
        this.training_expiration_date = DATE_NONE;
        this.is_reserved              = false;
        this.mainPostID               = -1;
        this.categoryID               = -1;
        this.positionID               = -1;
        this.note                     = NONE;
    }

    public Employee(int id, String second_name, String first_name, String middle_name,
                    String phone_number, Date PSD_expiration_date, Date training_expiration_date,
                    boolean is_reserved, int mainPostID, int categoryID, int positionID, String note) {
        this.id                       = id;
        this.second_name              = second_name;
        this.first_name               = first_name;
        this.middle_name              = middle_name;
        this.phone_number             = phone_number;
        this.PSD_expiration_date      = PSD_expiration_date;
        this.training_expiration_date = training_expiration_date;
        this.is_reserved              = is_reserved;
        this.mainPostID               = mainPostID;
        this.categoryID               = categoryID;
        this.positionID               = positionID;
        this.note                     = note;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getPSD_expiration_date() {
        return PSD_expiration_date;
    }

    public void setPSD_expiration_date(Date PSD_expiration_date) {
        this.PSD_expiration_date = PSD_expiration_date;
    }

    public Date getTraining_expiration_date() {
        return training_expiration_date;
    }

    public void setTraining_expiration_date(Date training_expiration_date) {
        this.training_expiration_date = training_expiration_date;
    }

    public boolean isIs_reserved() {
        return is_reserved;
    }

    public void setIs_reserved(boolean is_reserved) {
        this.is_reserved = is_reserved;
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
