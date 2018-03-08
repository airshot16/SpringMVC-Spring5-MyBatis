package com.spring.service;

import com.spring.entity.UserEntity;
import com.spring.interfaces.mybatis.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户操作相关的业务逻辑层
 */
@Service
public class UserService {
    // 使用javax的注解实现bean的注入
    @Resource
    private UserMapper userMapper;

    public String getAllUser(){
        return "foo";
    }

    public String getUserById(String id){
        return id;
    }
}
