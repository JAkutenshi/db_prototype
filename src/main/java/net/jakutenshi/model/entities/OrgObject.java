package net.jakutenshi.model.entities;

public class OrgObject {
    private int    id;
    private int    organizationID;
    private String name;
    private String address;
    private String phone_num;
    private int    securityHeadID;
    private double salaryRatio;
    private int    salaryTypeID;

    public OrgObject() {
        this.id             = -1;
        this.organizationID = -1;
        this.name           = "None";
        this.address        = "None";
        this.phone_num      = "+00000000000";
        this.securityHeadID = -1;
        this.salaryRatio    = -1.0;
        this.salaryTypeID   = -1;
    }

    public OrgObject(int id, int organizationID, String name, String address, String phone_num,
                     int securityHeadID, double salaryRatio, int salaryTypeID) {
        this.id             = id;
        this.organizationID = organizationID;
        this.name           = name;
        this.address        = address;
        this.phone_num      = phone_num;
        this.securityHeadID = securityHeadID;
        this.salaryRatio    = salaryRatio;
        this.salaryTypeID   = salaryTypeID;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
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
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public int getSecurityHeadID() {
        return securityHeadID;
    }

    public void setSecurityHeadID(int securityHeadID) {
        this.securityHeadID = securityHeadID;
    }

    public double getSalaryRatio() {
        return salaryRatio;
    }

    public void setSalaryRatio(double salaryRatio) {
        this.salaryRatio = salaryRatio;
    }

    public int getSalaryTypeID() {
        return salaryTypeID;
    }

    public void setSalaryTypeID(int salaryTypeID) {
        this.salaryTypeID = salaryTypeID;
    }
}
