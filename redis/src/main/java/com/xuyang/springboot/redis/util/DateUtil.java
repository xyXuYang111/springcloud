package com.xuyang.springboot.redis.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Auther: cypc
 * @Date: 2019/9/30 16:04
 * @Description:
 */
public class DateUtil {

    public static String getCurrentDateYYYYMMDD() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }
}
