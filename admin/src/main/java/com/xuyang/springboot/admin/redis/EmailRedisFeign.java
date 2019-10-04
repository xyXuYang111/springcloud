package com.xuyang.springboot.admin.redis;

import com.xuyang.springboot.admin.model.Email;
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
@FeignClient(value = "redis")
public interface EmailRedisFeign {

    @RequestMapping(value = "getEmailList", method = RequestMethod.POST)
    public List<Email> getEmailList(@RequestBody Email email);

    @RequestMapping(value = "getEmailObject", method = RequestMethod.POST)
    public Email redisEmailObject(@RequestBody Email email);

    @RequestMapping(value = "getEmailMap", method = RequestMethod.POST)
    public Email getEmailMap(@RequestBody Email email);

    @RequestMapping(value = "insertEmailList", method = RequestMethod.POST)
    public String insertEmailList(@RequestBody Email email);

    @RequestMapping(value = "insertEmailObject", method = RequestMethod.POST)
    public String insertEmailObject(@RequestBody Email email);

    @RequestMapping(value = "insertEmailMap", method = RequestMethod.POST)
    public String insertEmailMap(@RequestBody Email email);

    @RequestMapping(value = "emailMapDelete", method = RequestMethod.POST)
    public String emailMapDelete(@RequestBody Email email);
}
