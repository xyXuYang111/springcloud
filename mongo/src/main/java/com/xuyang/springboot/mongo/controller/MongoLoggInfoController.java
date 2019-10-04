package com.xuyang.springboot.mongo.controller;

import com.xuyang.springboot.mongo.common.BaseController;
import com.xuyang.springboot.mongo.model.LoggInfo;
import com.xuyang.springboot.mongo.service.MongoDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auther: xuyang
 * @Date: 2019/9/21 01:47
 * @Description:
 */
@Slf4j
@RestController
public class MongoLoggInfoController extends BaseController {

    @Autowired
    private MongoDBService mongoDBService;

    @RequestMapping(value = "insertLoggInfoMongo", method = RequestMethod.POST)
    public String insertLoggInfoMongo(@RequestBody LoggInfo loggInfo) {
        log.debug("新增邮件记录数据测试");
        mongoDBService.insert(loggInfo);
        return "添加成功";
    }

    @RequestMapping(value = "deleteLoggInfoMongo", method = RequestMethod.POST)
    public String deleteLoggInfoMongo(@RequestBody LoggInfo loggInfo) {
        log.debug("删除邮件记录数据测试");
        Map<String, Object> map = loggInfo.getMap();
        mongoDBService.delete(map, LoggInfo.class);
        return "删除成功";
    }

    @RequestMapping(value = "getLoggInfoMongoList", method = RequestMethod.POST)
    public List<LoggInfo> getLoggInfoMongoList(@RequestBody LoggInfo loggInfo) {
        log.debug("查询mongo的list");
        Map<String, Object> map = loggInfo.getMap();
        List<LoggInfo> loggInfoList = mongoDBService.objectIsList(map, LoggInfo.class, null);
        return loggInfoList;
    }
}
