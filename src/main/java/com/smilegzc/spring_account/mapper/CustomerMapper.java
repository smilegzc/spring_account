package com.smilegzc.spring_account.mapper;

import com.smilegzc.spring_account.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 日期:2020/3/26
 * 时间:下午5:25
 */
@Service
public interface CustomerMapper {
    Collection<Customer> getCustomers();
    Customer getCustomerById(int id);
    Customer getCustomerByName(String name);
    void setCustomer(Customer customer);
    void delCustomer(int id);
    void updateCustomer(Customer customer);
}
