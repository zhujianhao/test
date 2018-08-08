package com.mina.service;

import org.apache.mina.api.IoService;
import org.apache.mina.transport.nio.NioTcpServer;

/***/
public  class ServiceManager {

    private static IoService ioService=new NioTcpServer();

    public static  IoService getInstance(){
        return ioService;
    }

}
