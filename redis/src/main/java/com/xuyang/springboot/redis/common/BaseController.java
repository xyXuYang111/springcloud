package com.xuyang.springboot.redis.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: cypc
 * @Date: 2019/9/19 19:14
 * @Description:
 */
@Slf4j
@Component
@RestController
public class BaseController{

    @ModelAttribute
    public void init(Model model, HttpServletRequest req) throws Exception {
        log.debug("前置处理");
    }

    public String getErrorResult(){
        log.debug("Hystrix异常服务");
        return "请求失败";
    }
}
