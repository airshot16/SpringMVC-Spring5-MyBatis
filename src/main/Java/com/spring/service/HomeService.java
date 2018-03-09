package com.spring.service;

import com.spring.common.util.MD5Util;
import com.spring.interfaces.mybatis.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 用户操作相关的业务逻辑层
 */
@Service
public class HomeService {
    // 使用javax的注解实现bean的注入
    @Resource
    private UserMapper userMapper;
    @Resource
    private MD5Util md5Util;

    public boolean login(String userName, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return userMapper.login(userName, md5Util.md5(password)) == 1;
    }
}
