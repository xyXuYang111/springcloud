package com.xuyang.springboot.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xuyang.springboot.admin.common.BaseModel;

import java.io.Serializable;

/**
 * @Auther: xuyang
 * @Date: 2019/10/2 17:41
 * @Description:
 */
public class Email extends BaseModel implements Serializable {

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
