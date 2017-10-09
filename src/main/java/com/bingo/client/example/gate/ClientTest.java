package com.bingo.client.example.gate;

import com.bingo.client.example.test.SuperTest;
import com.bingo.server.msg.Fight;
import com.bingo.server.msg.MSG;
import com.bingo.server.msg.ServerMessage;
import io.netty.channel.Channel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ZhangGe on 2017/8/11.
 */
public class ClientTest extends SuperTest {

    private NettySocketClient nettySocketClient;

    @Before
    public void testClientBefore() throws InterruptedException {
        nettySocketClient = new NettySocketClient("127.0.0.1", 12345);
        nettySocketClient.start();
        Thread.sleep(10000);
    }

    @After
    public void testClientAfter() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }

    @Test
    public void testClientMessage() {
        Channel channel = nettySocketClient.getChannel();
        MSG.Message.Builder builder = MSG.Message.newBuilder().setSc(ServerMessage.SC.newBuilder().setFightAgreeExitGameResponse(Fight.FightAgreeExitGameResponse.newBuilder().setErrorCode(1)));
        channel.writeAndFlush(builder.build());
    }
}
