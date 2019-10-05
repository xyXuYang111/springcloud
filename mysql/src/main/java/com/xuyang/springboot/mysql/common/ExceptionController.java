package com.xuyang.springboot.mysql.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: cypc
 * @Date: 2019/9/19 19:12
 * @Description:
 */
@Slf4j
@ControllerAdvice
public class ExceptionController {

    /**
     * 全局异常
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception exception) {
        log.error(exception.getMessage(), exception);
        return "异常数据：" + exception.getMessage();
    }
}
