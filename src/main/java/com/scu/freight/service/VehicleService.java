package com.scu.freight.service;

import com.scu.freight.dao.VehicleMapper;
import com.scu.freight.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 10:00
 */
@Service
public class VehicleService {
    @Autowired
    private VehicleMapper vehicleMapper;

    public Map<String, Object> getVehicleList(String type, String vehicleId, Double load, Integer status, Integer pageNo, Integer pageSize) {
        int total = vehicleMapper.countRows(type,vehicleId,load,status);
        int startNo = (pageNo-1)*pageSize;
        List<Vehicle> rows = vehicleMapper.selectRows(type,vehicleId,load,status,startNo,pageSize);
        Map<String,Object> data = new HashMap<>();
        data.put("total", total);
        data.put("rows", rows);
        return data;
    }

    public int addVehicle(Vehicle vehicle) {
        return vehicleMapper.insertVehicle(vehicle);
    }

    public int updateVehicle(Vehicle vehicle) {
        return vehicleMapper.updateVehicle(vehicle);
    }

    public Vehicle getVehicleById(String vehicleId) {
        return vehicleMapper.selectVehicleById(vehicleId);
    }

    public int removeVehicleById(int vehicleId) {
        return vehicleMapper.setVehicleStatus(vehicleId,0);
    }
}
