package com.smilegzc.spring_account.mapper;

import com.smilegzc.spring_account.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 日期:2020/3/24
 * 时间:下午11:21
 */
@Service
public interface EmployeeMapper {
    Employee getEmployeeById(int id);
    Employee getEmployeeByUser(String username);
    Collection<Employee> getEmployees();
    void setEmployee(Employee employee);
    void delEmployee(int id);
    void updateEmployee(Employee employee);
}
