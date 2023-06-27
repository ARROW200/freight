package com.scu.freight.service;

import com.scu.freight.dao.RecordMapper;
import com.scu.freight.dao.StaffMapper;
import com.scu.freight.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/25 14:12
 */
@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

//    @Autowired
//    private StaffMapper staffMapper;

    public Map<String, Object> getRecordList(String vehicleId, String driverName, Integer freightId, Integer recordId, int pageNo, int pageSize) {
        int total = recordMapper.countRows(vehicleId,driverName,freightId,recordId);
        int startNo = (pageNo-1)*pageSize;
        List<Record> rows = recordMapper.selectRows(vehicleId,driverName,freightId,recordId,startNo,pageSize);
        Map<String,Object> data = new HashMap<>();
        data.put("total", total);
        data.put("rows", rows);
        return data;
    }

    public int addRecord(Record record) {
        record.setDriverName("A");
        return recordMapper.insertRecord(record);
    }

    public Record getRecordById(int recordId) {
        return recordMapper.selectRecordById(recordId);
    }

    public int updateRecord(Record record) {
        record.setDriverName("A");
        return recordMapper.updateRecord(record);
    }

    public int removeRecordById(int recordId) {
        return recordMapper.setRecordStatus(recordId, 2);
    }
}
