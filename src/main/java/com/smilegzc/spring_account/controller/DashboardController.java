package com.smilegzc.spring_account.controller;

import com.alibaba.fastjson.JSONObject;
import com.smilegzc.spring_account.entity.Order;
import com.smilegzc.spring_account.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 日期:2020/3/28
 * 时间:下午10:15
 * 主界面图表控制
 * 
 * 
 */
@Controller
public class DashboardController {
    
    final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/main")
    public String showDashboard(String start, String end,Model model) {
        JSONObject jsonObject = dashboardService.saleDashboard(start, end);
        Collection<Order> orders = dashboardService.saleStatistics(start, end);
        model.addAttribute("jsonData", jsonObject);
        model.addAttribute("orders", orders);
        return "dashboard";
    }
}
