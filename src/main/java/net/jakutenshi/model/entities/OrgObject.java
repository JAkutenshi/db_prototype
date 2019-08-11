package net.jakutenshi.model.entities;

import net.jakutenshi.model.sql.SQLEntity;
import net.jakutenshi.model.tables.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrgObject extends SQLEntity {
    private int    organizationID;
    private String name;
    private String address;
    private String phoneNum;
    private int    securityHeadID;
    private double salaryRatio;
    private int    salaryTypeID;

    public OrgObject() {
        super(-1);
        this.organizationID = -1;
        this.name           = "None";
        this.address        = "None";
        this.phoneNum       = "+00000000000";
        this.securityHeadID = -1;
        this.salaryRatio    = -1.0;
        this.salaryTypeID   = -1;
    }

    public OrgObject(int id, int organizationID, String name, String address, String phoneNum,
                     int securityHeadID, double salaryRatio, int salaryTypeID) {
        super(id);
        this.organizationID = organizationID;
        this.name           = name;
        this.address        = address;
        this.phoneNum       = phoneNum;
        this.securityHeadID = securityHeadID;
        this.salaryRatio    = salaryRatio;
        this.salaryTypeID   = salaryTypeID;
    }

    public OrgObject(ResultSet rs) throws SQLException {
        super(rs);
        this.organizationID = rs.getInt("organization_id");
        this.name           = rs.getString("name");
        this.address        = rs.getString("address");
        this.phoneNum       = rs.getString("phone_num");
        this.securityHeadID = rs.getInt("security_head_id");
        this.salaryRatio    = rs.getDouble("salary_ratio");
        this.salaryTypeID   = rs.getInt("salary_type_id");
    }

    @Override
    public Object getAttribute(int column) {
        switch (column) {
            case 0: return Model.ORGANIZATIONS.getEntity(organizationID).getDescription();
            case 1: return getName();
            case 2: return getAddress();
            case 3: return getPhoneNum();
            case 4: return Model.EMPLOYEES.getEntity(securityHeadID).getName();
            case 5: return getSalaryRatio();
            case 6: return Model.SALARY_TYPES.getEntity(salaryTypeID).getName();
            default: return null;
        }
    }

    @Override
    public PreparedStatement prepare(PreparedStatement st) throws SQLException {
        st.setInt(1, getOrganizationID());
        st.setString(2, getName());
        st.setString(3, getAddress());
        st.setString(4, getPhoneNum());
        st.setInt(5, getSecurityHeadID());
        st.setDouble(6, getSalaryRatio());
        st.setInt(7, getSalaryTypeID());
        return st;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
