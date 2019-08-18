package org.xavier.common.util.impl;

import org.xavier.common.util.TimeHelper;
import org.xavier.common.util.exception.UtilRuntimeException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 描述信息：<br/>
 * 默认的时间工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/8/18
 * @since Jdk 1.8
 */
public class DefaultTimeHelper implements TimeHelper {
    protected static DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMdd.pattern);
    protected static DateTimeFormatter yyyyMMdd_HH_mm_ss = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMdd_HH_mm_ss.pattern);
    protected static DateTimeFormatter yyyy_MM_dd_HH_mm_ss = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyy_MM_dd_HH_mm_ss.pattern);
    protected static DateTimeFormatter yyyyMMddHHmmssSSS = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMddHHmmssSSS.pattern);
    /**
     * 系统运行的本地时区
     */
    protected static ZoneOffset localZoneOffset;
    protected static ZoneId localZoneId;

    public DefaultTimeHelper() {
        localZoneOffset = ZoneOffset.of("+8");
        localZoneId = ZoneId.of("+8");
    }

    @Override
    public long parse(String target, TimeFormatEnum timeFormatEnum) {
        LocalDateTime targetLocalTime;
        switch (timeFormatEnum) {
            case yyyyMMdd:
                targetLocalTime = LocalDateTime.parse(target, yyyyMMdd);
                break;
            case yyyyMMdd_HH_mm_ss:
                targetLocalTime = LocalDateTime.parse(target, yyyyMMdd_HH_mm_ss);
                break;
            case yyyy_MM_dd_HH_mm_ss:
                targetLocalTime = LocalDateTime.parse(target, yyyy_MM_dd_HH_mm_ss);
                break;
            case yyyyMMddHHmmssSSS:
                targetLocalTime = LocalDateTime.parse(target, yyyyMMddHHmmssSSS);
                break;
            default:
                throw new UtilRuntimeException("");
        }
        return targetLocalTime.toInstant(localZoneOffset).toEpochMilli();
    }

    @Override
    public String format(Long target, TimeFormatEnum timeFormatEnum) {
        LocalDateTime targetTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(target), localZoneId);
        switch (timeFormatEnum) {
            case yyyyMMdd_HH_mm_ss:
                return targetTime.format(yyyyMMdd_HH_mm_ss);
            default:
                throw new UtilRuntimeException("");
        }
    }

    public static void main(String[] args) {
        TimeHelper timeHelper = new DefaultTimeHelper();
        long startTs = System.currentTimeMillis();
        Long ts = timeHelper.parse("20190818 19:05:00", TimeFormatEnum.yyyyMMdd_HH_mm_ss);
        System.out.println(System.currentTimeMillis() - startTs);
        System.out.println(ts);
        startTs = System.currentTimeMillis();
        System.out.println(timeHelper.format(ts, TimeFormatEnum.yyyyMMdd_HH_mm_ss));
        System.out.println(System.currentTimeMillis() - startTs);
    }
}