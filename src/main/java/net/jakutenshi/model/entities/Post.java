package net.jakutenshi.model.entities;

import static net.jakutenshi.utils.Constants.*;

public class Post {
    private int    id;
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
        this.id                 = -1;
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

    public Post(int id, int objectID, String name, String address, String phone_num,
                int number, int guardsChangingFreq, double surcharge, double checkage, int arrivalMethodID) {
        this.id                 = id;
        this.objectID           = objectID;
        this.name               = name;
        this.address            = address;
        this.phoneNum           = phone_num;
        this.number             = number;
        this.guardsChangingFreq = guardsChangingFreq;
        this.surcharge          = surcharge;
        this.checkage           = checkage;
        this.arrivalMethodID    = arrivalMethodID;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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

    public String getPhone_num() {
        return phoneNum;
    }

    public void setPhone_num(String phone_num) {
        this.phoneNum = phone_num;
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
