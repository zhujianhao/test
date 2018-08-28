package com.javaNIO;


import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/***/
public class Task implements Runnable {

    private SelectionKey key;

    public Task(SelectionKey selectionKey) {
        this.key = selectionKey;
    }

    @Override
    public void run() {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int size = -1;
        try {
            while((size = channel.read(buffer)) > 0) {
                buffer.flip();
                baos.write(buffer.array(), 0, size);
                buffer.clear();
            }
            if(baos.size() == 0) {
                key.cancel();
            } else {
                // 协议解析
                String msg = new String(baos.toByteArray(), "UTF-8");
                // 返回该数据
                System.out.println("收到数据" + msg);
                String reply = "get client msg: " + msg;
                ByteBuffer re = ByteBuffer.wrap(reply.getBytes());
                while(re.hasRemaining()) {
                    channel.write(re);
                }
                // 处理完毕后后设置成读状态，继续获取相关数据
                key.interestOps(SelectionKey.OP_READ);
                key.selector().wakeup();
            }
        } catch (Exception e) {
            key.cancel();   // 异常连接中断
        }
    }
}
