package com.smilegzc.spring_account.entity;

import lombok.Data;

/**
 * 日期:2020/3/25
 * 时间:下午10:17
 * 货物实体类
 */
@Data
public class Product {
    Integer id;
    String name;
    Float purchase;
    Float sell;
    Integer number;
}
