package com.ecs.monitor.service;


import com.ecs.monitor.config.MyEndpointConfigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;


@Component
@ServerEndpoint(value = "/sys_msg/{userId}", configurator = MyEndpointConfigure.class)
public class SystemNotify {

    private static final AtomicInteger OnlineCount = new AtomicInteger(0); //安全线程：在线人数

    private static CopyOnWriteArraySet<SystemNotify> webSocketSet = new CopyOnWriteArraySet<SystemNotify>();// concurrent包的线程安全Set，用来存放客户端对应的ProductWebSocket对象。

    private Session session;    //与客户端的连接会话

    private Logger log = LoggerFactory.getLogger(SystemNotify.class);


    @OnOpen
    public void onOpen(@PathParam("userId")String userId, Session session) {
        log.info("current time__"+System.currentTimeMillis()+"__manager into system,user id：" + userId);
        this.session = session;
        webSocketSet.add(this); // 加入set中
        addOnlineCount();       // 在线数加1
        if(userId!=null) {
            List<String> totalPushMsgs = new ArrayList<String>();
            totalPushMsgs.add(userId+"connect success("+getOnlineCount()+")");


            if(totalPushMsgs != null && !totalPushMsgs.isEmpty()) {
                totalPushMsgs.forEach(e -> sendMessage(e));
            }
        }

    }

    @OnClose
    public void onClose() {
        log.info("current time__"+System.currentTimeMillis()+"__manager into system,user：" + this);
        webSocketSet.remove(this); // 从set中删除
        subOnlineCount(); // 登录管理者数量
    }


    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("current time__"+System.currentTimeMillis()+"__get client message："+message); //收消息
    }


    @OnError
    public void onError(Session session, Throwable error) {
        log.error("current time__"+System.currentTimeMillis()+"websocket onError");
        error.printStackTrace();
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
            log.info("current time__"+System.currentTimeMillis()+"service send message：" + message);//服单发
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendInfo(String message) throws IOException {
        for (SystemNotify notify : webSocketSet) {
            System.out.println("service broadcast ："+message); //服群发
            notify.sendMessage(message);
        }
    }

    public static synchronized int getOnlineCount() {
        System.out.println("当前在线人数："+OnlineCount.get());
        return OnlineCount.get();
    }

    public static synchronized void addOnlineCount() {
        OnlineCount.incrementAndGet(); // 在线数+1
    }

    public static synchronized void subOnlineCount() {
        OnlineCount.decrementAndGet(); // 在线数-1
    }
}
