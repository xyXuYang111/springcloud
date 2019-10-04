package com.xuyang.springboot.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xuyang
 * @Date: 2019/10/2 19:10
 * @Description:
 */
@Data
@ToString
public class RedisModel implements Serializable {

    private static final long serialVersionUID = 3573417588124666874L;

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

    /**
     * 业务逻辑
     */
    @JsonProperty(value = "map")
    private Map map;

    /**
     * 业务逻辑
     */
    @JsonProperty(value = "list")
    private List<String> list;
}
