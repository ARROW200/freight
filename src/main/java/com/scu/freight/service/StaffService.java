package com.scu.freight.service;

import com.scu.freight.dao.StaffMapper;
import com.scu.freight.entity.Record;
import com.scu.freight.entity.Staff;
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
public class StaffService {
    @Autowired
    private StaffMapper staffMapper;

    public Map<String, Object> getStaffList(Integer staffId, String staffName, Integer staffRole, Integer pageNo, Integer pageSize) {
        int total = staffMapper.countRows(staffId,staffName,staffRole);
        int startNo = (pageNo-1)*pageSize;
        List<Staff> rows = staffMapper.selectRows(staffId,staffName,staffRole,startNo,pageSize);
        Map<String,Object> data = new HashMap<>();
        data.put("total", total);
        data.put("rows", rows);
        return data;
    }

    public int addStaff(Staff staff) {
        return staffMapper.insertStaff(staff);
    }

    public int updateStaff(Staff staff) {
        return staffMapper.updateStaff(staff);
    }

    public Staff getStaffById(int staffId) {
        return staffMapper.selectStaffById(staffId);
    }

    public int removeStaffById(int staffId) {
        return staffMapper.setStaffStatus(staffId,0);
    }
}
