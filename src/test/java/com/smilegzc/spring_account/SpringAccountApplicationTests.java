package com.smilegzc.spring_account;

import com.smilegzc.spring_account.entity.Goods;
import com.smilegzc.spring_account.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class SpringAccountApplicationTests {
    @Autowired
    OrderService orderService;
    @Test
    void contextLoads() {
        Collection<Goods> goodsByDate = orderService.getGoodsByDate("20200327");
        Collection<Goods> bb = orderService.getGoodsByName("BB");

        System.out.println("************goodsByDate************");
        System.out.println(goodsByDate);
        System.out.println("************getGoodsByName************");
        System.out.println(bb);
    }
}
