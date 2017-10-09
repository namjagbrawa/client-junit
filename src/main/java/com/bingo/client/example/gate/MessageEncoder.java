package com.bingo.client.example.gate;

import com.bingo.server.msg.MSG;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by ZhangGe on 2017/4/4.
 */
public class MessageEncoder extends MessageToByteEncoder<MSG.Message> {

    // magic header.
    protected static final short MAGIC = (short) 0xACCA;

    protected void encode(ChannelHandlerContext ctx, MSG.Message msg, ByteBuf out) throws Exception {
        out.writeShort(MAGIC);

        MSG.MsgCode msgCode = msg.getMsgCode();
        out.writeShort(msgCode.getNumber());

        byte[] bytes = msg.toByteArray();
        out.writeInt(bytes.length);
        out.writeBytes(bytes);
    }
}
