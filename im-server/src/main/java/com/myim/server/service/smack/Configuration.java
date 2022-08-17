package com.myim.server.service.smack;

import org.jivesoftware.smack.*;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.iqregister.AccountManager;
import org.jxmpp.jid.parts.Localpart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class Configuration {

    private String serverName="h7.maxlink.top";

    private int port=11008;

    public XMPPTCPConnectionConfiguration getXMPPTCPConnectionConfiguration() throws XmppStringprepException {
        XMPPTCPConnectionConfiguration.Builder builder = XMPPTCPConnectionConfiguration.builder();
        builder.setXmppDomain(this.serverName);
        builder.setHost(this.serverName);
        builder.setPort(this.port);
        builder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        builder.setCompressionEnabled(true);
        builder.setConnectTimeout(30000);
        builder.setDebuggerFactory(SmackConfiguration.getDefaultSmackDebuggerFactory());
        SASLAuthentication.blacklistSASLMechanism("CRAM-MD5");
        SASLAuthentication.blacklistSASLMechanism("DIGEST-MD5");
        SASLAuthentication.unBlacklistSASLMechanism("PLAIN");
        return builder.build();
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }



    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        try {
            XMPPTCPConnection connection = new XMPPTCPConnection(configuration.getXMPPTCPConnectionConfiguration());
            connection.connect();
            connection.login("test","123");
            connection.login("test3","123");
//            AccountManager.sensitiveOperationOverInsecureConnectionDefault(true);
//            AccountManager accountManager = AccountManager.getInstance(connection);

//            Map<String, String> map = new HashMap<String, String>();
//            String usr="test3";
//            String pwd="hkqaz123";
//            String email ="houk@gmail.com";
//            map.put("username", usr);
//            map.put("name", usr);
//            map.put("password", pwd);
//            map.put("email", email);
//            accountManager.createAccount(Localpart.fromOrThrowUnchecked(usr),"123",map);

            while (true){

            }
        } catch (XmppStringprepException e) {
            throw new RuntimeException(e);
        } catch (SmackException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (XMPPException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
