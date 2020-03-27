package com.smilegzc.spring_account.controller;

import com.smilegzc.spring_account.entity.Customer;
import com.smilegzc.spring_account.mapper.CustomerMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 日期:2020/3/26
 * 时间:下午5:43
 */
@Controller
public class CustomerController {
    final CustomerMapper customerMapper;

    public CustomerController(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }
    
    @GetMapping("/customers")
    public String getCustomers(Model model){
        Collection<Customer> customers = customerMapper.getCustomers();
        model.addAttribute("customers", customers);
        return "customer/list";
    }
    
    @GetMapping("/customer")
    public String toAddPage(){
        return "customer/add";
    }
    @PostMapping("/customer")
    public String addCustomer(Customer customer){
        customerMapper.setCustomer(customer);
        return "redirect:/customers";
    }
    
    @GetMapping("/customer/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model) {
        Customer customer = customerMapper.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer/add";
    }
    @PutMapping("/customer")
    public String updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
        return "redirect:/customers";
    }
    
    @DeleteMapping("/customer/{id}")
    public String delCustomer(@PathVariable("id") int id) {
        customerMapper.delCustomer(id);
        return "redirect:/customers";
    }
}
