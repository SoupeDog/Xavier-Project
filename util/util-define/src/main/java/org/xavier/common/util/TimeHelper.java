package org.xavier.common.util;

import org.xavier.common.util.enums.TimeFormatEnum;
import org.xavier.common.util.exception.UtilRuntimeException;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 描述信息：<br/>
 * 默认的时间工具类接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/8/18
 * @since Jdk 8
 */
public interface TimeHelper {
    DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMdd.pattern);
    DateTimeFormatter yyyyMMdd_HH_mm_ss = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMdd_HH_mm_ss.pattern);
    DateTimeFormatter yyyy_MM_dd_HH_mm_ss = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyy_MM_dd_HH_mm_ss.pattern);
    DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMddHHmmss.pattern);
    DateTimeFormatter yyyyMMddHHmmssSSS = DateTimeFormatter.ofPattern(TimeFormatEnum.yyyyMMddHHmmssSSS.pattern);

    String DEFAULT_PATH = "org.xavier.common.util.impl.DefaultTimeHelper";

    /**
     * 返回一个默认工具（这个方法会影响到 org.xavier.common.util.UtilsCreator 的静态实例）
     *
     * @return 默认工具
     */
    static TimeHelper createHelper() {
        try {
            Class defaultClass = Thread.currentThread().getContextClassLoader().loadClass(DEFAULT_PATH);
            Object resultTemp = defaultClass.newInstance();
            if (!(resultTemp instanceof CollectionHelper)) {
                throw new UtilRuntimeException(String.format("Class(%s) should implement TimeHelper.", DEFAULT_PATH));
            }
            return (TimeHelper) resultTemp;
        } catch (ClassNotFoundException e) {
            throw new UtilRuntimeException(String.format("Class(%s) was not found.", DEFAULT_PATH));
        } catch (IllegalAccessException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        } catch (InstantiationException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        }
    }

    /**
     * 字符串转化为 long 型毫秒级时间戳
     *
     * @param target         需要格式化的时间戳字符串
     * @param timeFormatEnum 格式化目标枚举
     * @return 秒级时间戳
     */
    long parse(String target, TimeFormatEnum timeFormatEnum);

    /**
     * 字符串转化为 long 型毫秒级时间戳
     *
     * @param target           需要格式化的时间戳字符串
     * @param timeFormatEnum   格式化目标枚举
     * @param targetZoneOffset 格式化目标对应时区
     * @return 秒级时间戳
     */
    long parse(String target, TimeFormatEnum timeFormatEnum, ZoneOffset targetZoneOffset);


    /**
     * long 型毫秒级时间戳 转字符串形式
     *
     * @param target         需要格式化的时间戳
     * @param timeFormatEnum 目标字符串格式类型
     * @return 格式化后的字符串
     */
    String format(Long target, TimeFormatEnum timeFormatEnum);

    /**
     * long 型毫秒级时间戳 转字符串形式
     *
     * @param target         需要格式化的时间戳
     * @param timeFormatEnum 目标字符串格式类型
     * @param targetZoneId   目标字符串对应时区
     * @return 格式化后的字符串
     */
    String format(Long target, TimeFormatEnum timeFormatEnum, ZoneId targetZoneId);
}