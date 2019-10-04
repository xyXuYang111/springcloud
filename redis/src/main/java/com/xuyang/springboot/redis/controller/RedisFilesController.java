package com.xuyang.springboot.redis.controller;

import com.xuyang.springboot.redis.common.BaseController;
import com.xuyang.springboot.redis.model.Email;
import com.xuyang.springboot.redis.model.Files;
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
public class RedisFilesController extends BaseController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "getFilesList", method = RequestMethod.POST)
    public List<Files> getFilesList(@RequestBody Files files){
        log.debug("files查询key-list信息");
        String key = files.getKey();
        List<Files> filesList = redisService.getObjectList(key, 0, -1);
        return filesList;
    }

    @RequestMapping(value = "getFilesObject", method = RequestMethod.POST)
    public Files redisFilesObject(@RequestBody Files files){
        log.debug("files查询key-object信息");
        String key = files.getKey();
        Files filesInfo = (Files)redisService.get(key);
        return filesInfo;
    }

    @RequestMapping(value = "getFilesMap", method = RequestMethod.POST)
    public Files getFilesMap(@RequestBody Files files){
        log.debug("files查询key-map信息");
        String key = files.getKey();
        String item = files.getItem();
        Files filesInfo = (Files)redisService.getObject(key, item);
        return filesInfo;
    }

    @RequestMapping(value = "insertFilesList", method = RequestMethod.POST)
    public String insertFilesList(@RequestBody Files files){
        log.debug("files的key-list新增");
        String key = files.getKey();
        redisService.leftPush(key, files);
        return "新增成功";
    }

    @RequestMapping(value = "insertFilesObject", method = RequestMethod.POST)
    public String insertFilesObject(@RequestBody Files files){
        log.debug("files的key-value新增");
        String key = files.getKey();
        redisService.add(key, files);
        return "新增成功";
    }

    @RequestMapping(value = "insertFilesMap", method = RequestMethod.POST)
    public String insertFilesMap(@RequestBody Files files){
        log.debug("files的key-map新增");
        String key = files.getKey();
        String item = files.getItem();
        redisService.put(key, item, files);
        return "新增成功";
    }

    @RequestMapping(value = "fileMapDelete", method = RequestMethod.POST)
    public String fileMapDelete(@RequestBody Files files){
        log.debug("files的key-map删除");
        String key = files.getKey();
        String item = files.getItem();
        redisService.delete(key, item);
        return "删除成功";
    }
}
