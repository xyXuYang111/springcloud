package com.xuyang.springboot.admin.controller;

import com.xuyang.springboot.admin.model.LoggInfo;
import com.xuyang.springboot.admin.service.LoggInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class LoggInfoController {

    @Autowired
    private LoggInfoService loggInfoService;

    @RequestMapping(value = "insertLoggInfo", method = RequestMethod.POST)
    public String insertLoggInfo(@RequestBody LoggInfo loggInfo) throws Exception{
        loggInfoService.insertLoggInfo(loggInfo);
        return "新增成功";
    }

    @RequestMapping(value = "updateLoggInfo", method = RequestMethod.POST)
    public String updateLoggInfo(@RequestBody LoggInfo loggInfo) throws Exception{
        loggInfoService.updateLoggInfo(loggInfo);
        return "修改成功";
    }

    @RequestMapping(value = "deleteLoggInfo", method = RequestMethod.POST)
    public String deleteLoggInfo(@RequestBody LoggInfo loggInfo) throws Exception{
        loggInfoService.deleteLoggInfo(loggInfo);
        return "删除成功";
    }

    @RequestMapping(value = "getLoggInfoList", method = RequestMethod.POST)
    public List<LoggInfo> getLoggInfoList(@RequestBody LoggInfo loggInfo) throws Exception {
        List<LoggInfo> loggInfoList = loggInfoService.loggInfoList(loggInfo);
        return loggInfoList;
    }

    @RequestMapping(value = "getLoggInfoPageList", method = RequestMethod.POST)
    public List<LoggInfo> getLoggInfoPageList(@RequestBody LoggInfo loggInfo) throws Exception {
        String pageIndex = loggInfo.getPageIndex();
        String pageSize = loggInfo.getPageSize();
        List<LoggInfo> loggInfoList = loggInfoService.loggInfoList(loggInfo, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        return loggInfoList;
    }
}
