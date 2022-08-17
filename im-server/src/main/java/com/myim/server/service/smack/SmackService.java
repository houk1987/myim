package com.myim.server.service.smack;

import com.myim.server.vo.User;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SmackService {
    @Autowired
    private Configuration configuration;

    public void login(User user) {


    }

    private XMPPTCPConnection  createConnection() throws SmackException, IOException, XMPPException {

        return null;
    }


}
