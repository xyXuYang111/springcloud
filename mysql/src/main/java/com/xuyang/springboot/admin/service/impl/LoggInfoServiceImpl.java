package com.xuyang.springboot.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuyang.springboot.admin.dao.LoggInfoDao;
import com.xuyang.springboot.admin.model.LoggInfo;
import com.xuyang.springboot.admin.service.LoggInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 23:37
 * @Description:
 */
@Slf4j
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
    public List<LoggInfo> loggInfoList(LoggInfo loggInfo, int startIndex, int pageSize) throws Exception {
        PageHelper.startPage(startIndex, pageSize);
        PageInfo<LoggInfo> loggInfoPageInfo = new PageInfo<>(loggInfoDao.loggInfoList(loggInfo));
        return loggInfoPageInfo.getList();
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
