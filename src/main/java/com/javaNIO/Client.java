package com.javaNIO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/***/
public class Client {

    private String host;
    private int port;
    private SocketChannel socketChannel;
    private Selector selector;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void init(){
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.socket().setTcpNoDelay(true);
            socketChannel.connect(new InetSocketAddress(host, port));
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            System.out.println("客户端开启成功");
            while (true)
            accept();
        }catch (IOException e){
            System.out.println("初始化失败  io异常");
        }
    }

    public void accept() throws IOException {
        int event = selector.select();
        if(event != 0) {
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while(it.hasNext()) {
                SelectionKey sk = it.next();
                it.remove();
                if(sk.isValid() && sk.isConnectable()) {
                    if(socketChannel.isConnectionPending()) {
                        if(socketChannel.finishConnect()) {
                            sk.interestOps(SelectionKey.OP_READ);
                        } else {
                            sk.cancel();
                        }
                    }
                } else if(sk.isValid() && sk.isReadable()) {
                    SocketChannel sc = (SocketChannel) sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int size = -1;
                    while((size = sc.read(buffer)) > 0) {
                        buffer.flip();
                        baos.write(buffer.array(), 0, size);
                        buffer.clear();
                    }
                    String s= baos.toString();
                    System.out.println("收到服务端数据" + s);
                }
            }
        }
    }



    public void close() {
        try {
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String msg) {
        byte[] b = msg.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(b);
        try {
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 3333);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                client.init();
            }
        });
        thread.setDaemon(true);
        thread.start();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String msg = scanner.nextLine();
            if("close".equals(msg)) {
                client.close();
                System.out.println("退出成功");
                break;
            } else {
                client.send(msg);
            }
        }
    }


}
