package com.smilegzc.spring_account.controller;

import com.smilegzc.spring_account.entity.Employee;
import com.smilegzc.spring_account.mapper.EmployeeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

/**
 * 日期:2020/3/24
 * 时间:下午9:16
 */
@Controller
public class LoginController {
    final EmployeeMapper employeeMapper;

    public LoginController(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    /**
     * 登录控制
     */
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        Employee employee = null;
        if(username != null) {
            employee = employeeMapper.getEmployeeByUser(username);
        }

        if(employee != null && employee.getPassword().equals(password)) {
            session.setAttribute("id", employee.getId());
            session.setAttribute("name", employee.getName());
            session.setAttribute("type", employee.getType());
            return "redirect:/main";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
    
    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            request.getSession().removeAttribute(attributeNames.nextElement());
        }
        return "redirect:/index";
    }
    
    @RequestMapping("/error/authority")
    public String authority() {
        return "error/authority";
    }
}
