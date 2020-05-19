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
@ServerEndpoint(value = "/productWebSocket/{userId}", configurator = MyEndpointConfigure.class)
public class ProductWebSocket {

    // 安全线程：在线人数
    private static final AtomicInteger OnlineCount = new AtomicInteger(0);

    // concurrent包的线程安全Set，用来存放客户端对应的ProductWebSocket对象。
    private static CopyOnWriteArraySet<ProductWebSocket> webSocketSet = new CopyOnWriteArraySet<ProductWebSocket>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;


    private Logger log = LoggerFactory.getLogger(ProductWebSocket.class);


    @OnOpen
    public void onOpen(@PathParam("userId")String userId, Session session) {
        log.info("有用启进入，id：" + userId);
        this.session = session;
        webSocketSet.add(this); // 加入set中
        addOnlineCount(); // 在线数加1
        if(userId!=null) {
            List<String> totalPushMsgs = new ArrayList<String>();
            totalPushMsgs.add(userId+"成功连接-"+"-在线人数："+getOnlineCount());


            if(totalPushMsgs != null && !totalPushMsgs.isEmpty()) {
                totalPushMsgs.forEach(e -> sendMessage(e));
            }
        }

    }


    @OnClose
    public void onClose() {
        log.info("一个客户端退出连接");
        webSocketSet.remove(this); // 从set中删除
        subOnlineCount(); // 在线数减1
    }


    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到客户端消息："+message);
        System.out.println("收到客户端消息："+message);
    }


    @OnError
    public void onError(Session session, Throwable error) {
        log.error("websocket出现错误");
        error.printStackTrace();
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
            log.info("推送成功-消息内容：" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendInfo(String message) throws IOException {
        for (ProductWebSocket productWebSocket : webSocketSet) {
            System.out.println("服务器群发消息内容："+message);
            productWebSocket.sendMessage(message);
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
