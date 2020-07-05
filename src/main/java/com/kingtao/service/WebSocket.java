package com.kingtao.service;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
public class WebSocket {
    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();


    @OnOpen

    public void onOpen(Session session){

        this.session=session;

        webSocketSet.add(this);


    }

    @OnClose

    public void onClose() {

        webSocketSet.remove(this);
    }

    @OnMessage

    public void onMessage(String message){

        System.out.println("【websocket消息】 收到客户端发来的消息:"+message);

    }

    public void sendMessage(String message){
        for (WebSocket webSocket : webSocketSet) {
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
