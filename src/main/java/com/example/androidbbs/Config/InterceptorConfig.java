package com.example.androidbbs.Config;

import com.example.androidbbs.Interceptor.RoleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {


    @Autowired
    private RoleInterceptor roleInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(roleInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login/**","/**/register/**");
    }
}
