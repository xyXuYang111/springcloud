package com.xuyang.springboot.redis.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @Auther: cypc
 * @Date: 2019/9/30 13:42
 * @Description:
 */
@Data
@ToString
public class RedisPage<T> {


    private static final long serialVersionUID = -9030385356415957915L;

    private String key;

    private String jsonValue;

    /**
     * 页数
     */
    private Long pageCount;

    /**
     * 总记录数
     */
    private Long totalCount;

    /**
     * 开始索引
     */
    private Long beginIndex;

    /**
     * 结束索引
     */
    private Long endIndex;

    /**
     * 当前页
     */
    private String pageIndex;

    /**
     * 每页显示多少页
     */
    private String pageSize;

    /**
     * 业务逻辑
     */
    private Map map;

    /**
     * 业务逻辑
     */
    private List<T> list;
}
