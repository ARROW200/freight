package com.scu.freight.entity;

import java.sql.Timestamp;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/24 18:31
 */
public class Staff {
    private int staffId;
    private String staffName;
    private String gender;
    private Timestamp birth;
    private String staffAddress;
    private String phone;
    private int staffRole;
    private int status;

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", staffAddress='" + staffAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", staffRole=" + staffRole +
                ", status=" + status +
                '}';
    }

    public Staff() {
    }

    public Staff(int staffId, String staffName, String gender, Timestamp birth, String staffAddress, String phone, int staffRole, int status) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.gender = gender;
        this.birth = birth;
        this.staffAddress = staffAddress;
        this.phone = phone;
        this.staffRole = staffRole;
        this.status = status;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(int staffRole) {
        this.staffRole = staffRole;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
