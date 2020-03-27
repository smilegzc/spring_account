package com.smilegzc.spring_account.mapper;

import com.smilegzc.spring_account.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 日期:2020/3/25
 * 时间:下午10:48
 */
@Service
public interface ProductMapper {
    Collection<Product> getProducts();
    Product getProductById(int id);
    Product getProductByName(String name);
    void setProduct(Product product);
    void delProduct(int id);
    void updateProduct(Product product);
    void sellProduct(Product product);
}
