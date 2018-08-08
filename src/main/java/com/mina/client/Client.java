package com.mina.client;

import org.apache.mina.api.IdleStatus;
import org.apache.mina.api.IoSession;
import org.apache.mina.transport.ConnectFuture;
import org.apache.mina.transport.nio.NioTcpClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***/
public class Client {

    public static  Runnable init(){

        NioTcpClient client = (NioTcpClient)ClientManager.getInstance();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",8081);


        client.setIoHandler(new ClientHandler());
        client.getSessionConfig().setIdleTimeInMillis(IdleStatus.READ_IDLE,10000);
        client.getSessionConfig().setIdleTimeInMillis(IdleStatus.WRITE_IDLE,10000);
        Runnable runable = new Runnable(){

            @Override
            public void run() {
                ConnectFuture future = (ConnectFuture)client.connect(inetSocketAddress);
                if(future.isDone()){
                    try {
                        Lock lock = new ReentrantLock();
                        IoSession session = future.get();
                        Long id = session.getId();
                        while(true){
                            lock.lock();
                            session.write(id+" speak");
                            Thread.sleep(500);
                            lock.unlock();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
       return runable;
    }

    public static void main(String[] args) throws IOException {
        new Thread(init()).start();
        new Thread(init()).start();
        System.in.read();

    }
}
