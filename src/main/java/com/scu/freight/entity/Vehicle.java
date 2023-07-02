package com.scu.freight.entity;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/24 18:31
 */
public class Vehicle {
    private String vehicleId;
    private String type;
    private double load;
    private int status;

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", type='" + type + '\'' +
                ", load=" + load +
                ", status=" + status +
                '}';
    }

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String type, double load, int status) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.load = load;
        this.status = status;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
