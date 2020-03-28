package com.smilegzc.spring_account.service.impl;

import com.smilegzc.spring_account.entity.Product;
import com.smilegzc.spring_account.mapper.ProductMapper;
import com.smilegzc.spring_account.service.ProductService;
import org.springframework.stereotype.Service;

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
    public void sellProduct(Product sellProduct) {
        Product product = getProductById(sellProduct.getId());
        product.setPurchase(sellProduct.getPurchase());
        product.setNumber(product.getNumber() + sellProduct.getNumber());
        productMapper.sellProduct(product);
    }
}
