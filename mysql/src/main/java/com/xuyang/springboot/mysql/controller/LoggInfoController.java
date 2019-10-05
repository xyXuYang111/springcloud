package com.xuyang.springboot.mysql.controller;

import com.xuyang.springboot.mysql.model.LoggInfo;
import com.xuyang.springboot.mysql.service.LoggInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 10:04
 * @Description:
 */
@Slf4j
@RestController
public class LoggInfoController {

    @Autowired
    private LoggInfoService loggInfoService;

    @RequestMapping(value = "loggInfoInfo", method = RequestMethod.POST)
    public LoggInfo loggInfoInfo(@RequestBody LoggInfo loggInfo) throws Exception {
        log.debug("单个信息查询");
        return loggInfoService.loggInfoInfo(loggInfo);
    }

    @RequestMapping(value = "loggInfoList", method = RequestMethod.POST)
    public List<LoggInfo> loggInfoList(@RequestBody LoggInfo loggInfo) throws Exception {
        log.debug("list查询");
        return loggInfoService.loggInfoList(loggInfo);
    }

    @RequestMapping(value = "insertLoggInfo", method = RequestMethod.POST)
    public String insertLoggInfo(@RequestBody LoggInfo loggInfo) throws Exception {
        log.debug("进行新增");
        loggInfoService.insertLoggInfo(loggInfo);
        return "新增成功";
    }

    @RequestMapping(value = "updateLoggInfo", method = RequestMethod.POST)
    public String updateLoggInfo(@RequestBody LoggInfo loggInfo) throws Exception {
        log.debug("进行修改");
        loggInfoService.updateLoggInfo(loggInfo);
        return "修改成功";
    }

    @RequestMapping(value = "updateLoggInfo", method = RequestMethod.POST)
    public String deleteLoggInfo(@RequestBody LoggInfo loggInfo) throws Exception {
        log.debug("进行删除");
        loggInfoService.deleteLoggInfo(loggInfo);
        return "删除成功";
    }
}
