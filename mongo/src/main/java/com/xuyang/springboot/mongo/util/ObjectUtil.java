package com.xuyang.springboot.mongo.util;

import com.netflix.discovery.util.StringUtil;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: cypc
 * @Date: 2019/9/21 18:02
 * @Description:
 */
public class ObjectUtil {

    public static final String SERIAL_VERSION_UID = "serialVersionUID";

    /**
     * Description: 获取对象以及父类的所有属性<br>
     * @author wanghao
     * @param clazz
     * @return
     */
    public static Field[] getMethodField(Class<?> clazz) {
        try {
            if (clazz == null) {
                return null;
            }

            List<Field> fieldList = new ArrayList();

            Field[] superFields = clazz.getSuperclass().getDeclaredFields();
            for (Field superField : superFields) {
                if (!SERIAL_VERSION_UID.equals(superField.getName())) {
                    fieldList.add(superField);
                }
            }

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (!SERIAL_VERSION_UID.equals(field.getName())) {
                    fieldList.add(field);
                }
            }

            return fieldList.toArray(new Field[fieldList.size()]);

        } catch (Exception e) {
            return null;
        }
    }

    public static Object invokeGetMethod(Object obj, String property) {
        try {
            if (obj instanceof Map) {
                return ((Map<?, ?>) obj).get(property);
            }
            Class<?> clazz = obj.getClass();
            PropertyDescriptor pd = new PropertyDescriptor(property, clazz);
            //获得get方法
            Method getMethod = pd.getReadMethod();
            if (pd != null) {
                //执行get方法返回一个Object
                return getMethod.invoke(obj);
            }
        } catch (Exception e) {
        }

        return null;
    }
}
