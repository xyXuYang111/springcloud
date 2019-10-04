package com.xuyang.springboot.redis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xuyang.springboot.redis.common.BaseModel;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.Field;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @Auther: xuyang
 * @Date: 2019/9/8 13:15
 * @Description:
 */
@Data
@Slf4j
@ToString
public class Message extends BaseModel implements Serializable {

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
