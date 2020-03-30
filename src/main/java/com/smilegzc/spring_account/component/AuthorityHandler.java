package com.smilegzc.spring_account.component;

import com.smilegzc.spring_account.exception.AccountException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日期:2020/3/29
 * 时间:下午11:15
 */
public class AuthorityHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer loginType = (Integer) request.getSession().getAttribute("type");
        if(loginType != null) {
            if(loginType != 0) {
                String path = request.getServletPath();
                if(!ordinaryUrlVerify(path)) {
                    throw new AccountException("没有访问权限");
                }
            }
        } else {
            request.setAttribute("msg", "没有权限，请登录");
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        }
        return true;
    }
    
    public boolean ordinaryUrlVerify(String servletPath) {
        String[] ordinaryUrl = {"/error", "/customers", "/customer", "/user/logout", "/order", "/orders"};
        for(String s:ordinaryUrl) {
            if(servletPath.startsWith("/emp") || servletPath.equals(s)){
                return true;
            }
        }
        return false;
    }
}
