package com.mina.client;


import org.apache.mina.api.IoClient;
import org.apache.mina.api.IoService;
import org.apache.mina.transport.nio.NioTcpClient;
import org.apache.mina.transport.nio.NioTcpServer;

/***/
public class ClientManager {

    private static IoClient ioService=new NioTcpClient();

    public static  IoClient getInstance(){
        return ioService;
    }

}
