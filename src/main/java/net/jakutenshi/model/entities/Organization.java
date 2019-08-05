package net.jakutenshi.model.entities;

import net.jakutenshi.model.sql.SQLEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static net.jakutenshi.utils.Constants.*;

public class Organization extends SQLEntity {
    private String name;
    private String legalAddress;
    private String phoneNum;

    public Organization() {
        super();
        this.name         = NONE;
        this.legalAddress = NONE;
        this.phoneNum     = PHONE_NONE;
    }

    public Organization(ResultSet rs) throws SQLException {
        super(rs);
        this.name         = rs.getString("name");
        this.legalAddress = rs.getString("legal_address");
        this.phoneNum = rs.getString("phone_num");
    }

    public Organization(int id, String name, String legalAddress, String phoneNum) {
        super(id);
        this.name         = name;
        this.legalAddress = legalAddress;
        this.phoneNum = phoneNum;
    }

    @Override
    public Object getAttribute(int column) {
        switch (column) {
            case 0:
                return name;
            case 1:
                return legalAddress;
            case 2:
                return phoneNum;
            default:
                return null;
        }
    }

    @Override
    public PreparedStatement prepare(PreparedStatement st) throws SQLException {
        st.setString(1, name);
        st.setString(2, legalAddress);
        st.setString(3, phoneNum);
        return st;
    }

    @Override
    public String toString() {
        return name + " | " + phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}