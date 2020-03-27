package com.smilegzc.spring_account.entity;

import lombok.Data;

/**
 * 日期:2020/3/24
 * 时间:下午9:09
 * 员工实体类
 */
@Data
public class Employee {
    Integer id;
    String phone;
    String name;
    String username;
    String password;
    //0 is boss, 1 is employee
    Integer type;
}
