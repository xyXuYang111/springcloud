package com.xuyang.springboot.admin.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019/9/19 19:04
 * @Description:
 */
@Slf4j
@Component
public class MyScheduling {

    @Scheduled(cron = "0 */1 * * * ?")
    public void tesk1(){
        log.debug("定时调度");
    }
}
