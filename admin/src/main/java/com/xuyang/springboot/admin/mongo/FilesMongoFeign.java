package com.xuyang.springboot.admin.mongo;

import com.xuyang.springboot.admin.model.Files;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2019/10/2 19:07
 * @Description:
 */
@FeignClient(value = "mongo")
public interface FilesMongoFeign {

    @RequestMapping(value = "getFilesMongoList", method = RequestMethod.POST)
    public List<Files> getFilesMongoList(@RequestBody Files files);

    @RequestMapping(value = "insertFilesMongo", method = RequestMethod.POST)
    public String insertFilesMongo(@RequestBody Files files);

    @RequestMapping(value = "deleteFilesMongo", method = RequestMethod.POST)
    public String deleteFilesMongo(@RequestBody Files files);
}
