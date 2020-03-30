package com.smilegzc.spring_account.controller;

import com.smilegzc.spring_account.entity.Product;
import com.smilegzc.spring_account.entity.PurchaseProduct;
import com.smilegzc.spring_account.mapper.ProductMapper;
import com.smilegzc.spring_account.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 日期:2020/3/25
 * 时间:下午10:47
 */
@Controller
public class ProductController {
    
    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        Collection<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "product/list";
    }
    
    @GetMapping("/product")
    public String toAddPage() {
        return "product/add";
    }
    @PostMapping("/product")
    public String addProduct(Product product) {
        productService.setProduct(product);
        return "redirect:/products";
    }
    
    @GetMapping("/product/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/add";
    }
    @PutMapping("/product")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }
    
    @DeleteMapping("/product/{id}")
    public String delProduct(@PathVariable("id") int id) {
        productService.delProduct(id);
        return "redirect:/products";
    }
    
    @GetMapping("/sell_product/{id}")
    public String toSell(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/sell_product";
    }
    @PutMapping("/sell_product")
    public String purchaseProduct(Product sellProduct) {
        productService.purchaseProduct(sellProduct);
        return "redirect:/products";
    }
    
    @GetMapping("/reports")
    public String reports(String start, String end, Model model) {
        Collection<PurchaseProduct> purchaseProducts = 
                productService.getPurchaseProductByDates(start, end);

        model.addAttribute("reports", purchaseProducts);
        return "product/sell_product";
    }

    @PostMapping("/reports")
    @ResponseBody
    public String delReports(int id) {
        productService.delPurchaseProduct(id);
        return "success";
    }
}
