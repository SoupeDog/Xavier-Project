package org.xavier.common.util;


import com.fasterxml.jackson.databind.ObjectMapper;
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
    /**
     * 格式化对象或者字符串
     *
     * @param target 待格式化为 json 的目标
     * @return json 格式化的字符串
     */
    String format(Object target);

    /**
     * 将目标当做 json 解析，并获取特定 key 对应的 value(遇到收个符合条件的 key 即会返回)
     *
     * @param jsonType   对象类型
     * @param targetObj  待解析对象
     * @param key        key
     * @param resultType 返回结果类型
     * @param tClass     返回结果类
     */
    <T> T getFirstValueByKey(ColumnType jsonType, Object targetObj, String key, ColumnType resultType, Class<T> tClass);

    /**
     * 将目标当做 json 解析，并获取特定 key 对应的 value(根据序号从所有 key 条件的集合中返回最终结果)
     *
     * @param jsonType   对象类型
     * @param targetObj  待解析对象
     * @param key        key
     * @param index      序号(从最外层向里匹配，首个匹配结果序号为 1 )
     * @param resultType 返回结果类型
     * @param tClass     返回结果类
     */
    <T> T getValueByKey_Index(ColumnType jsonType, Object targetObj, String key, Integer index, ColumnType resultType, Class<T> tClass);

    /**
     * 返回当前 ObjectMapper
     */
     ObjectMapper getMapper();
}