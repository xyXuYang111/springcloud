package com.xuyang.springboot.admin.mongo.files;

import com.xuyang.springboot.admin.mongo.files.MongoFileFeign;
import com.xuyang.springboot.admin.mongo.files.model.Files;

/**
 * @Auther: xuyang
 * @Date: 2019/9/21 02:19
 * @Description:
 */
public class MongoFileFeignImpl implements MongoFileFeign {
    @Override
    public String insertFilesMongo(Files files) {
        return "系统异常，正在进行维护";
    }
}
