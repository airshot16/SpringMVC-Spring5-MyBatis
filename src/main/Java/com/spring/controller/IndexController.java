package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页以及一些根目录下的接口
 */
@Controller
public class IndexController {
    // 首页
    @GetMapping(value = "/")
    public String index() {
        return "redirect:/html/home/login.html";
    }
}
