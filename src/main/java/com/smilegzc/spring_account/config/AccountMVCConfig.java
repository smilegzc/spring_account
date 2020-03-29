package com.smilegzc.spring_account.config;

import com.smilegzc.spring_account.component.AccountLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 日期:2020/3/24
 * 时间:下午10:21
 */
@Configuration
public class AccountMVCConfig implements WebMvcConfigurer {
    /**
     *视图控制器配置，负责一些默认页面的转发
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/login").setViewName("login");
    }

    /**
     * 国际化配置
     * @return 国际化处理类
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new AccountLocalResolver();
    }
}
