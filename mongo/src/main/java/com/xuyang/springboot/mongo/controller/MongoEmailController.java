package com.xuyang.springboot.mongo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xuyang.springboot.mongo.common.BaseController;
import com.xuyang.springboot.mongo.model.Email;
import com.xuyang.springboot.mongo.model.Files;
import com.xuyang.springboot.mongo.service.MongoDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @Auther: xuyang
 * @Date: 2019/9/21 01:47
 * @Description:
 */
@Slf4j
@RestController
public class MongoEmailController extends BaseController {

    @Autowired
    private MongoDBService mongoDBService;

    @RequestMapping(value = "insertMailMongo", method = RequestMethod.POST)
    public String insertMailMongo(@RequestBody Email email) {
        log.debug("新增邮件记录数据测试");
        mongoDBService.insert(email);
        return "添加成功";
    }

    @RequestMapping(value = "deleteEmailMongo", method = RequestMethod.POST)
    public String deleteEmailMongo(@RequestBody Email email) {
        log.debug("删除邮件记录数据测试");
        Map<String, Object> map = email.getMap();
        mongoDBService.delete(map, Email.class);
        return "删除成功";
    }

    @RequestMapping(value = "getEmailMongoList", method = RequestMethod.POST)
    public List<Email> getEmailMongoList(@RequestBody Email email) {
        log.debug("查询mongo的list");
        Map<String, Object> map = email.getMap();
        List<Email> emailList = mongoDBService.objectIsList(map, Email.class, null);
        return emailList;
    }
}
