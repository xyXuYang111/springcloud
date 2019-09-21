package com.xuyang.springboot.mongo.common;

import com.netflix.discovery.util.StringUtil;
import com.xuyang.springboot.mongo.service.MongoDBService;
import com.xuyang.springboot.mongo.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: cypc
 * @Date: 2019/9/19 19:14
 * @Description:
 */
@Slf4j
@Component
@RestController
public class BaseController{

    @ModelAttribute
    public void init(Model model, HttpServletRequest req) throws Exception {
        log.debug("前置处理");
    }

    public String getErrorResult(){
        log.debug("Hystrix异常服务");
        return "请求失败";
    }

    /**
     * Description: 属性映射<br>
     * @author houz
     * @param object
     */
    public Map<String, Object> modelAttribute(Object object) {
        Map<String, Object> objectMap = new HashMap(16);

        Field[] fields = ObjectUtil.getMethodField(object.getClass());
        for (Field field : fields) {
            String name = field.getName();
            Object value = ObjectUtil.invokeGetMethod(object, name);
            if (value != null) {
                objectMap.put(name, value);
            }
        }
        return objectMap;
    }
}
