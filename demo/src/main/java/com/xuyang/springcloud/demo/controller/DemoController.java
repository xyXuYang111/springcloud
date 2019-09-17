package com.xuyang.springcloud.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: xuyang
 * @Date: 2019/9/18 00:41
 * @Description:
 */
@Controller
public class DemoController {

    @ResponseBody
    @RequestMapping(value = "textDemo.do")
    public String textDemo(){
        return "测试成功";
    }
}
