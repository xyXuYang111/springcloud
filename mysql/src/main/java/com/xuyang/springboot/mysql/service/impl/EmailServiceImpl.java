package com.xuyang.springboot.mysql.service.impl;

import com.xuyang.springboot.mysql.dao.EmailDao;
import com.xuyang.springboot.mysql.model.Email;
import com.xuyang.springboot.mysql.service.EmailService;
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
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailDao emailDao;

    @Override
    public Email emailInfo(Email email) throws Exception {
        return emailDao.emailInfo(email);
    }

    @Override
    public List<Email> emailList(Email email) throws Exception {
        return emailDao.emailList(email);
    }

    @Override
    public void insertEmail(Email email) throws Exception {
        emailDao.insertEmail(email);
    }

    @Override
    public void updateEmail(Email email) throws Exception {
        emailDao.updateEmail(email);
    }

    @Override
    public void deleteEmail(Email email) throws Exception {
        emailDao.deleteEmail(email);
    }
}
