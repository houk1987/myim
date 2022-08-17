package com.myim.server.service.smack;

import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.chat2.IncomingChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    /**
     * 向指定用户发送消息
     *
     * @param username
     * @param message
     * @throws Exception
     */
    public void sendMessage(XMPPTCPConnection connection,String username, String message) throws Exception {
        ChatManager chatManager = ChatManager.getInstanceFor(connection);
        EntityBareJid jid = JidCreate.entityBareFrom(username + "@" + connection.getXMPPServiceDomain());
        Chat chat = chatManager.chatWith(jid);
        Message newMessage = new Message();
        newMessage.setBody(message);
        chat.send(message);
    }

    /**
     * 添加聊天消息监听
     *
     * @param chatManagerListener
     * @throws Exception
     */
    public void addChatMessageListener(XMPPTCPConnection connection,ChatManagerListener chatManagerListener) throws Exception {
        ChatManager chatManager = ChatManager.getInstanceFor(connection);
        chatManager.addIncomingListener(new IncomingChatMessageListener() {
            @Override
            public void newIncomingMessage(EntityBareJid entityBareJid, Message message, Chat chat) {

            }
        });
    }
}
