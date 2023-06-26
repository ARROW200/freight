package com.scu.freight.controller;

import com.scu.freight.entity.Record;
import com.scu.freight.service.RecordService;
import com.scu.freight.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/25 14:11
 */
@RestController
@RequestMapping("/record")
@CrossOrigin
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/list")
    public Result<Map<String,Object>> getRecordList(@RequestParam(required = false) String vehicleId, @RequestParam(required = false) String driverName, @RequestParam(required = false) Integer freightId, @RequestParam(required = false) Integer recordId, Integer pageNo, Integer pageSize){
        if (pageNo == null){
            pageNo = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        Map<String,Object> data = recordService.getRecordList(vehicleId,driverName,freightId,recordId,pageNo,pageSize);
        return Result.success(data);
    }
}
