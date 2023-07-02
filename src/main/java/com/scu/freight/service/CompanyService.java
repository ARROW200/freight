package com.scu.freight.service;

import com.scu.freight.dao.CompanyMapper;
import com.scu.freight.entity.Company;
import com.scu.freight.entity.Freight;
import com.scu.freight.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 9:59
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    public Map<String, Object> getCompanyList(Integer companyId, String companyName, String companyAddress, String phone, Integer pageNo, Integer pageSize) {
        int total = companyMapper.countRows(companyId,companyName,companyAddress,phone);
        int startNo = (pageNo-1)*pageSize;
        List<Freight> rows = companyMapper.selectRows(companyId,companyName,companyAddress,phone,startNo,pageSize);
        Map<String,Object> data = new HashMap<>();
        data.put("total", total);
        data.put("rows", rows);
        return data;
    }

    public int addCompany(Company company) {
        return companyMapper.insertCompany(company);
    }

    public int updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    public Company getCompanyById(int companyId) {
        return companyMapper.selectCompanyById(companyId);
    }

    public int removeCompanyById(int companyId) {
        return companyMapper.setCompanyStatus(companyId, 0);
    }
}
