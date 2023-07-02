package com.scu.freight.entity;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/24 18:32
 */
public class Freight {
    private int freightId;
    private String freightName;
    private String type;
    private double weight;
    private String description;
    private int status;

    @Override
    public String toString() {
        return "Freight{" +
                "freightId=" + freightId +
                ", freightName='" + freightName + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public Freight() {
    }

    public Freight(int freightId, String freightName, String type, double weight, String description, int status) {
        this.freightId = freightId;
        this.freightName = freightName;
        this.type = type;
        this.weight = weight;
        this.description = description;
        this.status = status;
    }

    public int getFreightId() {
        return freightId;
    }

    public void setFreightId(int freightId) {
        this.freightId = freightId;
    }

    public String getFreightName() {
        return freightName;
    }

    public void setFreightName(String freightName) {
        this.freightName = freightName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
