package com.scu.freight.controller;

import com.scu.freight.entity.User;
import com.scu.freight.service.UserService;
import com.scu.freight.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hazel
 * @description 功能描述
 * @create 2023/6/24 15:46
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String t(){
        System.out.println("aaa");
        return "dasdas";
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user){
        Map<String,Object> data = userService.login(user);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误");
    }

    @GetMapping("/info")
    public Result<Map<String,Object>> info(@RequestParam String token){
        Map<String,Object> data = userService.getUserInfo(token);
        if (data != null){
            return Result.success(data);
        }
        return Result.fail(20003,"登录信息无效请重新登录");
    }

    @PostMapping("/logout")
    public Result<Map<String,Object>> logout(@RequestHeader("X-Token") String token){
        userService.logout(token);
        return Result.success();
    }

}
