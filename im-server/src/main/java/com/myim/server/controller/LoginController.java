package com.myim.server.controller;


import com.myim.server.vo.User;
import com.myim.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(@RequestParam String account,@RequestParam String pwd){
        return loginService.login(new User(account,pwd));
    }
}
