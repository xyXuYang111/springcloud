package com.xuyang.springboot.mongo.repository;

import com.xuyang.springboot.mongo.service.MongoDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019/9/20 15:33
 * @Description:
 */
@Slf4j
@Component
public class MongoRepository {

    private static MongoDBService mongoDBService;

    @Autowired
    public void setMongoDBService(MongoDBService mongoDBService) {
        MongoRepository.mongoDBService = mongoDBService;
    }
}
