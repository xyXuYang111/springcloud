package com.xuyang.springboot.mysql.service;

import com.xuyang.springboot.mysql.model.Email;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:46
 * @Description:
 */
public interface EmailService {

    /**
     * 查询单个文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public Email emailInfo(Email email) throws Exception;

    /**
     * 查询多个文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public List<Email> emailList(Email email) throws Exception;

    /**
     * 新增文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public void insertEmail(Email email) throws Exception;

    /**
     * 新增文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public void updateEmail(Email email) throws Exception;

    /**
     * 新增文件信息
     * @param email
     * @return
     * @throws Exception
     */
    public void deleteEmail(Email email) throws Exception;
}
