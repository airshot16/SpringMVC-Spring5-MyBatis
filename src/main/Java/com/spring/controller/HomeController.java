package com.spring.controller;

import com.spring.entity.HttpResultEntity;
import com.spring.service.HomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("home")
public class HomeController extends BaseController {

    @Resource
    private HomeService homeService;

    @PostMapping("login")
    public Object userLogin(@RequestParam String userName, @RequestParam String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        boolean loginResult = homeService.login(userName, password);
        if (loginResult) {
            return Ok(new HttpResultEntity(HttpResultEntity.Code.Success, "登入成功", null));
        } else {
            return BadRequest(new HttpResultEntity(HttpResultEntity.Code.Error, "登入失败", null));
        }
    }
}
