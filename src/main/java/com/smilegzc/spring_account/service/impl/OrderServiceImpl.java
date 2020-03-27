package com.smilegzc.spring_account.service.impl;

import com.smilegzc.spring_account.entity.Goods;
import com.smilegzc.spring_account.entity.Order;
import com.smilegzc.spring_account.mapper.OrderMapper;
import com.smilegzc.spring_account.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 日期:2020/3/28
 * 时间:上午12:50
 */
@Service
public class OrderServiceImpl implements OrderService {
    final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Collection<Order> getOrderByName(String name) {
        return orderMapper.getOrderByName(name);
    }

    @Override
    public Collection<Order> getOrderByDate(String date) {
        return orderMapper.getOrderByDate(date);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setOrder(Order order) {
        orderMapper.setOrder(order);
        int orderId = order.getId();
        for(Goods goods:order.getGoods()) {
            goods.setG_order_id(orderId);
            orderMapper.setGoods(goods);
        }
    }

    @Override
    public void delOrder(int id) {
        orderMapper.delOrder(id);
    }

    @Override
    public Collection<Goods> getGoodsByName(String name) {
        return orderMapper.getGoodsByName(name);
    }

    @Override
    public Collection<Goods> getGoodsByDate(String date) {
        Collection<Order> orderByDate = getOrderByDate(date);
        Collection<Goods> goods = new ArrayList<>();
        for(Order order:orderByDate) {
            goods.addAll(order.getGoods());
        }
        return goods;
    }
}
