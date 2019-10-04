package com.xuyang.springboot.admin.controller;

import com.xuyang.springboot.admin.common.BaseController;
import com.xuyang.springboot.admin.model.Files;
import com.xuyang.springboot.admin.mongo.FilesMongoFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/3 23:30
 * @Description:
 */
@Slf4j
@RestController
public class MongoController extends BaseController {

    @Autowired
    private FilesMongoFeign filesFeign;

    @RequestMapping(value = "getFilesList", method = RequestMethod.POST)
    public List<Files> getFilesList(@RequestBody(required = false) Files files){
        List<Files> filesList = filesFeign.getFilesMongoList(files);
        return filesList;
    }
}
