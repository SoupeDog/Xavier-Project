package org.xavier.common.utils;


import org.xavier.common.enums.ColumnType;

/**
 * 描述信息：<br/>
 * 基于 Jackson 的 Json 工具类接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.23
 * @since Jdk 1.8
 */
public interface JsonHelper {
    String format(Object target);

    <T> T getFirstValueByKey(ColumnType jsonType, Object targetObj, String key, ColumnType resultType, Class<T> tClass);

    <T> T getValueByKey_Index(ColumnType jsonType, Object targetObj, String key, Integer index, ColumnType resultType, Class<T> tClass);
}
