package com.bingo.client.example.user;

import com.bingo.framework.common.URL;
import com.bingo.server.database.model.CuOnlineUser;
import com.bingo.server.user.provider.CuOnlineUserProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ZhangGe on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CuWalletTest.class)
@ComponentScan(basePackages = "com.bingo")
public class CuOnlineTest {

    @Autowired
    CuOnlineUserProvider cuOnlineUserProvider;

    @Test
    public void testOnline() {
        cuOnlineUserProvider.online(892601208240340992L, 123456789, URL.valueOf("abc"));
    }

    @Test
    public void testOffline() {
        cuOnlineUserProvider.offline(892347836832677888L);
    }

    @Test
    public void testGetTopic() {
        long topic = cuOnlineUserProvider.getTopic(892347836832677888L);
        System.err.println(topic);
    }

    @Test
    public void testGetOnlineUser() {
        CuOnlineUser onlineUser = cuOnlineUserProvider.getOnlineUser(892347836832677888L);
        System.err.println(onlineUser);
    }

    @Test
    public void testLogout() {
        cuOnlineUserProvider.logout(892347836832677888L);
    }

    @Test
    public void testGetOnlineUsers() {
        Map<Long, CuOnlineUser> onlineUsers = cuOnlineUserProvider.getOnlineUsers(new ArrayList<Long>(){{add(892347836832677888L);}});
        System.err.println(onlineUsers);
    }
}
