package org.xavier.common.util.impl;

import org.xavier.common.exception.PropertiesRuntimeException;
import org.xavier.common.util.TimeHelper;
import org.xavier.common.util.exception.UtilRuntimeException;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 描述信息：<br/>
 * 默认的时间工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/8/18
 * @since Jdk 9
 */
public class DefaultTimeHelper implements TimeHelper {
    protected static DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMdd.pattern);
    protected static DateTimeFormatter yyyyMMdd_HH_mm_ss = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMdd_HH_mm_ss.pattern);
    protected static DateTimeFormatter yyyy_MM_dd_HH_mm_ss = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyy_MM_dd_HH_mm_ss.pattern);
    protected static DateTimeFormatter yyyyMMddHHmmssSSS = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMddHHmmssSSS.pattern);
    /**
     * 系统运行的本地时区
     */
    protected ZoneOffset localZoneOffset;
    /**
     * 系统运行的本地时区
     */
    protected ZoneId localZoneId;

    public DefaultTimeHelper() {
        localZoneOffset = ZoneOffset.of("+8");
        localZoneId = ZoneId.of("+8");
    }

    public DefaultTimeHelper(ZoneOffset localZoneOffset, ZoneId localZoneId) {
        this.localZoneOffset = localZoneOffset;
        this.localZoneId = localZoneId;
    }

    @Override
    public long parse(String target, TimeFormatEnum timeFormatEnum) {
        return parse(target, timeFormatEnum, localZoneOffset);
    }

    @Override
    public long parse(String target, TimeFormatEnum timeFormatEnum, ZoneOffset targetZoneOffset) {
        if (timeFormatEnum == null) {
            throw new UtilRuntimeException("[timeFormatEnum] can't be null.");
        }
        if (target == null) {
            throw new PropertiesRuntimeException("[target] can't be null.");
        }
        LocalDateTime targetLocalTime;
        try {
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
                    // Warning 此处 jdk 8 存在 bug， jdk 9 以后才能正确运行
                    targetLocalTime = LocalDateTime.parse(target, yyyyMMddHHmmssSSS);
                    break;
                default:
                    throw new UtilRuntimeException("Unexpected [TimeFormatEnum].");
            }
        } catch (DateTimeParseException exception) {
            throw new PropertiesRuntimeException("Unexpected [target]:" + target, exception);
        }
        return targetLocalTime.toInstant(targetZoneOffset).toEpochMilli();
    }

    @Override
    public String format(Long target, TimeFormatEnum timeFormatEnum) {
        return format(target, timeFormatEnum, localZoneId);
    }

    @Override
    public String format(Long target, TimeFormatEnum timeFormatEnum, ZoneId targetZoneId) {
        if (timeFormatEnum == null) {
            throw new UtilRuntimeException("[timeFormatEnum] can't be null.");
        }
        if (target == null) {
            throw new PropertiesRuntimeException("[target] can't be null.");
        }
        try {
            LocalDateTime targetTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(target), targetZoneId);
            switch (timeFormatEnum) {
                case yyyyMMdd:
                    return targetTime.format(yyyyMMdd);
                case yyyyMMdd_HH_mm_ss:
                    return targetTime.format(yyyyMMdd_HH_mm_ss);
                case yyyy_MM_dd_HH_mm_ss:
                    return targetTime.format(yyyy_MM_dd_HH_mm_ss);
                case yyyyMMddHHmmssSSS:
                    return targetTime.format(yyyyMMddHHmmssSSS);
                default:
                    throw new UtilRuntimeException("Unexpected [TimeFormatEnum].");
            }
        } catch (DateTimeException exception) {
            throw new PropertiesRuntimeException("Unexpected [target]:" + target);
        }
    }

    public ZoneOffset getLocalZoneOffset() {
        return localZoneOffset;
    }

    public void setLocalZoneOffset(ZoneOffset localZoneOffset) {
        this.localZoneOffset = localZoneOffset;
    }

    public ZoneId getLocalZoneId() {
        return localZoneId;
    }

    public void setLocalZoneId(ZoneId localZoneId) {
        this.localZoneId = localZoneId;
    }
}