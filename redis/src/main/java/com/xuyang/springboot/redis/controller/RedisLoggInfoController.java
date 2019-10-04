package com.xuyang.springboot.redis.controller;

import com.xuyang.springboot.redis.common.BaseController;
import com.xuyang.springboot.redis.model.LoggInfo;
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
public class RedisLoggInfoController extends BaseController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "redisLoggInfoList", method = RequestMethod.POST)
    public List<LoggInfo> getLoggInfoList(@RequestBody LoggInfo loggInfo){
        log.debug("redis查询key-list信息");
        String key = loggInfo.getKey();
        List<LoggInfo> loggInfoList = redisService.getObjectList(key, 0, -1);
        return loggInfoList;
    }

    @RequestMapping(value = "getLoggInfoObject", method = RequestMethod.POST)
    public LoggInfo redisLoggInfoObject(@RequestBody LoggInfo loggInfo){
        log.debug("redis查询key-object信息");
        String key = loggInfo.getKey();
        LoggInfo loggInfoInfo = (LoggInfo)redisService.get(key);
        return loggInfoInfo;
    }

    @RequestMapping(value = "getLoggInfoMap", method = RequestMethod.POST)
    public LoggInfo redisLoggInfoMap(@RequestBody LoggInfo loggInfo){
        log.debug("redis查询key-map信息");
        String key = loggInfo.getKey();
        String item = loggInfo.getItem();
        LoggInfo loggInfoInfo = (LoggInfo)redisService.getObject(key, item);
        return loggInfoInfo;
    }

    @RequestMapping(value = "insertLoggInfoList", method = RequestMethod.POST)
    public String redisListInsert(@RequestBody LoggInfo loggInfo){
        log.debug("redis的key-list新增");
        String key = loggInfo.getKey();
        redisService.leftPush(key, loggInfo);
        return "新增成功";
    }

    @RequestMapping(value = "insertLoggInfoObject", method = RequestMethod.POST)
    public String redisObjectInsert(@RequestBody LoggInfo loggInfo){
        log.debug("redis的key-value新增");
        String key = loggInfo.getKey();
        redisService.add(key, loggInfo);
        return "新增成功";
    }

    @RequestMapping(value = "insertLoggInfoMap", method = RequestMethod.POST)
    public String redisMapInsert(@RequestBody LoggInfo loggInfo){
        log.debug("redis的key-map新增");
        String key = loggInfo.getKey();
        String item = loggInfo.getItem();
        redisService.put(key, item, loggInfo);
        return "新增成功";
    }

    @RequestMapping(value = "deleteLoggInfoMap", method = RequestMethod.POST)
    public String redisMapDelete(@RequestBody LoggInfo loggInfo){
        log.debug("redis的key-map删除");
        String key = loggInfo.getKey();
        String item = loggInfo.getItem();
        redisService.delete(key, item);
        return "删除成功";
    }
}
