package net.jakutenshi.model.entities;

import java.util.Date;

import static net.jakutenshi.utils.Constants.DATE_NONE;
import static net.jakutenshi.utils.Constants.NONE;

public class ArrivalMethod {
    private int    id;
    private int    driverID;
    private int    autoTypeID;
    private int    autoNumber;
    private Date   arrivingTime;
    private int    frequency;
    private String arrivesFrom;

    public ArrivalMethod() {
        this.id           = -1;
        this.driverID     = -1;
        this.autoTypeID   = -1;
        this.autoNumber   = -1;
        this.arrivingTime = DATE_NONE;
        this.frequency    = -1;
        this.arrivesFrom  = NONE;
    }

    public ArrivalMethod(int id, int driverID, int autoTypeID, int autoNumber, Date arrivingTime, int frequency, String arrivesFrom) {
        this.id           = id;
        this.driverID     = driverID;
        this.autoTypeID   = autoTypeID;
        this.autoNumber   = autoNumber;
        this.arrivingTime = arrivingTime;
        this.frequency    = frequency;
        this.arrivesFrom  = arrivesFrom;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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

    public int getAutoNumber() {
        return autoNumber;
    }

    public void setAutoNumber(int autoNumber) {
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
