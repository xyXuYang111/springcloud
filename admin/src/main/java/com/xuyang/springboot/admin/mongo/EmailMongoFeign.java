package com.xuyang.springboot.admin.mongo;

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
@FeignClient(value = "server-mongo")
public interface EmailMongoFeign {

    @RequestMapping(value = "getEmailMongoList", method = RequestMethod.POST)
    public List<Email> getEmailMongoList(@RequestBody Email email);

    @RequestMapping(value = "insertEmailMongo", method = RequestMethod.POST)
    public String insertEmailMongo(@RequestBody Email email);

    @RequestMapping(value = "deleteEmailMongo", method = RequestMethod.POST)
    public String deleteEmailMongo(@RequestBody Email email);
}
