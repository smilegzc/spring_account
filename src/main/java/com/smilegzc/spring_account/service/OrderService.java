package com.smilegzc.spring_account.service;

import com.smilegzc.spring_account.entity.Goods;
import com.smilegzc.spring_account.entity.Order;

import java.util.Collection;

/**
 * 日期:2020/3/28
 * 时间:上午12:45
 */
public interface OrderService {
    
    Collection<Order> getOrderByName(String name);

    Collection<Order> getOrderByDate(String date);

    void setOrder(Order order);

    void delOrder(int id);

    Collection<Goods> getGoodsByName(String name);

    Collection<Goods> getGoodsByDate(String date);
}
