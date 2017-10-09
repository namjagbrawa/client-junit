package com.bingo.client.example.user;

import com.bingo.server.database.model.CuUser;
import com.bingo.server.user.provider.CuUserProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangGe on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CuWalletTest.class)
@ComponentScan(basePackages = "com.bingo")
public class CuUserTest {

    @Autowired
    CuUserProvider cuUserProvider;

    @Test
    public void testRegsitry() {
        CuUser cuUser = cuUserProvider.registryUser("username4", "password3");
        System.err.println(cuUser);
    }

    @Test
    public void testAuthUser() {
        CuUser cuUser = cuUserProvider.authUser("username", "password");
        System.err.println(cuUser);
    }

    @Test
    public void testGetUsers() {
        List<CuUser> users = cuUserProvider.getUsers(new ArrayList<Long>() {{
            add(892347836832677888L);
        }});
        System.err.println(users);
    }

    @Test
    public void testGetUserById() {
        CuUser userById = cuUserProvider.getUserById(892347836832677888L);
        System.err.println(userById);
    }

    @Test
    public void testGetUserByUsername() {
        CuUser username = cuUserProvider.getUserByUsername("username");
        System.err.println(username);
    }

    @Test
    public void testGetUserMap() {
        Map<Long, CuUser> userMap = cuUserProvider.getUserMap(new ArrayList<Long>() {{
            add(892347836832677888L);
        }});
        System.err.println(userMap);
    }

    @Test
    public void testUpdatePassword() {
        cuUserProvider.updatePassword(892347836832677888L, "password1");
    }

    @Test // 未通过
    public void testAuthWeixinUser() {
        CuUser username = cuUserProvider.getUserByUsername("username");
        CuUser cuUser = cuUserProvider.authWeixinUser(username);
        System.err.println(cuUser);
    }
}
