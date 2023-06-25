package com.scu.freight.dao;

import com.scu.freight.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/25 8:07
 */
@Mapper
public interface UserMapper {
    User selectUserByUsernameAndPassword(String username,String password);
}
