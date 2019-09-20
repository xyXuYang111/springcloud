package com.xuyang.springboot.mongo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cypc
 * @Date: 2019/9/19 18:32
 * @Description:
 */
@Slf4j
@Component
public class MongoDBService<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据某个条件倒叙查询数据
     * @param map
     * @param clazz
     * @param property1
     * @param <T>
     * @return
     */
    public <T> List<T> objectIsList(Map<String, Object> map, Class<T> clazz, String property1){
        Query query = new Query();
        for (String key : map.keySet()) {
            query.addCriteria(Criteria.where(key).is(map.get(key)));
        }
        if(property1 != null){
            //排序
            query.with(new Sort(new Sort.Order(Sort.Direction.DESC, property1)));
        }
        return mongoTemplate.find(query, clazz);
    }

    /**
     * 根据时间范围求出某个范围内的数据
     * @param map
     * @param value
     * @param begin
     * @param end
     * @param beginDate
     * @param endDate
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> objectPageInfo(Map<String, Object> map, String value, String property1,
                                      int begin, int end, Date beginDate, Date endDate, Class<T> clazz) {
        Query query = new Query();
        for(String keyLine : map.keySet()){
            query.addCriteria(Criteria.where(keyLine).is(map.get(keyLine)));
        }
        if(beginDate != null && endDate != null){
            query.addCriteria(Criteria.where(value).gte(beginDate).lte(endDate));
        }
        if(property1 != null){
            //排序
            query.with(new Sort(new Sort.Order(Sort.Direction.DESC, property1)));
        }
        query.limit(end - begin).skip(begin);
        return mongoTemplate.find(query, clazz);
    }

    /**
     * 查询某些为空的数据
     * @param map
     * @param clazz
     * @param begin
     * @param end
     * @param <T>
     * @return
     */
    public <T> List<T> objectNotPageList(Map<String, Object> map, Class<T> clazz, int begin, int end, String property1) {
        Query query = new Query();
        for(String keyLine : map.keySet()){
            //条件
            query.addCriteria(Criteria.where(keyLine).not());
        }
        //排序
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, property1)));
        return mongoTemplate.find(query.limit(end - begin).skip(begin), clazz);
    }

    /**
     * 统计查询
     * @param map
     * @param clazz
     * @return
     */
    public Long objectCount(Map<String, Object> map, Class<T> clazz) {
        Query query = new Query();
        for (String keyLine : map.keySet()) {
            //条件
            query.addCriteria(Criteria.where(keyLine).is(map.get(keyLine)));
        }
        return mongoTemplate.count(query, clazz);
    }

    public void insert(T t){
        mongoTemplate.insert(t);
    }
}
