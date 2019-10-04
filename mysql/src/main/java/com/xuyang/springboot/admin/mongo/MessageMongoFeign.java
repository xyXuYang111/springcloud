package com.xuyang.springboot.admin.mongo;

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
@FeignClient(value = "mongo")
public interface MessageMongoFeign {

    @RequestMapping(value = "getMessageMongoList", method = RequestMethod.POST)
    public List<Message> getMessageMongoList(@RequestBody Message message);

    @RequestMapping(value = "insertMessageMongo", method = RequestMethod.POST)
    public String insertMessageMongo(@RequestBody Message message);

    @RequestMapping(value = "deleteMessageMongo", method = RequestMethod.POST)
    public String deleteMessageMongo(@RequestBody Message message);
}
