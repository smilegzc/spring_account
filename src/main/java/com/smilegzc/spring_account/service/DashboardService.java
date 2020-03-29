package com.smilegzc.spring_account.service;

import com.alibaba.fastjson.JSONObject;
import com.smilegzc.spring_account.entity.Order;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 日期:2020/3/28
 * 时间:下午10:46
 */
@Service
public interface DashboardService {
    JSONObject saleDashboard(String start, String end);
    Collection<Order> saleStatistics(String start, String end);
}
