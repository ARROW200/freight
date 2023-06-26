package com.scu.freight.entity;

import java.sql.Timestamp;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/24 18:32
 */
public class Record {
    private int recordId;
    private String vehicleId;
    private int driverId;
    private String driverName;
    private int freightId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String startAddress;

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", vehicleId='" + vehicleId + '\'' +
                ", driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", freightId=" + freightId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startAddress='" + startAddress + '\'' +
                ", endAddress='" + endAddress + '\'' +
                ", status=" + status +
                '}';
    }

    public Record() {
    }

    public Record(String vehicleId, int driverId, String driverName, int freightId, Timestamp startTime, Timestamp endTime, String startAddress, String endAddress, int status) {
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.driverName = driverName;
        this.freightId = freightId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.status = status;
    }

    private String endAddress;
    private int status;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getFreightId() {
        return freightId;
    }

    public void setFreightId(int freightId) {
        this.freightId = freightId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
