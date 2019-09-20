package com.xuyang.springboot.admin.mongo.files;
import com.xuyang.springboot.admin.mongo.files.model.Files;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: xuyang
 * @Date: 2019/9/21 02:04
 * @Description:
 */
@Component
@FeignClient(value = "server-mongo", fallback = MongoFileFeignImpl.class)
public interface MongoFileFeign {

    public String insertFilesMongo(@RequestBody Files files);
}
