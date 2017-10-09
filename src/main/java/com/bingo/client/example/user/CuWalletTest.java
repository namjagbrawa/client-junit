package com.bingo.client.example.user;

import com.bingo.server.database.model.CuWallet;
import com.bingo.server.user.provider.CuWalletProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by ZhangGe on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CuWalletTest.class)
@ComponentScan(basePackages = "com.bingo")
public class CuWalletTest {

    @Autowired
    CuWalletProvider cuWalletProvider;

    // 初始化钱包
    @Test
    public void testInitWallet() {
        CuWallet cuWallet = cuWalletProvider.initWallet(892601208240340992L);
        System.err.println(cuWallet);
    }

    // 减少房卡
    @Test
    public void testSubstractRoomCard() {
        boolean b = cuWalletProvider.substractRoomCard(1, 1);
        System.err.println(b);
    }

    // 更新钱包
    @Test
    public void testUpdateWallet() {
        CuWallet cuWallet = cuWalletProvider.initWallet(2);
        System.err.println(cuWallet);
        BigDecimal bigDecimal = new BigDecimal("100");
        cuWallet.setCredit(bigDecimal);
        cuWalletProvider.updateWallet(cuWallet);
    }

    // 钱包重置
    @Test
    public void testRestWallet() {
        CuWallet cuWallet = cuWalletProvider.resetWallet(2);
        System.err.println(cuWallet);
    }

    // 获取钱包内容
    @Test
    public void testGetWallet() {
        CuWallet wallet = cuWalletProvider.getWallet(1);
        System.err.println(wallet);
    }
}
