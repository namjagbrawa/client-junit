package com.bingo.client.example.gate;

import com.bingo.server.msg.MSG;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

public abstract class NettyHandler extends SimpleChannelInboundHandler<MSG.Message> {

    private int heartbeatCount = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MSG.Message msg) throws Exception {
        handleData(ctx, msg);
    }

    protected void ping(ChannelHandlerContext context) {

        System.err.println("ping~~~");

        /*NetMessageOuterClass.NetMessage.Builder netMessage = NetMessageOuterClass.NetMessage.newBuilder().setCode(1001);


        ByteBuf buf = context.alloc().buffer(4);

        byte[] serialize = netMessage.build().toByteArray();

        buf.writeInt(netMessage.getCode());
        buf.writeInt(serialize.length);
        buf.writeBytes(serialize);
        context.writeAndFlush(buf);
        heartbeatCount++;*/
        // System.out.println(" sent ping msg to " + context.channel().remoteAddress() + ", count: " + heartbeatCount);
    }

    protected abstract void handleData(ChannelHandlerContext channelHandlerContext, MSG.Message message);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // IdleStateHandler 所产生的 IdleStateEvent 的处理逻辑.
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case READER_IDLE:
                    handleReaderIdle(ctx);
                    break;
                case WRITER_IDLE:
                    handleWriterIdle(ctx);
                    break;
                case ALL_IDLE:
                    handleAllIdle(ctx);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public abstract void channelActive(ChannelHandlerContext ctx) throws Exception;

    @Override
    public abstract void channelInactive(ChannelHandlerContext ctx) throws Exception;

    protected abstract void handleReaderIdle(ChannelHandlerContext ctx);

    protected abstract void handleWriterIdle(ChannelHandlerContext ctx);

    protected abstract void handleAllIdle(ChannelHandlerContext ctx);
}