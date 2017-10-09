package com.bingo.client.example.user;

import com.bingo.server.database.model.CuBag;
import com.bingo.server.user.provider.CuBagProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ZhangGe on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CuBagTest.class)
@ComponentScan(basePackages = "com.bingo")
public class CuBagTest {

    @Autowired
    CuBagProvider cuBagProvider;

    // 获取用户背包内容
    @Test
    public void getBags() {
        List<CuBag> bags = cuBagProvider.getBags(892601238925869056L);
        System.err.println(bags);
    }

    @Test
    public void getBag() {
        CuBag bag = cuBagProvider.getBag(892601238925869056L, 892296360768831488L);
        System.err.println(bag);
    }

    @Test // TODO 未做并发处理
    public void addCount() {
        CuBag cuBag = cuBagProvider.addCount(892601238925869056L, 892296360768831488L, -10000);
        System.err.println(cuBag);
    }

    @Test
    public void addItem() {
        CuBag cuBag = cuBagProvider.addItem(892601238925869056L, 892296360768831488L, 10000);
        System.err.println(cuBag);
    }
}
