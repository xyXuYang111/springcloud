package com.xuyang.springboot.admin.config.mvc.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Auther: xuyang
 * @Date: 2019/9/15 01:41
 * @Description:
 */
@Slf4j
@Component
@Configuration
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.debug("servlet容器启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.debug("servlet容器销毁");
    }
}
