package com.xuyang.springboot.admin.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: cypc
 * @Date: 2019/9/19 19:14
 * @Description:
 */
@Slf4j
@Component
@Controller
public class BaseController{

    @ModelAttribute
    public void init() throws Exception {
        log.debug("前置处理");
    }
}
