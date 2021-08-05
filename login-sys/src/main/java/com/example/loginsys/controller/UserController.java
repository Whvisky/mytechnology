package com.example.loginsys.controller;

import com.example.loginsys.pojo.User;
import com.example.loginsys.pojo.result.CommonResult;
import com.example.loginsys.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2021-08-01 17:19:46
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }


    @PostMapping("/register")
    public CommonResult<User> register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public CommonResult<User> login(@RequestBody User user){
        return userService.login(user);
    }

}