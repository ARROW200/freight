package com.scu.freight.controller;

import com.scu.freight.entity.Freight;
import com.scu.freight.service.FreightService;
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
@RequestMapping("/freight")
public class FreightController {
    @Autowired
    private FreightService freightService;

    @GetMapping("/list")
    public Result<Map<String,Object>> getFreightList(@RequestParam(required = false) String type, @RequestParam(required = false) String freightName, @RequestParam(required = false) Integer freightId, @RequestParam(required = false) Double weight, Integer pageNo, Integer pageSize){
        if (StringUtils.isBlank(type)){
            type = null;
        }
        if (StringUtils.isBlank(freightName)){
            freightName = null;
        }
        Map<String,Object> data = freightService.getFreightList(type,freightName,freightId,weight,pageNo,pageSize);
        return Result.success(data);
    }

    @PostMapping("/add")
    public Result<?> addFreight(@RequestBody Freight freight){
        int i = freightService.addFreight(freight);
        if (i == 0){
            return Result.fail(507,"添加货物信息失败");
        }
        return Result.success("添加货物信息成功");
    }

    @PutMapping("/update")
    public Result<?> updateFreight(@RequestBody Freight freight){
        int i = freightService.updateFreight(freight);
        if (i == 0){
            return Result.fail(507,"修改货物信息失败");
        }
        return Result.success("修改货物信息成功");
    }

    @GetMapping("/{freightId}")
    public Result<Freight> getFreightById(@PathVariable int freightId){
        Freight freight = freightService.getFreightById(freightId);
        if (freight == null){
            return Result.fail(404,"找不到该货物信息");
        }
        return Result.success(freight);
    }

    @DeleteMapping("/{freightId}")
    public Result<?> deleteFreightById(@PathVariable int freightId){
        int i = freightService.removeFreightById(freightId);
        if (i == 0){
            return Result.fail(507,"删除货物信息失败");
        }
        return Result.success("删除货物信息成功");
    }
}
