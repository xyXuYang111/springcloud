package com.xuyang.springboot.redis.repository;

import com.xuyang.springboot.redis.service.RedisListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019/9/20 15:18
 * @Description: 发送消息
 */
@Slf4j
@Component
public class RedisListenerRepository {

    private static RedisListener redisListener;

    @Autowired
    public void setRedisListener(RedisListener redisListener) {
        RedisListenerRepository.redisListener = redisListener;
    }
}
