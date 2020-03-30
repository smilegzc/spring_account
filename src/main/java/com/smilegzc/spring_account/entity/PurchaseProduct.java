package com.smilegzc.spring_account.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 日期:2020/3/29
 * 时间:下午10:24
 */
@Data
public class PurchaseProduct {
    Integer id;
    String name;
    Float purchase;
    Integer number;
    LocalDate creatDate;
}
