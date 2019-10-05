package com.xuyang.springboot.mysql.service.impl;

import com.xuyang.springboot.mysql.dao.EmailDao;
import com.xuyang.springboot.mysql.dao.FilesDao;
import com.xuyang.springboot.mysql.model.Files;
import com.xuyang.springboot.mysql.service.FilesService;
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
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesDao filesDao;

    @Override
    public Files filesInfo(Files files) throws Exception {
        return filesDao.filesInfo(files);
    }

    @Override
    public List<Files> filesList(Files files) throws Exception {
        return filesDao.filesList(files);
    }

    @Override
    public void insertFiles(Files files) throws Exception {
        filesDao.insertFiles(files);
    }

    @Override
    public void updateFiles(Files files) throws Exception {
        filesDao.updateFiles(files);
    }

    @Override
    public void deleteFiles(Files files) throws Exception {
        filesDao.deleteFiles(files);
    }
}
