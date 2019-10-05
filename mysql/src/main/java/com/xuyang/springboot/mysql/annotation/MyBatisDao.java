package com.xuyang.springboot.mysql.annotation;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:24
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
@Mapper
public @interface MyBatisDao {
}
