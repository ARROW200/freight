package com.scu.freight.service;

import com.scu.freight.dao.FreightMapper;
import com.scu.freight.entity.Freight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 10:01
 */
@Service
public class FreightService {

    @Autowired
    private FreightMapper freightMapper;

    public Map<String, Object> getFreightList(String type, String freightName, Integer freightId, Double weight, Integer pageNo, Integer pageSize) {
        int total = freightMapper.countRows(type,freightName,freightId,weight);
        int startNo = (pageNo-1)*pageSize;
        List<Freight> rows = freightMapper.selectRows(type,freightName,freightId,weight,startNo,pageSize);
        Map<String,Object> data = new HashMap<>();
        data.put("total", total);
        data.put("rows", rows);
        return data;
    }

    public int addFreight(Freight freight) {
        return freightMapper.insertFreight(freight);
    }

    public Freight getFreightById(int freightId) {
        return freightMapper.selectFreightById(freightId);
    }

    public int updateFreight(Freight freight) {
        return freightMapper.updateFreight(freight);
    }

    public int removeFreightById(int freightId) {
        return freightMapper.setFreightStatus(freightId, 0);
    }
}
