package com.scu.freight.service;

import com.scu.freight.dao.UserMapper;
import com.scu.freight.entity.User;
import com.scu.freight.util.FreightUtil;
import com.scu.freight.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
