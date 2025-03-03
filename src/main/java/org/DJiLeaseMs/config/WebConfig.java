package org.DJiLeaseMs.config;

import lombok.extern.slf4j.Slf4j;
import org.DJiLeaseMs.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册登录拦截器...");
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/customers/**")
                .addPathPatterns("/devices/**")
                .addPathPatterns("/orderItems/**")
                .addPathPatterns("/rentalOrders/**")
                .excludePathPatterns(
                    "/user/login",
                    "/user/register",
                    "/swagger-ui/**",
                    "/v3/api-docs/**"
                )
                .excludePathPatterns(HttpMethod.OPTIONS.toString()); // 放行 OPTIONS 请求
    }
}
