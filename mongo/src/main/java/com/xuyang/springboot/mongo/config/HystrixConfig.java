package com.xuyang.springboot.mongo.config;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019/9/20 15:20
 * @Description:
 */
@Slf4j
@Component
@Configuration
public class HystrixConfig {

    @Bean
    public HystrixCommandAspect hystrixAspect() {
        log.debug("拦截HystrixCommandAspect注解");
        return new HystrixCommandAspect();
    }

    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        log.debug("用来像监控中心Dashboard发送stream信息");
        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registration.addUrlMappings("/hystrix.stream");
        return registration;
    }
}
