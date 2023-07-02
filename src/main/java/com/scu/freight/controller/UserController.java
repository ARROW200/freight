package com.scu.freight.controller;

import com.scu.freight.entity.User;
import com.scu.freight.service.UserService;
import com.scu.freight.vo.Result;
import org.apache.commons.lang3.StringUtils;
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

    @GetMapping("/list")
    public Result<Map<String,Object>> getUserList(@RequestParam(required = false) Integer userId, @RequestParam(required = false) String username, @RequestParam(required = false) Integer userRole, Integer pageNo, Integer pageSize){
        if (StringUtils.isBlank(username)){
            username = null;
        }
        Map<String,Object> data = userService.getUserList(userId,username,userRole,pageNo,pageSize);
        return Result.success(data);
    }

    @PostMapping("/add")
    public Result<?> addUser(@RequestBody User user){
        int i = userService.addUser(user);
        if (i == 0){
            return Result.fail(507,"添加用户失败");
        }
        return Result.success("添加用户成功");
    }

    @PutMapping("/update")
    public Result<?> updateUser(@RequestBody User user){
        int i = userService.updateUser(user);
        if (i == 0){
            return Result.fail(507,"修改用户信息失败");
        }
        return Result.success("修改用户信息成功");
    }

    @GetMapping("/{userId}")
    public Result<User> getRecordById(@PathVariable int userId){
        User user = userService.getUserById(userId);
        if (user == null){
            return Result.fail(404,"找不到该用户");
        }
        return Result.success(user);
    }

    @DeleteMapping("/{userId}")
    public Result<?> deleteUserById(@PathVariable int userId){
        int i = userService.removeUserById(userId);
        if (i == 0){
            return Result.fail(507,"删除用户失败");
        }
        return Result.success("删除用户成功");
    }

}
