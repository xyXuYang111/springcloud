package com.xuyang.springboot.admin.config.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/9/15 01:43
 * @Description:
 */
@Slf4j
@Component
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean("filterRegistrationBean")
    public FilterRegistrationBean filterRegistrationBean(){
        log.debug("配置过滤器");
        MyFilter demoFilter=new MyFilter();
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(demoFilter);
        List<String> urlPatterns=new ArrayList<>();
        urlPatterns.add("/*");//拦截路径，可以添加多个
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean("servletListenerRegistrationBean")
    public ServletListenerRegistrationBean<EventListener> servletListenerRegistrationBean(){
        log.debug("配置监听器");
        ServletListenerRegistrationBean<EventListener> registrationBean
                =new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new MyListener());
        return registrationBean;
    }

    @Bean("viewResolver")
    public ViewResolver viewResolver() {
        log.debug("配置视图解析器");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        return resolver;
    }

    @Bean("commonsMultipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        log.debug("配置文件上传大小");
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(104857600);
        commonsMultipartResolver.setMaxInMemorySize(4096);
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        return commonsMultipartResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.debug("配置拦截器");
        registry.addInterceptor(new MyInterceptors()).addPathPatterns("/**")
                .excludePathPatterns("/static/").excludePathPatterns("/template/");
        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        log.debug("配置启动时候的重定向地址");
        registry.addRedirectViewController("/", "indexTextController.do");
        super.addViewControllers(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.debug("配置静态资源放行地址");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
