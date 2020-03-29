package com.smilegzc.spring_account;

import com.smilegzc.spring_account.entity.Order;
import com.smilegzc.spring_account.service.DashboardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class SpringAccountApplicationTests {
    @Autowired
    DashboardService dashboardService;
    @Test
    void contextLoads() {
        Collection<Order> orderByDates = dashboardService.saleStatistics("2020-03-21", "2020-03-29");
        orderByDates.forEach(System.out::println);
    }
}
