package com.xuyang.springboot.mongo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: cypc
 * @Date: 2019/9/19 19:12
 * @Description:
 */
@Slf4j
@Component
@RestControllerAdvice
public class RestExpectionController {

    /**
     * 全局异常:restController修饰接口异常捕获机制
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception exception) {
        log.error(exception.getMessage(), exception);
        return "异常数据";
    }
}
