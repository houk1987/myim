package com.myim.server.service.smack;

import org.jivesoftware.smack.*;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.stringprep.XmppStringprepException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Configuration {

    private String serverName="192.168.101.20";

    private int port=5222;

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
