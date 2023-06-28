package com.scu.freight.dao;

import com.scu.freight.entity.Record;
import com.scu.freight.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/25 8:07
 */
@Mapper
public interface UserMapper {
    User selectUserByUsernameAndPassword(String username,String password);

    int countRows(Integer userId, String username, Integer userRole);

    List<Record> selectRows(Integer userId, String username, Integer userRole, int startNo, Integer pageSize);

    int insertUser(User user);

    User selectUserById(int userId);

    int setUserRole(int userId, int userRole);

    int updateUser(User user);
}
