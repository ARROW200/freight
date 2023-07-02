package com.scu.freight.controller;

import com.scu.freight.entity.Vehicle;
import com.scu.freight.service.VehicleService;
import com.scu.freight.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 9:55
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/list")
    public Result<Map<String,Object>> getVehicleList(@RequestParam(required = false) String type, @RequestParam(required = false) String vehicleId, @RequestParam(required = false) Double load, @RequestParam(required = false) Integer status, Integer pageNo, Integer pageSize){
        if (StringUtils.isBlank(type)){
            type = null;
        }
        if (StringUtils.isBlank(vehicleId)){
            vehicleId = null;
        }
        Map<String,Object> data = vehicleService.getVehicleList(type,vehicleId,load,status,pageNo,pageSize);
        return Result.success(data);
    }

    @PostMapping("/add")
    public Result<?> addVehicle(@RequestBody Vehicle vehicle){
        int i = vehicleService.addVehicle(vehicle);
        if (i == 0){
            return Result.fail(507,"添加车辆信息失败");
        }
        return Result.success("添加车辆信息成功");
    }

    @PutMapping("/update")
    public Result<?> updateVehicle(@RequestBody Vehicle vehicle){
        int i = vehicleService.updateVehicle(vehicle);
        if (i == 0){
            return Result.fail(507,"修改车辆信息失败");
        }
        return Result.success("修改车辆信息成功");
    }

    @GetMapping("/{vehicleId}")
    public Result<Vehicle> getVehicleById(@PathVariable String vehicleId){
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
        if (vehicle == null){
            return Result.fail(404,"找不到该车辆信息");
        }
        return Result.success(vehicle);
    }

    @DeleteMapping("/{vehicleId}")
    public Result<?> deleteVehicleById(@PathVariable int vehicleId){
        int i = vehicleService.removeVehicleById(vehicleId);
        if (i == 0){
            return Result.fail(507,"删除车辆信息失败");
        }
        return Result.success("删除车辆信息成功");
    }
}
