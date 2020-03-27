package com.smilegzc.spring_account.mapper;

import com.smilegzc.spring_account.entity.Goods;
import com.smilegzc.spring_account.entity.Order;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collection;

/**
 * 日期:2020/3/27
 * 时间:下午9:33
 */
@Service
public interface OrderMapper {
    Collection<Order> getOrderByName(String name);
    Collection<Order> getOrderByDate(String date);
    void setOrder(Order order);
    void delOrder(int id);
    
    Collection<Goods> getGoodsByName(String name);
    Collection<Goods> getGoodsByOrder(int orderId);
    void setGoods(Goods goods);
}
