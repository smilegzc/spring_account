package com.smilegzc.spring_account.entity;

import lombok.Data;

/**
 * 日期:2020/3/27
 * 时间:下午6:21
 * 订单中的货物
 */
@Data
public class Goods {
    Integer g_id;
    String g_name;
    Integer g_number;
    Float g_price;
    Float g_all;
    Integer g_order_id;
    public boolean equals(Goods goods) {
        if(goods != null && goods.getG_name().equals(g_name)) {
            return true;
        }
        return false;
    }
    
    public void addGoods(Goods goods) {
        g_number += goods.g_number;
        g_price += goods.g_price;
        g_all += goods.g_all;
    }
}
