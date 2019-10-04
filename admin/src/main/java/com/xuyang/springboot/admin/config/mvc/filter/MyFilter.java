package com.xuyang.springboot.admin.config.mvc.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Auther: xuyang
 * @Date: 2019/9/15 01:38
 * @Description:
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
@Configuration
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //请求记录过滤监听
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("过滤器初始化");
    }

    @Override
    public void destroy() {
        log.debug("过滤器销毁");
    }
}
