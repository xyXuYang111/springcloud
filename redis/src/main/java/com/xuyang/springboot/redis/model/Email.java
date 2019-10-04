package com.xuyang.springboot.redis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xuyang.springboot.redis.common.BaseModel;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @Auther: 许洋
 * @Date: 2019/1/6 21:51
 * @Description:
 */
@Data
@Slf4j
@ToString
public class Email extends BaseModel implements Serializable{

    private static final long serialVersionUID = -8991756927614538137L;

    @JsonProperty(value = "emailID")
    private String emailID;

    @JsonProperty(value = "titleName")
    private String titleName;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "sendName")
    private String sendName;

    @JsonProperty(value = "sendNumber")
    private String sendNumber;

    @JsonProperty(value = "sendPassword")
    private String sendPassword;

    @JsonProperty(value = "receiveName")
    private String receiveName;

    @JsonProperty(value = "receiveNumber")
    private String receiveNumber;

    @JsonProperty(value = "receivePassword")
    private String receivePassword;

    @JsonProperty(value = "type")
    private String type;
}
