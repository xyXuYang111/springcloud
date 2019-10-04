package com.xuyang.springboot.admin.dao;

import com.xuyang.springboot.admin.annotation.MyBatisDao;
import com.xuyang.springboot.admin.model.Files;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 22:56
 * @Description:
 */
@MyBatisDao
public interface FilesDao {

    /**
     * 查询单个文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public Files fileInfo(Files files) throws Exception;

    /**
     * 查询多个文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public List<Files> fileList(Files files) throws Exception;

    /**
     * 新增文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public void insertFile(Files files) throws Exception;

    /**
     * 新增文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public void updateFile(Files files) throws Exception;

    /**
     * 新增文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public void deleteFile(Files files) throws Exception;
}
