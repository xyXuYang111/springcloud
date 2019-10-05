package com.xuyang.springboot.mysql.dao;

import com.xuyang.springboot.mysql.annotation.MyBatisDao;
import com.xuyang.springboot.mysql.model.Email;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:37
 * @Description:
 */
@MyBatisDao
public interface EmailDao {

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
