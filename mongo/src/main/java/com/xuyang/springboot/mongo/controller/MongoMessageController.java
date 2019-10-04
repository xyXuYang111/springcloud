package com.xuyang.springboot.mongo.controller;

import com.xuyang.springboot.mongo.common.BaseController;
import com.xuyang.springboot.mongo.model.Message;
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
public class MongoMessageController extends BaseController {

    @Autowired
    private MongoDBService mongoDBService;

    @RequestMapping(value = "insertMessageMongo", method = RequestMethod.POST)
    public String insertMessageMongo(@RequestBody Message message) {
        log.debug("新增邮件记录数据测试");
        mongoDBService.insert(message);
        return "添加成功";
    }

    @RequestMapping(value = "deleteMessageMongo", method = RequestMethod.POST)
    public String deleteMessageMongo(@RequestBody Message message) {
        log.debug("删除邮件记录数据测试");
        Map<String, Object> map = message.getMap();
        mongoDBService.delete(map, Message.class);
        return "删除成功";
    }

    @RequestMapping(value = "getMessageMongoList", method = RequestMethod.POST)
    public List<Message> getMessageMongoList(@RequestBody Message message) {
        log.debug("查询mongo的list");
        Map<String, Object> map = message.getMap();
        List<Message> messageList = mongoDBService.objectIsList(map, Message.class, null);
        return messageList;
    }
}
