package com.xuyang.springboot.mysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:33
 * @Description:
 */
@Data
@ToString
public class Files implements Serializable {

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
