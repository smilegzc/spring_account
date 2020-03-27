package com.smilegzc.spring_account.controller;

import com.smilegzc.spring_account.entity.Product;
import com.smilegzc.spring_account.mapper.ProductMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 日期:2020/3/25
 * 时间:下午10:47
 */
@Controller
public class ProductController {
    
    final ProductMapper productMapper;

    public ProductController(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        Collection<Product> products = productMapper.getProducts();
        model.addAttribute("products", products);
        return "product/list";
    }
    
    @GetMapping("/product")
    public String toAddPage() {
        return "product/add";
    }
    @PostMapping("/product")
    public String addProduct(Product product) {
        productMapper.setProduct(product);
        return "redirect:/products";
    }
    
    @GetMapping("/product/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productMapper.getProductById(id);
        model.addAttribute("product", product);
        return "product/add";
    }
    @PutMapping("/product")
    public String updateProduct(Product product) {
        productMapper.updateProduct(product);
        return "redirect:/products";
    }
    
    @DeleteMapping("/product/{id}")
    public String delProduct(@PathVariable("id") int id) {
        productMapper.delProduct(id);
        return "redirect:/products";
    }
    
    @GetMapping("/sell_product/{id}")
    public String toSell(@PathVariable("id") int id, Model model) {
        Product product = productMapper.getProductById(id);
        model.addAttribute("product", product);
        return "product/sell_product";
    }
    @PutMapping("/sell_product")
    public String sellProduct(Product sellProduct) {
        productMapper.sellProduct(sellProduct);
        
        Product product = productMapper.getProductById(sellProduct.getId());
        int number = product.getNumber() + sellProduct.getNumber();
        product.setNumber(number);
        product.setPurchase(sellProduct.getPurchase());
        productMapper.updateProduct(product);
        
        return "redirect:/products";
    }
}
