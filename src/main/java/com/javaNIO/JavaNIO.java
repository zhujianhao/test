package com.javaNIO;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.nio.ch.SelectionKeyImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***/
public class JavaNIO {

    /**
     * 端口
     * */
    private Integer port;
    /**
     * 通道
     * */
    private ServerSocketChannel serverSocketChannel;
    /**
     * 选择器
     * */
    private Selector selector;
    /**
     * 线程池
     * */
    private static  ExecutorService executorService ;

    public JavaNIO(Integer port) {
        this.port = port;
    }




    public void doService() throws IOException, InterruptedException {
        try {
            executorService = Executors.newCachedThreadPool();
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务端初始化成功");
        }catch (IOException e) {
            System.out.println("服务端初始化失败"+e.toString());
        }
        while(true) {
            int event = selector.select();//event 返回准备好的个数
            System.out.println("事件："+event);
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                inPool(key);
                it.remove();
            }
        }


    }

    private void inPool(SelectionKey key){
        try {
            if (key.isValid() && key.isAcceptable()) {
                ServerSocketChannel server = (ServerSocketChannel) key.channel();
                SocketChannel channel = server.accept();
                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);
            } else if (key.isValid() && key.isReadable()) {
                key.interestOps(0);
                executorService.execute(new Task(key));
            }
        }catch (IOException e){
            System.out.println("IO 异常");
        }
    }


}
