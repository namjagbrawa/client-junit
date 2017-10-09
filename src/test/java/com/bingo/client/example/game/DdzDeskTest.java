package com.bingo.client.example.game;

import com.bingo.client.example.test.SuperTest;
import com.bingo.server.game.provider.DdzDeskProvider;
import com.bingo.server.game.provider.DdzRuleProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by ZhangGe on 2017/8/2.
 */
public class DdzDeskTest extends SuperTest {

    @Autowired
    private DdzDeskProvider ddzDeskProvider;
    @Autowired
    private DdzRuleProvider ddzRuleProvider;

    @Test
    public void getDeskByIdTest() {
        ddzDeskProvider.getDeskById(1L);
    }

    @Test
    public void getDeskByDeskNoTest() {

    }

    @Test
    public void getDeskNoTest() {

    }

    @Test
    public void newDeskTest() {
    }

    @Test
    public void updateTest() {

    }
}
