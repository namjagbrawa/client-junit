package com.bingo.client.example.hall;

import com.bingo.client.example.test.SuperTest;
import com.bingo.server.hall.provider.BagProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZhangGe on 2017/8/13.
 */
public class BagTest extends SuperTest{

    @Autowired
    private BagProvider bagProvider;

    @Test
    public void addItemTest() {
        bagProvider.addItem(892347836832677888L, 892296360768831488L, 1000);
    }
}
