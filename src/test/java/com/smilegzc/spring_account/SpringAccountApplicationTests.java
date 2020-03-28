package com.smilegzc.spring_account;

import com.smilegzc.spring_account.entity.Goods;
import com.smilegzc.spring_account.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Map;

@SpringBootTest
class SpringAccountApplicationTests {
    @Autowired
    OrderService orderService;
    @Test
    void contextLoads() {
        Map<String, Float> stringFloatMap = orderService.newOrder();
        System.out.println(stringFloatMap.keySet());
    }
}
