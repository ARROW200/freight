package com.scu.freight.controller;

import com.scu.freight.entity.Company;
import com.scu.freight.service.CompanyService;
import com.scu.freight.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/26 9:54
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public Result<Map<String,Object>> getCompanyList(@RequestParam(required = false) Integer companyId, @RequestParam(required = false) String companyName, @RequestParam(required = false) String companyAddress, @RequestParam(required = false) String phone, Integer pageNo, Integer pageSize){
        if (StringUtils.isBlank(companyName)){
            companyName = null;
        }
        if (StringUtils.isBlank(companyAddress)){
            companyAddress = null;
        }
        if (StringUtils.isBlank(phone)){
            phone = null;
        }
        Map<String,Object> data = companyService.getCompanyList(companyId,companyName,companyAddress,phone,pageNo,pageSize);
        return Result.success(data);
    }

    @PostMapping("/add")
    public Result<?> addCompany(@RequestBody Company company){
        int i = companyService.addCompany(company);
        if (i == 0){
            return Result.fail(507,"添加公司信息失败");
        }
        return Result.success("添加公司信息成功");
    }

    @PutMapping("/update")
    public Result<?> updateCompany(@RequestBody Company company){
        int i = companyService.updateCompany(company);
        if (i == 0){
            return Result.fail(507,"修改公司信息失败");
        }
        return Result.success("修改公司信息成功");
    }

    @GetMapping("/{companyId}")
    public Result<Company> getCompanyById(@PathVariable int companyId){
        Company company = companyService.getCompanyById(companyId);
        if (company == null){
            return Result.fail(404,"找不到该货物信息");
        }
        return Result.success(company);
    }

    @DeleteMapping("/{companyId}")
    public Result<?> deleteCompanyById(@PathVariable int companyId){
        int i = companyService.removeCompanyById(companyId);
        if (i == 0){
            return Result.fail(507,"删除货物信息失败");
        }
        return Result.success("删除货物信息成功");
    }

}
