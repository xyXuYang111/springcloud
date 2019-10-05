package com.xuyang.springboot.mysql.controller;

import com.xuyang.springboot.mysql.model.Message;
import com.xuyang.springboot.mysql.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 10:05
 * @Description:
 */
@Slf4j
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "messageInfo", method = RequestMethod.POST)
    public Message messageInfo(@RequestBody Message message) throws Exception {
        log.debug("单个查询");
        return messageService.messageInfo(message);
    }

    @RequestMapping(value = "messageList", method = RequestMethod.POST)
    public List<Message> messageList(@RequestBody Message message) throws Exception {
        log.debug("list查询");
        return messageService.messageList(message);
    }

    @RequestMapping(value = "insertMessage", method = RequestMethod.POST)
    public String insertMessage(@RequestBody Message message) throws Exception {
        log.debug("进行新增");
        messageService.insertMessage(message);
        return "新增完成";
    }

    @RequestMapping(value = "updateMessage", method = RequestMethod.POST)
    public String updateMessage(@RequestBody Message message) throws Exception {
        log.debug("进行修改");
        messageService.updateMessage(message);
        return "修改完成";
    }

    @RequestMapping(value = "deleteMessage", method = RequestMethod.POST)
    public String deleteMessage(@RequestBody Message message) throws Exception {
        log.debug("进行删除");
        messageService.deleteMessage(message);
        return "删除完成";
    }
}
