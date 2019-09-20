package com.xuyang.springboot.redis.repository;

import com.xuyang.springboot.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019/9/20 15:15
 * @Description:
 */
@Slf4j
@Component
public class RedisServiceRepository {

    private static RedisService redisService;

    @Autowired
    public void setRedisService(RedisService redisService) {
        RedisServiceRepository.redisService = redisService;
    }


}
