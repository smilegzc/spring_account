package com.smilegzc.spring_account.controller;

import com.smilegzc.spring_account.entity.Employee;
import com.smilegzc.spring_account.mapper.EmployeeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;

/**
 * 日期:2020/3/25
 * 时间:下午3:41
 */
@Controller
public class EmployeeController {
    final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/emps")
    public String getAllEmp(Model model, HttpSession session) {
        Collection<Employee> employees = null;
        Integer type = (Integer) session.getAttribute("type");
        if(type != null && type == 0) {
             employees = employeeMapper.getEmployees();
        } else if(type != null) {
            int id = (int) session.getAttribute("id");
            employees = Collections.singletonList(employeeMapper.getEmployeeById(id));
        }
        model.addAttribute("emps", employees);
        return "emp/list";
    }
    
    @GetMapping("/emp")
    public String toAddPage() {
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        employeeMapper.setEmployee(employee);
        return "redirect:/emps";
    }
    
    @GetMapping("/emp/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = employeeMapper.getEmployeeById(id);
        model.addAttribute("emp", employee);
        return "emp/add";
    }
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeMapper.delEmployee(id);
        return "redirect:/emps";
    }
}
