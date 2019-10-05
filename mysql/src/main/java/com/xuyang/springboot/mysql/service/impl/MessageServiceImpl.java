package com.xuyang.springboot.mysql.service.impl;

import com.xuyang.springboot.mysql.dao.MessageDao;
import com.xuyang.springboot.mysql.model.Message;
import com.xuyang.springboot.mysql.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:48
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public Message messageInfo(Message message) throws Exception {
        return messageDao.messageInfo(message);
    }

    @Override
    public List<Message> messageList(Message message) throws Exception {
        return messageDao.messageList(message);
    }

    @Override
    public void insertMessage(Message message) throws Exception {
        messageDao.insertMessage(message);
    }

    @Override
    public void updateMessage(Message message) throws Exception {
        messageDao.updateMessage(message);
    }

    @Override
    public void deleteMessage(Message message) throws Exception {
        messageDao.deleteMessage(message);
    }
}
