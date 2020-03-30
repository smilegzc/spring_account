package com.smilegzc.spring_account.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 日期:2020/3/30
 * 时间:下午4:50
 */
@Service
public interface ExportService {
    XSSFWorkbook getData();
    XSSFWorkbook employeeInfo(XSSFWorkbook wb);
    XSSFWorkbook customerInfo(XSSFWorkbook wb);
    XSSFWorkbook orderInfo(XSSFWorkbook wb);
    XSSFWorkbook purchaseInfo(XSSFWorkbook wb);
    XSSFWorkbook productInfo(XSSFWorkbook wb);
}
