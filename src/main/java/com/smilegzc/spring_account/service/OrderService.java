package com.smilegzc.spring_account.service;

import com.smilegzc.spring_account.entity.Goods;
import com.smilegzc.spring_account.entity.Order;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 日期:2020/3/28
 * 时间:上午12:45
 */
public interface OrderService {

    Collection<Order> getOrders();
    
    Collection<Order> getOrderByName(String name);

    Collection<Order> getOrderByDate(String date);

    void setOrder(Order order);

    void delOrder(int id);

    Collection<Goods> getGoodsByName(String name);

    Collection<Goods> getGoodsByDate(String date);

    Map<String, Float> newOrder();
    
    List<Goods> createOrder(String goodsInfo);
    
    void saveOrder(String name, List<Goods> goodsList, Float sellAll);
}
