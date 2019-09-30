package com.xuyang.springboot.redis.common;

import com.xuyang.springboot.redis.repository.RedisServiceRepository;
import com.xuyang.springboot.redis.util.DateUtil;
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
    public void exceptionHandler(Exception exception) {
        log.error(exception.getMessage(), exception);
        StringBuilder redisError = new StringBuilder();
        redisError.append("REDIS_ERROR_").append(DateUtil.getCurrentDateYYYYMMDD());
        String message = exception.getMessage();

        RedisServiceRepository.leftPush(redisError.toString(), message);
    }
}
