package com.xuyang.springboot.mysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:31
 * @Description:
 */
@Data
@ToString
public class Email implements Serializable {

    private static final long serialVersionUID = 7510087423306592326L;

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
