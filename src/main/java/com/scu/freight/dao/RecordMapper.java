package com.scu.freight.dao;

import com.scu.freight.entity.Record;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/25 14:13
 */
@Mapper
public interface RecordMapper {
    int countRows(String vehicleId, String driverName, Integer freightId, Integer recordId);

    List<Record> selectRows(String vehicleId, String driverName, Integer freightId, Integer recordId, int startNo, int pageSize);

    int insertRecord(Record record);

    Record selectRecordById(int recordId);

    int updateRecord(Record record);

    int setRecordStatus(int recordId, int status);
}
