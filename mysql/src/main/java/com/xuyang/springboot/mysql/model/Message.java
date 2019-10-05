package com.xuyang.springboot.mysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:34
 * @Description:
 */
@Data
@ToString
public class Message implements Serializable {

    private static final long serialVersionUID = 5217507575665505077L;

    @JsonProperty(value = "messageID")
    private String messageID;

    @JsonProperty(value = "messageName")
    private String messageName;

    @JsonProperty(value = "messageDes")
    private String messageDes;

    @JsonProperty(value = "messageContent")
    private String messageContent;

    @JsonProperty(value = "createTime")
    private String createTime;
}
