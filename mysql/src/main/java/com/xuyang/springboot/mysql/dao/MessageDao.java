package com.xuyang.springboot.mysql.dao;

import com.xuyang.springboot.mysql.annotation.MyBatisDao;
import com.xuyang.springboot.mysql.model.Message;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:37
 * @Description:
 */
@MyBatisDao
public interface MessageDao {

    /**
     * 查询单个文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public Message messageInfo(Message message) throws Exception;

    /**
     * 查询多个文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public List<Message> messageList(Message message) throws Exception;

    /**
     * 新增文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public void insertMessage(Message message) throws Exception;

    /**
     * 新增文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public void updateMessage(Message message) throws Exception;

    /**
     * 新增文件信息
     * @param message
     * @return
     * @throws Exception
     */
    public void deleteMessage(Message message) throws Exception;
}
