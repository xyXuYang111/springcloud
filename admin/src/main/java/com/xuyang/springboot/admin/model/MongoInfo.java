package com.xuyang.springboot.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Auther: xuyang
 * @Date: 2019/9/20 00:59
 * @Description:
 */
@Data
@Slf4j
@ToString
@Document(collection = "MongoInfo")
public class MongoInfo {

    @Id
    @JsonProperty(value = "id")
    private String id;

    @Field
    @JsonProperty(value = "time")
    private String time;
}
