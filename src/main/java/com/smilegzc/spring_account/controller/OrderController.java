package com.smilegzc.spring_account.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smilegzc.spring_account.entity.Goods;
import com.smilegzc.spring_account.entity.Product;
import com.smilegzc.spring_account.mapper.ProductMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 日期:2020/3/26
 * 时间:下午10:30
 * 订单控制
 */
@Controller
public class OrderController {
    final ProductMapper productMapper;
    List<Goods> list = null;
    public OrderController(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    
    @GetMapping("/orders")
    public String newOrder(Model model){
        Collection<Product> products = productMapper.getProducts();
        Map<String, Float> map = new HashMap<>();
        for(Product p:products) {
            map.put(p.getName(), p.getSell());
        }
        model.addAttribute("products", map);
        return "order/list";
    }
    
    @PostMapping("/order")
    @ResponseBody
    public String creatOrder(String para, Model model) {
        list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        JSONArray jsonArray = JSON.parseArray(para);
        for(Object json: jsonArray) {
            JSONObject jsonObject = JSON.parseObject(json.toString());
            Goods goods = jsonObject.toJavaObject(Goods.class);
            if(set.contains(goods.getG_name())) {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).equals(goods)) {
                        list.get(i).addGoods(goods);
                        break;
                    }
                }
            } else {
                set.add(goods.getG_name());
                list.add(goods);
            }
        }
        System.out.println(list);
        return "success";
    }
    @GetMapping("/order")
    public String toAddPage(Model model) {
        model.addAttribute("goods_list", list);
        return "order/add";
    }
    
}
