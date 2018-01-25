package com.kelin.springboot.websocket;

import org.springframework.stereotype.Controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Author: Mr.tan
 * Date:  2018/01/18 18:49
 * Description: 简单web socket测试
 */
@Controller
@ServerEndpoint(value = "/ws")
public class MyWebSocket {


    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<Session> sessionSet = new CopyOnWriteArraySet<Session>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        sessionSet.add(session);     //加入set中
        sendMessage("连接成功", session);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        sessionSet.remove(this);  //从set中删除
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("来自客户端的消息:" + message);

        //群发消息
        sendAll("欢迎光临");
    }

    /**
     * 群发自定义消息
     */
    private void sendAll(String message) {
        for (Session item : sessionSet) {
            sendMessage(message, item);

        }
    }

    /**
     * 单发消息
     */
    private void sendMessage(String message, Session session) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
