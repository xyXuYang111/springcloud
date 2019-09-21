package com.xuyang.springboot.mongo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xuyang.springboot.mongo.common.BaseController;
import com.xuyang.springboot.mongo.model.Email;
import com.xuyang.springboot.mongo.model.Files;
import com.xuyang.springboot.mongo.model.LoggInfo;
import com.xuyang.springboot.mongo.service.MongoDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: xuyang
 * @Date: 2019/9/21 01:47
 * @Description:
 */
@Slf4j
@RestController
public class MongoLoggInfoController extends BaseController {

    @Autowired
    private MongoDBService mongoDBService;

    @HystrixCommand(
            fallbackMethod = "getErrorResult",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),//10个核心线程池
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},//20个的队列
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"), //命令执行超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"), //若干10s一个窗口内失败三次, 则达到触发熔断的最少请求量
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000") //断路30s后尝试执行, 默认为5s
            })
    @RequestMapping(value = "insertLoggInfoMongo", method = RequestMethod.POST)
    public String insertFilesMongo(@RequestBody LoggInfo loggInfo){
        log.debug("新增日志数据测试");
        mongoDBService.insert(loggInfo);
        return "添加成功";
    }

    @HystrixCommand(
            fallbackMethod = "getErrorResult",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),//10个核心线程池
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},//20个的队列
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"), //命令执行超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"), //若干10s一个窗口内失败三次, 则达到触发熔断的最少请求量
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000") //断路30s后尝试执行, 默认为5s
            })
    @RequestMapping(value = "deleteLoggInfoMongo", method = RequestMethod.POST)
    public String deleteLoggInfoMongo(@RequestBody LoggInfo loggInfo) {
        log.debug("删除日志记录数据测试");
        Map<String, Object> map = modelAttribute(loggInfo);
        mongoDBService.delete(map, Email.class);
        return "添加成功";
    }
}
