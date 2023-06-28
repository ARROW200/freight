package com.scu.freight.dao;

import com.scu.freight.entity.Record;
import com.scu.freight.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 10:02
 */
@Mapper
public interface StaffMapper {
    int countRows(Integer staffId, String staffName, Integer staffRole);

    List<Staff> selectRows(Integer staffId, String staffName, Integer staffRole, int startNo, Integer pageSize);

    int insertStaff(Staff staff);

    int updateStaff(Staff staff);

    Staff selectStaffById(int staffId);

    int setStaffStatus(int staffId, int status);
}
