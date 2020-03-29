package com.smilegzc.spring_account.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smilegzc.spring_account.entity.Goods;
import com.smilegzc.spring_account.entity.Order;
import com.smilegzc.spring_account.entity.Product;
import com.smilegzc.spring_account.mapper.OrderMapper;
import com.smilegzc.spring_account.mapper.ProductMapper;
import com.smilegzc.spring_account.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 日期:2020/3/28
 * 时间:上午12:50
 */
@Service
public class OrderServiceImpl implements OrderService {
    final OrderMapper orderMapper;
    final ProductMapper productMapper;

    Collection<Product> products;
    Map<String, Float> productsSell;
    Map<String, Float> productsPurchase;
    
    public OrderServiceImpl(OrderMapper orderMapper, ProductMapper productMapper) {
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
    }

    @Override
    public Map<String, Float> newOrder() {
        products = productMapper.getProducts();
        productsSell = new HashMap<>();
        productsPurchase = new HashMap<>();
        products.forEach(product -> {
            productsSell.put(product.getName(), product.getSell());
            productsPurchase.put(product.getName(), product.getPurchase());
        });
        return productsSell;
    }

    @Override
    public List<Goods> createOrder(String para) {
        List<Goods> goodsList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        JSONArray jsonArray = JSON.parseArray(para);
        for (Object json : jsonArray) {
            JSONObject jsonObject = JSON.parseObject(json.toString());
            if (jsonObject.getString("g_name").equals("")) continue;
            Goods goods = jsonObject.toJavaObject(Goods.class);
            if (set.contains(goods.getG_name())) {
                for (int i = 0; i < goodsList.size(); i++) {
                    if (goodsList.get(i).equals(goods)) {
                        goodsList.get(i).addGoods(goods);
                        break;
                    }
                }
            } else {
                set.add(goods.getG_name());
                goodsList.add(goods);
            }
        }
        return goodsList;
    }

    @Override
    public void saveOrder(String name, List<Goods> goodsList, Float sellAll) {
        if(productsSell == null || productsPurchase == null) newOrder();
        Order order = new Order();
        order.setName(name);
        order.setGoods(goodsList);
        order.setActual(sellAll);
        
        float receivable = 0;
        float purchase = 0;
        String goodsName;
        for(Goods goods:goodsList) {
            goodsName = goods.getG_name();
            receivable += productsSell.get(goodsName) * goods.getG_number();
            purchase += productsPurchase.get(goodsName) * goods.getG_number();
        }
        
        order.setReceivable(receivable);
        order.setPurchase(purchase);
        
        setOrder(order);
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
