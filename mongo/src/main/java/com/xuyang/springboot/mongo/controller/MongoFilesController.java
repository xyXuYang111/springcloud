package com.xuyang.springboot.mongo.controller;

import com.xuyang.springboot.mongo.common.BaseController;
import com.xuyang.springboot.mongo.model.Files;
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
public class MongoFilesController extends BaseController {

    @Autowired
    private MongoDBService mongoDBService;

    @RequestMapping(value = "insertFilesMongo", method = RequestMethod.POST)
    public String insertFilesMongo(@RequestBody Files files) {
        log.debug("新增邮件记录数据测试");
        mongoDBService.insert(files);
        return "添加成功";
    }

    @RequestMapping(value = "deleteFilesMongo", method = RequestMethod.POST)
    public String deleteFilesMongo(@RequestBody Files files) {
        log.debug("删除邮件记录数据测试");
        Map<String, Object> map = files.getMap();
        mongoDBService.delete(map, Files.class);
        return "删除成功";
    }

    @RequestMapping(value = "getFilesMongoList", method = RequestMethod.POST)
    public List<Files> getFilesMongoList(@RequestBody Files files) {
        log.debug("查询mongo的list");
        Map<String, Object> map = files.getMap();
        List<Files> filesList = mongoDBService.objectIsList(map, Files.class, null);
        return filesList;
    }
}
