package com.myim.server.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam String account,@RequestParam String pwd){
        String result = "";
        if ("hk".equals(account)&&"123".equals(pwd)){
            result = "登录成功";
        }else {
            result ="登录失败";
        }
        return result;

    }
}
