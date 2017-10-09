package com.bingo.client.example.test;

import com.bingo.client.example.user.CuBagTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZhangGe on 2017/8/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SuperTest.class)
@ComponentScan(basePackages = "com.bingo")
public class SuperTest {
}
