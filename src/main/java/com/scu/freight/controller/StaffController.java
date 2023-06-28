package com.scu.freight.controller;

import com.scu.freight.entity.Record;
import com.scu.freight.entity.Staff;
import com.scu.freight.service.StaffService;
import com.scu.freight.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 9:56
 */
@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/list")
    public Result<Map<String,Object>> getStaffList(@RequestParam(required = false) Integer staffId, @RequestParam(required = false) String staffName, @RequestParam(required = false) Integer staffRole, Integer pageNo, Integer pageSize){
        if (StringUtils.isBlank(staffName)){
            staffName = null;
        }
        Map<String,Object> data = staffService.getStaffList(staffId,staffName,staffRole,pageNo,pageSize);
        return Result.success(data);
    }

    @PostMapping("/add")
    public Result<?> addRecord(@RequestBody Staff staff){
        int i = staffService.addStaff(staff);
        if (i == 0){
            return Result.fail(507,"添加员工失败");
        }
        return Result.success("添加员工成功");
    }

    @PutMapping("/update")
    public Result<?> updateRecord(@RequestBody Staff staff){
        int i = staffService.updateStaff(staff);
        if (i == 0){
            return Result.fail(507,"修改员工信息失败");
        }
        return Result.success("修改员工信息成功");
    }

    @GetMapping("/{staffId}")
    public Result<Staff> getStaffById(@PathVariable int staffId){
        Staff staff = staffService.getStaffById(staffId);
        if (staff == null){
            return Result.fail(404,"找不到该员工信息");
        }
        return Result.success(staff);
    }

    @DeleteMapping("/{staffId}")
    public Result<?> deleteStaffById(@PathVariable int staffId){
        int i = staffService.removeStaffById(staffId);
        if (i == 0){
            return Result.fail(507,"删除员工信息失败");
        }
        return Result.success("删除员工信息成功");
    }
}
