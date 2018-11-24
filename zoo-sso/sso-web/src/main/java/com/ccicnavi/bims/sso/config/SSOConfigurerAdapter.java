package com.ccicnavi.bims.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SSOConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    SSOInterceptor ssoInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ssoInterceptor)
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/**");
    }
}
