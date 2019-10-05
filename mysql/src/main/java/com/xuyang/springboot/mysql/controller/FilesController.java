package com.xuyang.springboot.mysql.controller;

import com.xuyang.springboot.mysql.model.Files;
import com.xuyang.springboot.mysql.service.FilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 10:03
 * @Description:
 */
@Slf4j
@RestController
public class FilesController {

    @Autowired
    private FilesService filesService;

    @RequestMapping(value = "filesInfo", method = RequestMethod.POST)
    public Files filesInfo(@RequestBody Files files) throws Exception {
        log.debug("单个信息查询");
        return filesService.filesInfo(files);
    }

    @RequestMapping(value = "filesList", method = RequestMethod.POST)
    public List<Files> filesList(@RequestBody Files files) throws Exception {
        log.debug("大量信息查询");
        return filesService.filesList(files);
    }

    @RequestMapping(value = "insertFiles", method = RequestMethod.POST)
    public String insertFiles(@RequestBody Files files) throws Exception {
        log.debug("进行新增");
        filesService.insertFiles(files);
        return "新增成功";
    }

    @RequestMapping(value = "updateFiles", method = RequestMethod.POST)
    public String updateFiles(@RequestBody Files files) throws Exception {
        log.debug("进行修改");
        filesService.updateFiles(files);
        return "修改成功";
    }

    @RequestMapping(value = "deleteFiles", method = RequestMethod.POST)
    public String deleteFiles(@RequestBody Files files) throws Exception {
        log.debug("进行删除");
        filesService.deleteFiles(files);
        return "删除成功";
    }
}
