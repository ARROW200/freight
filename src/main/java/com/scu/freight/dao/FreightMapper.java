package com.scu.freight.dao;

import com.scu.freight.entity.Freight;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 10:03
 */
@Mapper
public interface FreightMapper {

    int countRows(String type, String freightName, Integer freightId, Double weight);

    List<Freight> selectRows(String type, String freightName, Integer freightId, Double weight, int startNo, Integer pageSize);

    int insertFreight(Freight freight);

    Freight selectFreightById(int freightId);

    int updateFreight(Freight freight);

    int setFreightStatus(int freightId, int status);
}
