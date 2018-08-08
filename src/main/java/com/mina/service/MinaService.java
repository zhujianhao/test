package com.mina.service;

import org.apache.mina.api.IdleStatus;
import org.apache.mina.api.IoService;
import org.apache.mina.codec.ProtocolEncoder;
import org.apache.mina.codec.delimited.ByteBufferEncoder;
import org.apache.mina.codec.delimited.serialization.JavaNativeMessageDecoder;
import org.apache.mina.codec.delimited.serialization.JavaNativeMessageEncoder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.nio.NioTcpServer;

import javax.xml.ws.Service;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/***/
public class MinaService {

    public static void main(String[] args) throws IOException {
         NioTcpServer service = (NioTcpServer)ServiceManager.getInstance();
        //添加日志过滤器
        ProtocolCodecFilter protocolCodecFilter =
                new ProtocolCodecFilter(new JavaNativeMessageEncoder(),new JavaNativeMessageDecoder());
        service.setFilters(new LoggingFilter(),protocolCodecFilter);
        service.getSessionConfig().setIdleTimeInMillis(IdleStatus.READ_IDLE,10000);
        service.getSessionConfig().setReadBufferSize(2048);
        try {
            service.bind(8081);
            service.setIoHandler(new ServiceHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("启动服务。。。。");
        System.in.read();
    }

}
