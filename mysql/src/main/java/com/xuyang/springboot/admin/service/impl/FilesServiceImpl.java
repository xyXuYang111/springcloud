package com.xuyang.springboot.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuyang.springboot.admin.dao.FilesDao;
import com.xuyang.springboot.admin.model.Files;
import com.xuyang.springboot.admin.service.FilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 23:02
 * @Description:
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesDao fileDao;

    @Override
    public Files filesInfo(Files files) throws Exception {
        return fileDao.fileInfo(files);
    }

    @Override
    public List<Files> filesList(Files files) throws Exception {
        return fileDao.fileList(files);
    }

    @Override
    public List<Files> filesList(Files files, int startIndex, int pageSize) throws Exception {
        PageHelper.startPage(startIndex, pageSize);
        PageInfo<Files> pageInfo = new PageInfo<>(fileDao.fileList(files));
        return pageInfo.getList();
    }

    @Override
    public void insertFiles(Files files) throws Exception {
        fileDao.insertFile(files);
    }

    @Override
    public void updateFiles(Files files) throws Exception {
        fileDao.updateFile(files);
    }

    @Override
    public void deleteFiles(Files files) throws Exception {
        fileDao.deleteFile(files);
    }
}
