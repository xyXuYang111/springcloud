package com.xuyang.springboot.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019/9/19 19:01
 * @Description:
 */
@Slf4j
@Component
public class RedisListener<T> implements MessageListener {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisService redisService;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        //信息内容
        T msgBody = (T) stringRedisTemplate.getValueSerializer().deserialize(body);
        //节点
        byte[] channel = message.getChannel();
        String msgChannel = (String) stringRedisTemplate.getValueSerializer().deserialize(channel);
        System.out.println(msgChannel);

        //数据写到redis中
        redisService.leftPush(msgChannel, msgBody);
        redisService.leftPush("TALK_CODE", msgChannel);
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String channel, String message){
        log.debug("消息内容");
        stringRedisTemplate.convertAndSend(channel, message);
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String channel, T message){
        log.debug("消息内容");
        stringRedisTemplate.convertAndSend(channel, message.toString());
    }
}
