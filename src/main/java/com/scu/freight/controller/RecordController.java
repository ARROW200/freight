package com.scu.freight.controller;

import com.scu.freight.entity.Record;
import com.scu.freight.entity.User;
import com.scu.freight.service.RecordService;
import com.scu.freight.vo.Result;
import org.apache.commons.lang3.StringUtils;
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
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/list")
    public Result<Map<String,Object>> getRecordList(@RequestParam(required = false) String vehicleId, @RequestParam(required = false) String driverName, @RequestParam(required = false) Integer freightId, @RequestParam(required = false) Integer recordId, @RequestParam(required = false) Integer taskId, Integer pageNo, Integer pageSize){
        if (StringUtils.isBlank(vehicleId)){
            vehicleId = null;
        }
        if (StringUtils.isBlank(driverName)){
            driverName = null;
        }
        Map<String,Object> data = recordService.getRecordList(vehicleId,driverName,freightId,recordId,taskId,pageNo,pageSize);
        return Result.success(data);
    }

    @PostMapping("/add")
    public Result<?> addRecord(@RequestBody Record record){
        int i = recordService.addRecord(record);
        if (i == 0){
            return Result.fail(507,"添加记录失败");
        }
        return Result.success("添加记录成功");
    }

    @PutMapping("/update")
    public Result<?> updateRecord(@RequestBody Record record){
        int i = recordService.updateRecord(record);
        if (i == 0){
            return Result.fail(507,"修改记录失败");
        }
        return Result.success("修改记录成功");
    }

    @GetMapping("/{recordId}")
    public Result<Record> getRecordById(@PathVariable int recordId){
        Record record = recordService.getRecordById(recordId);
        if (record == null){
            return Result.fail(404,"找不到该记录");
        }
        return Result.success(record);
    }

    @DeleteMapping("/{recordId}")
    public Result<?> deleteRecordById(@PathVariable int recordId){
        int i = recordService.removeRecordById(recordId);
        if (i == 0){
            return Result.fail(507,"删除记录失败");
        }
        return Result.success("删除记录成功");
    }
}
