package com.smilegzc.spring_account.entity;

import lombok.Data;

/**
 * 日期:2020/3/26
 * 时间:下午5:17
 * 
 * 客户实体类
 */
@Data
public class Customer {
    Integer id;
    String name;
    String phone;
    String address;
    Float size;
}
