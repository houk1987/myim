package com.myim.server.service;

import com.myim.server.service.smack.SmackService;
import com.myim.server.vo.User;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 登录服务
 */
@Service
public class LoginService {

    @Autowired
    private SmackService smackService;

    public String login(User user){
       return null;

    }
}
