package com.bingo.client.example.gate;

import com.bingo.server.msg.MSG;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * Created by ZhangGe on 2017/4/4.
 */
public class MessageDecoder extends LengthFieldBasedFrameDecoder {

    private static final Logger logger = LoggerFactory.getLogger(MessageDecoder.class);

    // magic header.
    protected static final short MAGIC = (short) 0xACCA;


    public MessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(2048, 4, 4);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
        byteBuf.markReaderIndex();

        ByteBuf frame = (ByteBuf) super.decode(ctx, byteBuf);

        if (null == frame) {
            return null;
        }

        ByteBuffer byteBuffer = frame.nioBuffer();
        int limit = byteBuffer.limit();
        short magic = byteBuffer.getShort();
        short code = byteBuffer.getShort();
        int length = byteBuffer.getInt();
        byte[] data = new byte[length];
        byteBuffer.get(data);

        MSG.Message message = MSG.Message.parseFrom(data);

        System.out.println(code);
        System.out.println(data);

        System.err.println(message);

        return message;
    }
}
