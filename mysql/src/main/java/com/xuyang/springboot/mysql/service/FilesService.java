package com.xuyang.springboot.mysql.service;

import com.xuyang.springboot.mysql.model.Files;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:46
 * @Description:
 */
public interface FilesService {

    /**
     * 查询单个文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public Files filesInfo(Files files) throws Exception;

    /**
     * 查询多个文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public List<Files> filesList(Files files) throws Exception;

    /**
     * 新增文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public void insertFiles(Files files) throws Exception;

    /**
     * 新增文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public void updateFiles(Files files) throws Exception;

    /**
     * 新增文件信息
     * @param files
     * @return
     * @throws Exception
     */
    public void deleteFiles(Files files) throws Exception;
}
