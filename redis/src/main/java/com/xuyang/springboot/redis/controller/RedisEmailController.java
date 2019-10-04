package com.xuyang.springboot.redis.controller;

import com.xuyang.springboot.redis.common.BaseController;
import com.xuyang.springboot.redis.model.Email;
import com.xuyang.springboot.redis.repository.RedisServiceRepository;
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
public class RedisEmailController extends BaseController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "redisEmailList", method = RequestMethod.POST)
    public List<Email> getEmailList(@RequestBody Email email){
        log.debug("redis查询key-list信息");
        String key = email.getKey();
        List<Email> emailList = redisService.getObjectList(key, 0, -1);
        return emailList;
    }

    @RequestMapping(value = "getEmailObject", method = RequestMethod.POST)
    public Email redisEmailObject(@RequestBody Email email){
        log.debug("redis查询key-object信息");
        String key = email.getKey();
        Email emailInfo = (Email)redisService.get(key);
        return emailInfo;
    }

    @RequestMapping(value = "getEmailMap", method = RequestMethod.POST)
    public Email redisEmailMap(@RequestBody Email email){
        log.debug("redis查询key-map信息");
        String key = email.getKey();
        String item = email.getItem();
        Email emailInfo = (Email)redisService.getObject(key, item);
        return emailInfo;
    }

    @RequestMapping(value = "insertEmailList", method = RequestMethod.POST)
    public String redisListInsert(@RequestBody Email email){
        log.debug("redis的key-list新增");
        String key = email.getKey();
        redisService.leftPush(key, email);
        return "新增成功";
    }

    @RequestMapping(value = "insertEmailObject", method = RequestMethod.POST)
    public String redisObjectInsert(@RequestBody Email email){
        log.debug("redis的key-value新增");
        String key = email.getKey();
        redisService.add(key, email);
        return "新增成功";
    }

    @RequestMapping(value = "insertEmailMap", method = RequestMethod.POST)
    public String redisMapInsert(@RequestBody Email email){
        log.debug("redis的key-map新增");
        String key = email.getKey();
        String item = email.getItem();
        redisService.put(key, item, email);
        return "新增成功";
    }

    @RequestMapping(value = "deleteEmailMap", method = RequestMethod.POST)
    public String redisMapDelete(@RequestBody Email email){
        log.debug("redis的key-map删除");
        String key = email.getKey();
        String item = email.getItem();
        redisService.delete(key, item);
        return "删除成功";
    }
}
