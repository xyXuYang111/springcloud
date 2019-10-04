package com.xuyang.springboot.redis.controller;

import com.xuyang.springboot.redis.common.BaseController;
import com.xuyang.springboot.redis.model.Message;
import com.xuyang.springboot.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: cypc
 * @Date: 2019/9/20 15:15
 * @Description: redis服务对外提供服务
 */
@Slf4j
@RestController
public class RedisMessageController extends BaseController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "redisMessageList", method = RequestMethod.POST)
    public List<Message> getMessageList(@RequestBody Message message){
        log.debug("redis查询key-list信息");
        String key = message.getKey();
        List<Message> messageList = redisService.getObjectList(key, 0, -1);
        return messageList;
    }

    @RequestMapping(value = "getMessageObject", method = RequestMethod.POST)
    public Message redisMessageObject(@RequestBody Message message){
        log.debug("redis查询key-object信息");
        String key = message.getKey();
        Message messageInfo = (Message)redisService.get(key);
        return messageInfo;
    }

    @RequestMapping(value = "getMessageMap", method = RequestMethod.POST)
    public Message redisMessageMap(@RequestBody Message message){
        log.debug("redis查询key-map信息");
        String key = message.getKey();
        String item = message.getItem();
        Message messageInfo = (Message)redisService.getObject(key, item);
        return messageInfo;
    }

    @RequestMapping(value = "insertMessageList", method = RequestMethod.POST)
    public String redisListInsert(@RequestBody Message message){
        log.debug("redis的key-list新增");
        String key = message.getKey();
        redisService.leftPush(key, message);
        return "新增成功";
    }

    @RequestMapping(value = "insertMessageObject", method = RequestMethod.POST)
    public String redisObjectInsert(@RequestBody Message message){
        log.debug("redis的key-value新增");
        String key = message.getKey();
        redisService.add(key, message);
        return "新增成功";
    }

    @RequestMapping(value = "insertMessageMap", method = RequestMethod.POST)
    public String redisMapInsert(@RequestBody Message message){
        log.debug("redis的key-map新增");
        String key = message.getKey();
        String item = message.getItem();
        redisService.put(key, item, message);
        return "新增成功";
    }

    @RequestMapping(value = "deleteMessageMap", method = RequestMethod.POST)
    public String redisMapDelete(@RequestBody Message message){
        log.debug("redis的key-map删除");
        String key = message.getKey();
        String item = message.getItem();
        redisService.delete(key, item);
        return "删除成功";
    }
}
