package com.smilegzc.spring_account.controller;

import com.smilegzc.spring_account.entity.Goods;
import com.smilegzc.spring_account.entity.Order;
import com.smilegzc.spring_account.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 日期:2020/3/26
 * 时间:下午10:30
 * 订单控制
 */
@Controller
public class OrderController {
    final OrderService orderService;
    List<Goods> goodsList;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @GetMapping("/orders")
    public String newOrder(Model model){
        Map<String, Float> map = orderService.newOrder();
        model.addAttribute("products", map);
        return "order/list";
    }
    
    @PostMapping("/order")
    @ResponseBody
    public String creatOrder(String para) {
        goodsList = orderService.createOrder(para);
        return goodsList.size()==0 ? "empty" : "success";
    }
    @GetMapping("/order")
    public String toAddPage(Model model) {
        float receivable = 0;
        for(Goods goods:goodsList) {
            receivable += goods.getG_all();
        }
        model.addAttribute("receivable", receivable);
        model.addAttribute("goods_list", goodsList);
        return "order/add";
    }
    
    @PutMapping("/order")
    public String addOrder(@RequestParam String name,
                           @RequestParam Float sellAll) {
        orderService.saveOrder(name, goodsList, sellAll);
        return "redirect:/orders";
    }
}
