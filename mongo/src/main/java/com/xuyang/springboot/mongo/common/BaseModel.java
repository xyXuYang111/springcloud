package com.xuyang.springboot.mongo.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Auther: xuyang
 * @Date: 2019/10/3 21:48
 * @Description:
 */
@Data
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 9092732447178859950L;

    @JsonProperty(value = "key")
    private String key;

    @JsonProperty(value = "jsonValue")
    private String jsonValue;

    /**
     * 页数
     */
    @JsonProperty(value = "pageCount")
    private Long pageCount;

    /**
     * 总记录数
     */
    @JsonProperty(value = "totalCount")
    private Long totalCount;

    /**
     * 开始索引
     */
    @JsonProperty(value = "beginIndex")
    private Long beginIndex;

    /**
     * 结束索引
     */
    @JsonProperty(value = "endIndex")
    private Long endIndex;

    /**
     * 当前页
     */
    @JsonProperty(value = "pageIndex")
    private String pageIndex;

    /**
     * 每页显示多少页
     */
    @JsonProperty(value = "pageSize")
    private String pageSize;

    @JsonProperty(value = "item")
    private String item;

    /**
     * 业务逻辑
     */
    @JsonProperty(value = "map")
    private Map map;
}
