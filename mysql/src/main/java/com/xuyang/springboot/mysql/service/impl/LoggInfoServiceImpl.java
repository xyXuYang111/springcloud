package com.xuyang.springboot.mysql.service.impl;

import com.xuyang.springboot.mysql.dao.LoggInfoDao;
import com.xuyang.springboot.mysql.model.LoggInfo;
import com.xuyang.springboot.mysql.service.LoggInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:49
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoggInfoServiceImpl implements LoggInfoService {

    @Autowired
    private LoggInfoDao loggInfoDao;

    @Override
    public LoggInfo loggInfoInfo(LoggInfo loggInfo) throws Exception {
        return loggInfoDao.loggInfoInfo(loggInfo);
    }

    @Override
    public List<LoggInfo> loggInfoList(LoggInfo loggInfo) throws Exception {
        return loggInfoDao.loggInfoList(loggInfo);
    }

    @Override
    public void insertLoggInfo(LoggInfo loggInfo) throws Exception {
        loggInfoDao.insertLoggInfo(loggInfo);
    }

    @Override
    public void updateLoggInfo(LoggInfo loggInfo) throws Exception {
        loggInfoDao.updateLoggInfo(loggInfo);
    }

    @Override
    public void deleteLoggInfo(LoggInfo loggInfo) throws Exception {
        loggInfoDao.deleteLoggInfo(loggInfo);
    }
}
