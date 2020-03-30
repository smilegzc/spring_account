package com.smilegzc.spring_account.service.impl;

import com.smilegzc.spring_account.entity.Product;
import com.smilegzc.spring_account.entity.PurchaseProduct;
import com.smilegzc.spring_account.mapper.ProductMapper;
import com.smilegzc.spring_account.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * 日期:2020/3/28
 * 时间:下午6:43
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    final ProductMapper productMapper;
    
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    
    @Override
    public Collection<Product> getProducts() {
        return productMapper.getProducts();
    }

    @Override
    public Product getProductById(int id) {
        return productMapper.getProductById(id);
    }

    @Override
    public Product getProductByName(String name) {
        return productMapper.getProductByName(name);
    }

    @Override
    public void setProduct(Product product) {
        productMapper.setProduct(product);
    }

    @Override
    public void delProduct(int id) {
        productMapper.delProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void purchaseProduct(Product purchaseProduct) {
        //加入进货记录
        productMapper.purchaseProduct(purchaseProduct);
        
        //更新库存数据
        Product product = getProductById(purchaseProduct.getId());
        product.setPurchase(purchaseProduct.getPurchase());
        product.setNumber(product.getNumber() + purchaseProduct.getNumber());
        updateProduct(product);
    }

    @Override
    public void delPurchaseProduct(int id) {
        productMapper.delPurchaseById(id);
    }

    @Override
    public Collection<PurchaseProduct> getPurchaseProductByDates(String start, String end) {
        LocalDate[] localDates = dateFormatter(start, end);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        start = localDates[0].format(formatter);
        end = localDates[1].format(formatter);
        
        return productMapper.getPurchaseByDates(start, end);
    }

    /**
     * 日期自动设置与转换，
     * 如果start为空，则设置为end月数减1,
     * 如果恩的为空，则设置为当前日期
     *  @param start 开始时间
     * @param end   结束时间
     */
    private LocalDate[] dateFormatter(String start, String end) {
        LocalDate[] startToEnd = new LocalDate[2];
        if (end != null && !end.equals("")) {
            startToEnd[1] = LocalDate.parse(end);
        } else {
            startToEnd[1] = LocalDate.now();
        }
        if (start != null && !start.equals("")) {
            startToEnd[0] = LocalDate.parse(start);
        } else {
            startToEnd[0] = startToEnd[1].plusMonths(-1);
        }
        
        return startToEnd;
    }
}
