package com.scu.freight.dao;

import com.scu.freight.entity.Company;
import com.scu.freight.entity.Freight;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 10:04
 */
@Mapper
public interface CompanyMapper {
    int countRows(Integer companyId, String companyName, String companyAddress, String phone);

    List<Freight> selectRows(Integer companyId, String companyName, String companyAddress, String phone, int startNo, Integer pageSize);

    int insertCompany(Company company);

    Company selectCompanyById(int companyId);

    int updateCompany(Company company);

    int setCompanyStatus(int companyId, int status);
}
