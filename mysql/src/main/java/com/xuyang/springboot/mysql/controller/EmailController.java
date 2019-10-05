package com.xuyang.springboot.mysql.controller;

import com.xuyang.springboot.mysql.model.Email;
import com.xuyang.springboot.mysql.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:57
 * @Description:
 */
@Slf4j
@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "emailInfo", method = RequestMethod.POST)
    public Email emailInfo(@RequestBody Email email) throws Exception {
        log.debug("单个信息查询");
        return emailService.emailInfo(email);
    }

    @RequestMapping(value = "emailList", method = RequestMethod.POST)
    public List<Email> emailList(@RequestBody Email email) throws Exception {
        log.debug("批量信息查询");
        return emailService.emailList(email);
    }

    @RequestMapping(value = "insertEmail", method = RequestMethod.POST)
    public String insertEmail(@RequestBody Email email) throws Exception {
        log.debug("新增成功");
        emailService.insertEmail(email);
        return "新增成功";
    }

    @RequestMapping(value = "updateEmail", method = RequestMethod.POST)
    public String updateEmail(@RequestBody Email email) throws Exception {
        log.debug("修改信息");
        emailService.updateEmail(email);
        return "修改成功";
    }

    @RequestMapping(value = "deleteEmail", method = RequestMethod.POST)
    public String deleteEmail(@RequestBody Email email) throws Exception {
        log.debug("删除信息");
        emailService.deleteEmail(email);
        return "删除成功";
    }
}
