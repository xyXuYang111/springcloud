package com.xuyang.springboot.admin.controller;

import com.xuyang.springboot.admin.model.Message;
import com.xuyang.springboot.admin.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/9/8 13:32
 * @Description:
 */
@Slf4j
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "insertMessage", method = RequestMethod.POST)
    public String insertMessage(@RequestBody Message message) throws Exception{
        messageService.insertMessage(message);
        return "新增成功";
    }

    @RequestMapping(value = "updateMessage", method = RequestMethod.POST)
    public String updateMessage(@RequestBody Message message) throws Exception{
        messageService.updateMessage(message);
        return "修改成功";
    }

    @RequestMapping(value = "deleteMessage", method = RequestMethod.POST)
    public String deleteMessage(@RequestBody Message message) throws Exception{
        messageService.deleteMessage(message);
        return "删除成功";
    }

    @RequestMapping(value = "getMessageList", method = RequestMethod.POST)
    public List<Message> getMessageList(@RequestBody Message message) throws Exception {
        List<Message> messageList = messageService.messageList(message);
        return messageList;
    }

    @RequestMapping(value = "getMessagePageList", method = RequestMethod.POST)
    public List<Message> getMessagePageList(@RequestBody Message message) throws Exception {
        String pageIndex = message.getPageIndex();
        String pageSize = message.getPageSize();
        List<Message> messageList = messageService.messageList(message, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        return messageList;
    }
}
