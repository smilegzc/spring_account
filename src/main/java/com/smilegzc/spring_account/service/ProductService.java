package com.smilegzc.spring_account.service;

import com.smilegzc.spring_account.entity.Product;

import java.util.Collection;

/**
 * 日期:2020/3/28
 * 时间:下午6:35
 */
public interface ProductService {
    Collection<Product> getProducts();

    Product getProductById(int id);

    Product getProductByName(String name);

    void setProduct(Product product);

    void delProduct(int id);

    void updateProduct(Product product);

    void sellProduct(Product product);
}
