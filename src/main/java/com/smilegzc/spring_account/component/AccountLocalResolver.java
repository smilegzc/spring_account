package com.smilegzc.spring_account.component;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * 日期:2020/3/24
 * 时间:下午10:08
 *
 * 国际化组件
 */
public class AccountLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String local = httpServletRequest.getParameter("local");
        Locale locale = Locale.getDefault();
        if(local != null) {
            String[] split = local.split("_");
            locale = new Locale(split[0], split[1]);
            httpServletRequest.getSession().setAttribute("locale", locale);
        } else {
            Locale localeInSession = (Locale) httpServletRequest.getSession().getAttribute("locale");
            if(localeInSession != null) {
                locale = localeInSession;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
