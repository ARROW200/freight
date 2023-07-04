package com.scu.freight.service;

import com.scu.freight.dao.UserMapper;
import com.scu.freight.entity.Record;
import com.scu.freight.entity.User;
import com.scu.freight.util.FreightUtil;
import com.scu.freight.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/24 15:50
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public Map<String, Object> login(User user) {
        User loginUser = userMapper.selectUserByUsernameAndPassword(user.getUsername(), FreightUtil.md5(user.getPassword()));
        if (loginUser != null){
            String userKey = RedisKeyUtil.getUserKey(FreightUtil.generateUUID());

            redisTemplate.opsForValue().set(userKey,loginUser,30, TimeUnit.MINUTES);

            Map<String,Object> data = new HashMap<>();
            data.put("role",loginUser.getUserRole());
            data.put("token",userKey);
            return data;
        }
        return null;
    }

    public Map<String, Object> getUserInfo(String token) {
        User loginUser = (User) redisTemplate.opsForValue().get(token);
        if (loginUser != null){
            Map<String,Object> data = new HashMap<>();
            data.put("name",loginUser.getUsername());
            data.put("role",loginUser.getUserRole());
            return data;
        }
        return null;
    }

    public void logout(String token) {
        redisTemplate.delete(token);
    }

    public Map<String, Object> getUserList(Integer userId, String username, Integer userRole, Integer pageNo, Integer pageSize) {
        int total = userMapper.countRows(userId,username,userRole);
        int startNo = (pageNo-1)*pageSize;
        List<Record> rows = userMapper.selectRows(userId,username,userRole,startNo,pageSize);
        Map<String,Object> data = new HashMap<>();
        data.put("total", total);
        data.put("rows", rows);
        return data;
    }

    public int addUser(User user) {
        int i = userMapper.countRows(null, user.getUsername(), null);
        if (i > 0){
            return 0;
        }
        user.setPassword(FreightUtil.md5(user.getPassword()));
        return userMapper.insertUser(user);
    }

    public int updateUser(User user) {
        user.setPassword(FreightUtil.md5(user.getPassword()));
        return userMapper.updateUser(user);
    }

    public User getUserById(int userId) {
        return userMapper.selectUserById(userId);
    }

    public int removeUserById(int userId) {
        return userMapper.setUserRole(userId,0);
    }
}
