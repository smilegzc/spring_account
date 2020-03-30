package com.smilegzc.spring_account.service.impl;

import com.smilegzc.spring_account.entity.*;
import com.smilegzc.spring_account.mapper.CustomerMapper;
import com.smilegzc.spring_account.mapper.EmployeeMapper;
import com.smilegzc.spring_account.service.ExportService;
import com.smilegzc.spring_account.service.OrderService;
import com.smilegzc.spring_account.service.ProductService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 日期:2020/3/30
 * 时间:下午4:58
 */
@Service
public class ExportServiceImpl implements ExportService {
    
    final EmployeeMapper employeeMapper;
    final CustomerMapper customerMapper;
    final OrderService orderService;
    final ProductService productService;

    public ExportServiceImpl(EmployeeMapper employeeMapper, CustomerMapper customerMapper, OrderService orderService, ProductService productService) {
        this.employeeMapper = employeeMapper;
        this.customerMapper = customerMapper;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public XSSFWorkbook getData() {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        xssfWorkbook = employeeInfo(xssfWorkbook);
        xssfWorkbook = customerInfo(xssfWorkbook);
        xssfWorkbook = orderInfo(xssfWorkbook);
        xssfWorkbook = purchaseInfo(xssfWorkbook);
        xssfWorkbook = productInfo(xssfWorkbook);
        return xssfWorkbook;
    }

    @Override
    public XSSFWorkbook employeeInfo(XSSFWorkbook wb) {
        Collection<Employee> employees = employeeMapper.getEmployees();
        Sheet sheet = wb.createSheet("员工信息");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("序号");//第一列
        titleRow.createCell(1).setCellValue("姓名");
        titleRow.createCell(2).setCellValue("电话");
        titleRow.createCell(3).setCellValue("帐号");
        titleRow.createCell(4).setCellValue("密码");
        titleRow.createCell(5).setCellValue("管理员");
        int cell = 1;
        for (Employee employee : employees) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getPhone());
            row.createCell(3).setCellValue(employee.getUsername());
            row.createCell(4).setCellValue(employee.getPassword());
            row.createCell(5).setCellValue(employee.getType() == 0 ? "是" : "否");
            cell++;
        }
        return wb;
    }

    @Override
    public XSSFWorkbook customerInfo(XSSFWorkbook wb) {
        Collection<Customer> customers = customerMapper.getCustomers();
        Sheet sheet = wb.createSheet("客户信息");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("序号");//第一列
        titleRow.createCell(1).setCellValue("姓名");
        titleRow.createCell(2).setCellValue("电话");
        titleRow.createCell(3).setCellValue("地址");
        titleRow.createCell(4).setCellValue("面积");
        int cell = 1;
        for (Customer customer : customers) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(customer.getId());
            row.createCell(1).setCellValue(customer.getName());
            row.createCell(2).setCellValue(customer.getPhone());
            row.createCell(3).setCellValue(customer.getAddress());
            row.createCell(4).setCellValue(customer.getSize());
            cell++;
        }
        return wb;
    }

    @Override
    public XSSFWorkbook orderInfo(XSSFWorkbook wb) {
        Collection<Order> orders = orderService.getOrders();
        Sheet sheet = wb.createSheet("销售记录");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("序号");//第一列
        titleRow.createCell(1).setCellValue("名字");
        titleRow.createCell(2).setCellValue("总进货价");
        titleRow.createCell(3).setCellValue("应收款");
        titleRow.createCell(4).setCellValue("实收款");
        titleRow.createCell(5).setCellValue("日期");
        int cell = 1;
        for (Order order : orders) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(order.getId());
            row.createCell(1).setCellValue(order.getName());
            row.createCell(2).setCellValue(order.getPurchase());
            row.createCell(3).setCellValue(order.getReceivable());
            row.createCell(4).setCellValue(order.getActual());
            row.createCell(5).setCellValue(order.getDate().toString());
            cell++;
        }
        return wb;
    }

    @Override
    public XSSFWorkbook purchaseInfo(XSSFWorkbook wb) {
        Collection<PurchaseProduct> purchaseProducts = productService.getPurchaseProducts();
        Sheet sheet = wb.createSheet("进货记录");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("序号");//第一列
        titleRow.createCell(1).setCellValue("名字");
        titleRow.createCell(2).setCellValue("进货价");
        titleRow.createCell(3).setCellValue("数量");
        titleRow.createCell(4).setCellValue("时间");
        int cell = 1;
        for (PurchaseProduct purchaseProduct : purchaseProducts) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(purchaseProduct.getId());
            row.createCell(1).setCellValue(purchaseProduct.getName());
            row.createCell(2).setCellValue(purchaseProduct.getPurchase());
            row.createCell(3).setCellValue(purchaseProduct.getNumber());
            row.createCell(4).setCellValue(purchaseProduct.getCreatDate().toString());
            cell++;
        }
        return wb;
    }

    @Override
    public XSSFWorkbook productInfo(XSSFWorkbook wb) {
        Collection<Product> products = productService.getProducts();
        Sheet sheet = wb.createSheet("库存信息");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("序号");//第一列
        titleRow.createCell(1).setCellValue("名字");
        titleRow.createCell(2).setCellValue("进货价");
        titleRow.createCell(3).setCellValue("卖货价");
        titleRow.createCell(4).setCellValue("数量");
        int cell = 1;
        for (Product product : products) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(product.getId());
            row.createCell(1).setCellValue(product.getName());
            row.createCell(2).setCellValue(product.getPurchase());
            row.createCell(3).setCellValue(product.getSell());
            row.createCell(4).setCellValue(product.getNumber());
            cell++;
        }
        return wb;
    }
}
