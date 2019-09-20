package com.xuyang.springboot.mongo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @Auther: xuyang
 * @Date: 2019/9/21 01:46
 * @Description:
 */
@Data
@ToString
@Document(collection = "LoggInfo")
public class LoggInfo implements Serializable {

    private static final long serialVersionUID = -6183191377074712410L;

    @Field
    @JsonProperty(value = "logID")
    private String logID;

    @Field
    @JsonProperty(value = "logContent")
    private String logContent;

    @Field
    @JsonProperty(value = "logResult")
    private String logResult;

    @Field
    @JsonProperty(value = "logType")
    private String logType;

    @Field
    @JsonProperty(value = "createTime")
    private String createTime;

    @Field
    @JsonProperty(value = "content")
    private String content;

    @Field
    @JsonProperty(value = "code")
    private String code;

    @Field
    @JsonProperty(value = "time")
    private String time;
}
