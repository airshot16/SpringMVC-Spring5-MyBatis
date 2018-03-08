package com.spring.controller;

import com.spring.annotaion.LoginCheck;
import com.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

// rest风格的控制器注解
@RestController
//uri注解
@RequestMapping("/user")
public class UserController {
    // 使用javax的注解实现bean的注入
    @Resource
    private UserService userService;

    // rest风格 查询单条数据时,id直接写url中
    @LoginCheck(apiName = "get a user names")
    @GetMapping("/get/{id}")
    public Object get(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @LoginCheck(apiName = "get all user names")
    @GetMapping("/get")
    public Object getAllUserName() {
        return userService.getAllUser();
    }
}
