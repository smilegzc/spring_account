package com.smilegzc.spring_account.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smilegzc.spring_account.entity.Order;
import com.smilegzc.spring_account.mapper.OrderMapper;
import com.smilegzc.spring_account.service.DashboardService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 日期:2020/3/28
 * 时间:下午10:48
 */
@Service
public class DashboardServiceImpl implements DashboardService {
    
    LocalDate startDate;
    LocalDate endDate;
    
    final OrderMapper orderMapper;
    public DashboardServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 日期自动设置与转换，
     * 如果start为空，则设置为end月数减1,
     * 如果恩的为空，则设置为当前日期
     * @param start 开始时间
     * @param end 结束时间
     */
    private void dateFormatter(String start, String end) {
        if (end != null && !end.equals("")) {
            endDate = LocalDate.parse(end);
        } else {
            endDate = LocalDate.now();
        }
        if (start != null && !start.equals("")) {
            startDate = LocalDate.parse(start);
        } else {
            startDate = endDate.plusMonths(-1);
        }
    }

    /**
     * 获取指定时间范围的实际收款统计数据
     * 如果时间范围小于31天，按天显示数据
     * 如果时间范围大于31天，按月显示数据
     * (ps:该方法代码自我感觉又臭又长，但是我就是不想重构，因为懒。。。)
     * 
     * @param start 开始时间
     * @param end 结束时间
     * @return 结果组装为json数据
     */
    @Override
    public JSONObject saleDashboard(String start, String end) {
        JSONObject jsonObject = new JSONObject();
        List<String> label = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        String labelName;

        //将String转为LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        dateFormatter(start, end);
        
        int lengthDay = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        if(lengthDay < 0) {
            LocalDate temp = startDate;
            startDate = endDate;
            endDate = temp;
            lengthDay = -lengthDay;
        }
        
        if(lengthDay <= 31) {
            labelName = startDate + "至" + endDate + "日销量";
            for(LocalDate i = startDate; i.compareTo(endDate) <= 0; i = i.plusDays(1)) {
                Collection<Order> orderByDate = orderMapper.getOrderByDate(i.format(formatter));
                label.add(i.toString());
                int money = 0;
                for(Order o:orderByDate) {
                    money += o.getActual();
                }
                data.add(money);
            }
        } else {
            labelName = startDate + "至" + endDate + "月销量";
            while (startDate.compareTo(endDate) <= 0) {
                LocalDate tempDate = startDate.plusMonths(1).plusDays(-startDate.getDayOfMonth());
                if(tempDate.compareTo(endDate) > 0) {
                    tempDate = endDate;
                }

                Collection<Order> orderByDates = orderMapper.getOrderByDates(startDate.format(formatter), tempDate.format(formatter));
                label.add(startDate + " * " + tempDate);
                int money = 0;
                for(Order o:orderByDates) {
                    money += o.getActual();
                }
                data.add(money);
                
                startDate = tempDate.plusDays(1);
            }
        }

        JSONObject dataset = new JSONObject();
        dataset.put("data", data);
        dataset.put("label", labelName);
        dataset.put("lineTension", 0);
        dataset.put("backgroundColor", "transparent");
        dataset.put("borderColor", "#007bff");
        dataset.put("borderWidth", 4);
        dataset.put("pointBackgroundColor", "#007bff");

        JSONArray datasets = new JSONArray();
        datasets.add(dataset);
        jsonObject.put("labels", label);
        jsonObject.put("datasets", datasets);
        return jsonObject;
    }

    @Override
    public Collection<Order> saleStatistics(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        dateFormatter(start, end);

        Collection<Order> orders = orderMapper.getOrderByDates(startDate.format(formatter), endDate.format(formatter));
        return orders;
    }
}
