package com.xuyang.springboot.admin.dao;

import com.xuyang.springboot.admin.annotation.MyBatisDao;
import com.xuyang.springboot.admin.model.LoggInfo;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 23:33
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
