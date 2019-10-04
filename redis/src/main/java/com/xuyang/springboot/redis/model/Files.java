package com.xuyang.springboot.redis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xuyang.springboot.redis.common.BaseModel;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @Auther: xuyang
 * @Date: 2019/9/21 01:43
 * @Description:
 */
@Data
@ToString
public class Files extends BaseModel implements Serializable {

    private static final long serialVersionUID = 2773015047054065379L;

    @JsonProperty(value = "fileID")
    private String fileID;

    @JsonProperty(value = "systemName")
    private String systemName;

    @JsonProperty(value = "fileName")
    private String fileName;

    @JsonProperty(value = "fileByte")
    private String fileByte;

    @JsonProperty(value = "fileNum")
    private String fileNum;

    @JsonProperty(value = "createTime")
    private String createTime;

    @JsonProperty(value = "filePath")
    private String filePath;

    @JsonProperty(value = "fileType")
    private String fileType;

    private MultipartFile multipartFile;
}
