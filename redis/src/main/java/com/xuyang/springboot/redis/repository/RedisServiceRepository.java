package com.xuyang.springboot.redis.repository;

import com.xuyang.springboot.redis.model.RedisPage;
import com.xuyang.springboot.redis.service.RedisService;
import com.xuyang.springboot.redis.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: cypc
 * @Date: 2019/9/20 15:15
 * @Description:
 */
@Slf4j
@Component
public class RedisServiceRepository {

    private static RedisService redisService;

    @Autowired
    public void setRedisService(RedisService redisService) {
        RedisServiceRepository.redisService = redisService;
    }


    /**
     * 根据key获取value
     */
    public static Object getValueByKey(String key){
        return redisService.get(key);
    }

    /**
     * 添加对象
     */
    public static void set(String key, Object object){
        redisService.set(key, object);
    }

    /**
     * 添加对象
     */
    public static void set(String key, Object object, long time){
        redisService.set(key, object, time);
    }

    /**
     * 根据索引查询
     * @param key
     * @param index
     */
    public static Object getObject(String key, long index){
        return redisService.getObject(key, index);
    }

    /**
     *
     * @param key
     * @param start
     * @param end
     */
    public static <T> List<T> getObjectList(String key, long start, long end ){
        return redisService.getObjectList(key, start, end);
    }

    /**
     *
     * @param key
     * @param jsonValue
     */
    public static void leftPush(String key, String jsonValue){
        redisService.leftPush(key, jsonValue);
    }

    /**
     *
     * @param key
     * @param list
     */
    public static void rightPush(String key, List<Object> list){
        redisService.rightPush(key, list);
    }

    /**
     *
     * @param key
     * @param list
     * @param time
     */
    public static void rightPush(String key, List<Object> list, long time){
        redisService.rightPush(key, list, time);
    }

    /**
     *
     * @param key
     * @param object
     */
    public static void rightPush(String key, Object object){
        redisService.rightPush(key, object);
    }

    /**
     *
     * @param key
     * @param object
     * @param time
     */
    public static void rightPush(String key, Object object, long time){
        redisService.rightPush(key, object, time);
    }

    /**
     *
     * @param key
     * @param item
     * @param object
     */
    public static void setMap(String key, String item, Object object) {
        redisService.put(key, item, object);
    }

    /**
     *
     * @param key
     */
    public static Set<Object> members(String key){
        return redisService.members(key);
    }

    /**
     *
     * @param key
     * @param item
     * @param map
     */
    public static void setMap(String key, String item, Map<String, Object> map) {
        redisService.putAll(key, map);
    }

    /**
     *
     * @param key
     * @param item
     * @param map
     * @param time
     */
    public static void setMap(String key, String item, Map<String, Object> map, long time) {
        redisService.putAll(key, map, time);
    }

    /**
     *
     * @param key
     */
    public static Map<Object, Object> getMap(String key){
        return redisService.getMap(key);
    }

    /**
     *
     * @param key
     * @param item
     */
    public static Object getMap(String key, String item){
        return redisService.getObject(key, item);
    }

    /**
     *
     * @param key
     * @param item
     */
    public static void delete(String key, String item) {
        redisService.delete(key, item);
    }

    /**
     * 删除对象
     */
    public static void delete(String key) {
        redisService.delete(key);
    }

    /**
     * 获取list长度
     */
    public static long listSize(String key) {
        return redisService.size(key);
    }

    /**
     * 分页带条件显示数据
     *
     * @param redisPage
     * @return
     */
    public static <T> List<T> getRedisPageList(RedisPage redisPage) {
        //页数
        String key = redisPage.getKey();
        int pageIndex = Integer.valueOf(redisPage.getPageIndex());
        int pageSize = Integer.valueOf(redisPage.getPageSize());
        int start = (pageIndex -1)*pageSize;
        int end = start + pageSize;
        Map map = redisPage.getMap();

        List<T> objectAllList = new ArrayList<>();
        long totalCount = 0;
        for (Object pageKey : map.keySet()) {
            String keyInfo = (String) map.get(pageKey);
            StringBuilder stringBuilder = new StringBuilder();
            if (keyInfo != null) {
                stringBuilder.append(key).append(keyInfo);
            }else{
                String currentDate = DateUtil.getCurrentDateYYYYMMDD();
                stringBuilder.append(key).append(currentDate);
            }

            //获取所有数据
            Long objectSize = redisService.size(stringBuilder.toString());
            int size = objectSize.intValue();
            if (end >= size) {
                end = size;
            }
            objectAllList = redisService.getObjectList(stringBuilder.toString(), start, end);
            totalCount = size;
        }

        int skip = (start - 1) * pageSize;
        redisPage.setBeginIndex(Long.valueOf(skip + 1));
        redisPage.setTotalCount(totalCount);
        Long remainder = totalCount % pageSize;
        Long pageCount = 1L;
        if (remainder == 0) {
            pageCount = totalCount / pageSize;
        } else {
            pageCount = totalCount / pageSize + 1;
        }

        redisPage.setPageCount(pageCount);
        if (pageCount.intValue() == start) {
            redisPage.setEndIndex(skip + remainder);
        } else {
            redisPage.setEndIndex(Long.valueOf(skip + pageSize));
        }

        redisPage.setList(objectAllList);

        return objectAllList;
    }
}
