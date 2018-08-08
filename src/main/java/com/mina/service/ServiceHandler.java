package com.mina.service;

import org.apache.mina.api.AbstractIoHandler;
import org.apache.mina.api.IdleStatus;
import org.apache.mina.api.IoService;
import org.apache.mina.api.IoSession;
import org.apache.mina.session.AbstractIoSession;

import java.util.Map;

/***/
public class ServiceHandler extends AbstractIoHandler {

    private Map<Long ,IoSession> sessionMap  = ServiceManager.getInstance().getManagedSessions() ;


    @Override
    public void sessionOpened(IoSession session) {
        System.out.println("创建新连接 id= " +session.getId());
        super.sessionOpened(session);

    }

    @Override
    public void sessionClosed(IoSession session) {
        System.out.println("关闭连接 id= " +session.getId());
        sessionMap.remove(session.getId());
        super.sessionClosed(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) {
        super.sessionIdle(session, status);
    }

    @Override
    public void messageReceived(IoSession session, Object message) {


    }

    @Override
    public void messageSent(IoSession session, Object message) {
        super.messageSent(session, message);
    }

    @Override
    public void serviceActivated(IoService service) {
        super.serviceActivated(service);
    }

    @Override
    public void serviceInactivated(IoService service) {
        super.serviceInactivated(service);
    }
}
