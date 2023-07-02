package com.scu.freight.dao;

import com.scu.freight.entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 10:02
 */
@Mapper
public interface VehicleMapper {
    int countRows(String type, String vehicleId, Double load, Integer status);

    List<Vehicle> selectRows(String type, String vehicleId, Double load, Integer status, int startNo, Integer pageSize);

    int insertVehicle(Vehicle vehicle);

    int updateVehicle(Vehicle vehicle);

    Vehicle selectVehicleById(String vehicleId);

    int setVehicleStatus(int vehicleId, int status);
}
