package com.mina.client;


import org.apache.mina.api.AbstractIoHandler;
import org.apache.mina.api.IdleStatus;
import org.apache.mina.api.IoService;
import org.apache.mina.api.IoSession;

import java.util.concurrent.ConcurrentHashMap;

/***/
public class ClientHandler extends AbstractIoHandler {


    private static ConcurrentHashMap<String,IoSession> sessionpool= new ConcurrentHashMap();

    public static ConcurrentHashMap<String, IoSession> getSessionpool() {
        return sessionpool;
    }

    @Override
    public void sessionOpened(IoSession ioSession) {
        System.out.println("连接成功 ："+ ioSession.getId());
    }

    @Override
    public void sessionClosed(IoSession ioSession) {
        System.out.println("断开成功 ："+ ioSession.getId());
    }

    @Override
    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) {

    }

    @Override
    public void messageReceived(IoSession ioSession, Object o) {
        System.out.println("收到消息 ："+ o.toString());
    }

    @Override
    public void messageSent(IoSession ioSession, Object o) {
        System.out.println("发送消息 ："+ o.toString());
    }

    @Override
    public void serviceActivated(IoService ioService) {
        System.out.println("服务器是否连接");
    }

    @Override
    public void serviceInactivated(IoService ioService) {

    }

    @Override
    public void exceptionCaught(IoSession ioSession, Exception e) {

    }
}
