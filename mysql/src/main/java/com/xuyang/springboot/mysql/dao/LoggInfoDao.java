package com.xuyang.springboot.mysql.dao;

import com.xuyang.springboot.mysql.annotation.MyBatisDao;
import com.xuyang.springboot.mysql.model.LoggInfo;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:37
 * @Description:
 */
@MyBatisDao
public interface LoggInfoDao {

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
