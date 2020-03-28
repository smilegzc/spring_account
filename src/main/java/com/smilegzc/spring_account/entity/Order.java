package com.smilegzc.spring_account.entity;

import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * 日期:2020/3/27
 * 时间:下午6:23
 */
@Data
public class Order {
    Integer id;
    String name;
    List<Goods> goods;
    Float purchase; //进货价
    Float receivable;// 应收款
    Float actual;//实收款
    Date date;
}
