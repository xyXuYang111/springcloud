package com.xuyang.springboot.admin.mongo;

import com.xuyang.springboot.admin.model.LoggInfo;
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
public interface LoggInfoMongoFeign {

    @RequestMapping(value = "getLoggInfoMongoList", method = RequestMethod.POST)
    public List<LoggInfo> getLoggInfoMongoList(@RequestBody LoggInfo loggInfo);

    @RequestMapping(value = "insertLoggInfoMongo", method = RequestMethod.POST)
    public String insertLoggInfoMongo(@RequestBody LoggInfo loggInfo);

    @RequestMapping(value = "deleteLoggInfoMongo", method = RequestMethod.POST)
    public String deleteLoggInfoMongo(@RequestBody LoggInfo loggInfo);
}
