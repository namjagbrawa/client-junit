package com.bingo.client.example.gate;

import com.bingo.server.msg.MSG;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketClientHandler extends NettyHandler {

    private final static Logger logger = LoggerFactory.getLogger(SocketClientHandler.class);

    private NettySocketClient nettySocketClient;

    public SocketClientHandler(NettySocketClient client) {
        this.nettySocketClient = client;
    }

    @Override
    protected void handleData(ChannelHandlerContext ctx, MSG.Message message) {
        // 心跳消息,原消息返回
        /*if (1002 == netMessage.getCode()) {
            logger.info("收到心跳");
            System.out.println("收到心跳");
            return;
        }*/
        System.err.println(message);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    protected void handleAllIdle(ChannelHandlerContext ctx) {
        // ping(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        nettySocketClient.doConnect();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelInactive();
        nettySocketClient.doConnect();
    }

    @Override
    protected void handleReaderIdle(ChannelHandlerContext ctx) {

    }

    @Override
    protected void handleWriterIdle(ChannelHandlerContext ctx) {

    }


}