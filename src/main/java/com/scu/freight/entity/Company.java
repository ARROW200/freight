package com.scu.freight.entity;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/24 18:32
 */
public class Company {
    private int companyId;
    private String companyName;
    private String companyAddress;
    private String phone;

    private int status;

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }

    public Company() {
    }

    public Company(int companyId, String companyName, String companyAddress, String phone, int status) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.phone = phone;
        this.status = status;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
