package com.bingo.client.example.user;

import com.bingo.server.database.model.CuRoomType;
import com.bingo.server.user.provider.CuRoomTypeProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZhangGe on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CuWalletTest.class)
@ComponentScan(basePackages = "com.bingo")
public class CuRoomUserTest {

    @Autowired
    CuRoomTypeProvider cuRoomTypeProvider;

    @Test
    public void testAddRoomType() {
        CuRoomType cuRoomType = cuRoomTypeProvider.addRoomType("a", "a", "a", 100, 10);
        System.err.println(cuRoomType);
    }

    @Test
    public void testUpdateRoomType(){
        CuRoomType cuRoomType = cuRoomTypeProvider.addRoomType("b", "ab", "ab", 100, 10);
        cuRoomType.setLowerLimit(1000);
        cuRoomType.setUpperLimit(100000);
        cuRoomTypeProvider.updateRoomType(cuRoomType);
    }

    @Test
    public void testDel() {
        cuRoomTypeProvider.delete(892594126824931328L);
    }

    @Test
    public  void testGet() {
        CuRoomType cuRoomType = cuRoomTypeProvider.get(892594097880039424L);
        System.err.println(cuRoomType);
    }

}
