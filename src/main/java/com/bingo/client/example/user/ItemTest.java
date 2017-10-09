package com.bingo.client.example.user;

import com.bingo.server.user.provider.ItemProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangGe on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemTest.class)
@ComponentScan(basePackages = "com.bingo")
public class ItemTest {

    @Autowired
    ItemProvider itemProvider;

    // 添加物品
    @Test
    public void testAdd() {
        itemProvider.add("ab", "ab", "cb", "123");
    }

    // 获取物品根据id
    @Test
    public void testGet() {
        System.err.println(itemProvider.getItem(892296360768831488L));
    }

    // 获取多个物品
    @Test
    public void testGetItems() {
        List<Long> itemIds = new ArrayList<Long>() {{
            add(892296276316520448L);
            add(892296360768831488L);
        }};
        System.err.println(itemProvider.getItems(itemIds));
    }


    // 更新物品属性
    @Test
    public void testUpdate() {
        System.err.println(itemProvider.update(892296276316520448L, "abc", "abc", "abc", "12345.10"));
    }

    // 删除物品
    @Test
    public void testDel() {
        itemProvider.del(892296276316520448L);
    }
}
