package com.xuyang.springboot.admin.redis;

import com.xuyang.springboot.admin.model.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/2 19:07
 * @Description:
 */
@FeignClient(value = "server-redis")
public interface MessageRedisFeign {

    @RequestMapping(value = "getMessageList", method = RequestMethod.POST)
    public List<Message> getMessageList(@RequestBody Message message);

    @RequestMapping(value = "getMessageObject", method = RequestMethod.POST)
    public Message redisMessageObject(@RequestBody Message message);

    @RequestMapping(value = "getMessageMap", method = RequestMethod.POST)
    public Message getMessageMap(@RequestBody Message message);

    @RequestMapping(value = "insertMessageList", method = RequestMethod.POST)
    public String insertMessageList(@RequestBody Message message);

    @RequestMapping(value = "insertMessageObject", method = RequestMethod.POST)
    public String insertMessageObject(@RequestBody Message message);

    @RequestMapping(value = "insertMessageMap", method = RequestMethod.POST)
    public String insertMessageMap(@RequestBody Message message);

    @RequestMapping(value = "messageMapDelete", method = RequestMethod.POST)
    public String messageMapDelete(@RequestBody Message message);
}
