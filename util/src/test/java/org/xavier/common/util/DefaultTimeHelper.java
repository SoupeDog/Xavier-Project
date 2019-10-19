package org.xavier.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 描述信息：<br/>
 * 基于 TimeHelper 的 时间工具主基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/4/2
 * @since Jdk 1.8
 */
public class DefaultTimeHelper {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeHelper.TimeFormatEnum.yyyy_MM_dd_HH_mm_ss.pattern);

    public long parse(String target, TimeHelper.TimeFormatEnum timeFormatEnum) throws ParseException {
        switch (timeFormatEnum) {
            case yyyy_MM_dd_HH_mm_ss:
                return simpleDateFormat.parse(target).getTime();
            default:
        }
        return 1L;
    }
}