package com.xuyang.springboot.admin.redis;

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
@FeignClient(value = "server-redis")
public interface FilesRedisFeign {

    @RequestMapping(value = "getFilesList", method = RequestMethod.POST)
    public List<Files> getFilesList(@RequestBody Files files);

    @RequestMapping(value = "getFilesObject", method = RequestMethod.POST)
    public Files redisFilesObject(@RequestBody Files files);

    @RequestMapping(value = "getFilesMap", method = RequestMethod.POST)
    public Files getFilesMap(@RequestBody Files files);

    @RequestMapping(value = "insertFilesList", method = RequestMethod.POST)
    public String insertFilesList(@RequestBody Files files);

    @RequestMapping(value = "insertFilesObject", method = RequestMethod.POST)
    public String insertFilesObject(@RequestBody Files files);

    @RequestMapping(value = "insertFilesMap", method = RequestMethod.POST)
    public String insertFilesMap(@RequestBody Files files);

    @RequestMapping(value = "fileMapDelete", method = RequestMethod.POST)
    public String fileMapDelete(@RequestBody Files files);
}
