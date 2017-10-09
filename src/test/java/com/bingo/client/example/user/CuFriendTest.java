package com.bingo.client.example.user;

import com.bingo.server.database.model.CuFriend;
import com.bingo.server.database.model.CuUser;
import com.bingo.server.user.provider.CuFriendProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by ZhangGe on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CuWalletTest.class)
@ComponentScan(basePackages = "com.bingo")
public class CuFriendTest {

    @Autowired
    CuFriendProvider cuFriendProvider;

    @Test
    public void testGetFriends() {
        List<CuFriend> friends = cuFriendProvider.getFriends(892601238925869056L);
        System.err.println(friends);
        List<CuFriend> friends1 = cuFriendProvider.getFriends(892347836832677888L);
        System.err.println(friends1);
    }

    @Test
    public void testGetUsers() {
        List<CuUser> users = cuFriendProvider.getUsers(892347836832677888L);
        System.err.println(users);
    }

    @Test
    public void testAddFriend() {
        cuFriendProvider.addFriend(892601238925869056L, 892347836832677888L);
    }

    @Test
    public void testDelFreiend() {
        cuFriendProvider.delFreiend(892601238925869056L, 892347836832677888L);
    }

    @Test
    public void testGetUserMap() {
        Map<Long, CuUser> userMap = cuFriendProvider.getUserMap(892601238925869056L);
        System.err.println(userMap);
        Map<Long, CuUser> userMap1 = cuFriendProvider.getUserMap(892347836832677888L);
        System.err.println(userMap1);
    }

}
