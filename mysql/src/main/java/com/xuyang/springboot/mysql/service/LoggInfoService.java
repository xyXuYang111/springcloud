package com.xuyang.springboot.mysql.service;

import com.xuyang.springboot.mysql.model.LoggInfo;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:47
 * @Description:
 */
public interface LoggInfoService {

    /**
     * 查询单个文件信息
     * @param loggInfo
     * @return
     * @throws Exception
     */
    public LoggInfo loggInfoInfo(LoggInfo loggInfo) throws Exception;

    /**
     * 查询多个文件信息
     * @param loggInfo
     * @return
     * @throws Exception
     */
    public List<LoggInfo> loggInfoList(LoggInfo loggInfo) throws Exception;

    /**
     * 新增文件信息
     * @param loggInfo
     * @return
     * @throws Exception
     */
    public void insertLoggInfo(LoggInfo loggInfo) throws Exception;

    /**
     * 新增文件信息
     * @param loggInfo
     * @return
     * @throws Exception
     */
    public void updateLoggInfo(LoggInfo loggInfo) throws Exception;

    /**
     * 新增文件信息
     * @param loggInfo
     * @return
     * @throws Exception
     */
    public void deleteLoggInfo(LoggInfo loggInfo) throws Exception;
}
