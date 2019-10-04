package com.xuyang.springboot.admin.redis;

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
@FeignClient(value = "server-redis")
public interface LoggInfoRedisFeign {

    @RequestMapping(value = "getLoggInfoList", method = RequestMethod.POST)
    public List<LoggInfo> getLoggInfoList(@RequestBody LoggInfo loggInfo);

    @RequestMapping(value = "getLoggInfoObject", method = RequestMethod.POST)
    public LoggInfo redisLoggInfoObject(@RequestBody LoggInfo loggInfo);

    @RequestMapping(value = "getLoggInfoMap", method = RequestMethod.POST)
    public LoggInfo getLoggInfoMap(@RequestBody LoggInfo loggInfo);

    @RequestMapping(value = "insertLoggInfoList", method = RequestMethod.POST)
    public String insertLoggInfoList(@RequestBody LoggInfo loggInfo);

    @RequestMapping(value = "insertLoggInfoObject", method = RequestMethod.POST)
    public String insertLoggInfoObject(@RequestBody LoggInfo loggInfo);

    @RequestMapping(value = "insertLoggInfoMap", method = RequestMethod.POST)
    public String insertLoggInfoMap(@RequestBody LoggInfo loggInfo);

    @RequestMapping(value = "loggInfoMapDelete", method = RequestMethod.POST)
    public String loggInfoMapDelete(@RequestBody LoggInfo loggInfo);
}
