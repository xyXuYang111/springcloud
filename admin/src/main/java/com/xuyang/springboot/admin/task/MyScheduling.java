package com.xuyang.springboot.admin.task;

import com.xuyang.springboot.admin.model.MongoInfo;
import com.xuyang.springboot.admin.mongoDB.MongoDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Auther: cypc
 * @Date: 2019/9/19 19:04
 * @Description:
 */
@Slf4j
@Component
@Configuration
@EnableScheduling
public class MyScheduling {

    @Autowired
    private MongoDBService mongoDBService;

    @Scheduled(cron = "0 */1 * * * ?")
    public void tesk1(){
        log.debug("mongoDB定时调度");
        String uuid = String.valueOf(UUID.randomUUID());
        MongoInfo mongoInfo = new MongoInfo();
        mongoInfo.setId(uuid);
        mongoInfo.setTime(String.valueOf(System.currentTimeMillis()));

        mongoDBService.insert(mongoInfo);
    }
}
