package com.xuyang.springboot.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xuyang.springboot.admin.common.BaseModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: xuyang
 * @Date: 2019/9/21 01:46
 * @Description:
 */
@Data
@ToString
public class LoggInfo extends BaseModel implements Serializable {

    private static final long serialVersionUID = -6183191377074712410L;

    @JsonProperty(value = "logID")
    private String logID;

    @JsonProperty(value = "logContent")
    private String logContent;

    @JsonProperty(value = "logResult")
    private String logResult;

    @JsonProperty(value = "logType")
    private String logType;

    @JsonProperty(value = "createTime")
    private String createTime;

    @JsonProperty(value = "content")
    private String content;

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "time")
    private String time;
}
