package com.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler  extends SimpleChannelInboundHandler {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //do something msg
        String data=String.valueOf(msg);
        System.out.println("Server: " + data);
        //写给客户端
        String response = "我是反馈的信息"+"$_";
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
        //.addListener(ChannelFutureListener.CLOSE);


    }

    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
