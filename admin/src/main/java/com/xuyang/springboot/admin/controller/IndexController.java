package com.xuyang.springboot.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: xuyang
 * @Date: 2019/9/15 01:26
 * @Description:
 */
@Slf4j
@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping(value = "indexTextController.do")
    public String indexTextController(){
        log.debug("接口服务测试");
        return "text";
    }
}
