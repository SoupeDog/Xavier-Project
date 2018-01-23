package org.xavier.common.utils;

import org.xavier.common.utils.bo.ColumnInfo;
import org.xavier.common.utils.enums.ColumnType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述信息：<br/>
 * SQL 语句工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.20
 * @since Jdk 1.8
 */
public interface SQLHelper {
    /**
     * 将 Object []  转化为 SQL 中 IN 关键字的范围
     *
     * @param targetType  数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param targetArray 目标数组
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    String arrayToSQLRange(ColumnType targetType, Object[] targetArray);


    /**
     * @param targetType  数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param minLength   目标字段最小长度
     * @param maxLength   目标字段最大长度
     * @param targetArray 目标数组
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    String arrayToSQLRange(ColumnType targetType, Number minLength, Number maxLength, Object[] targetArray);

    /**
     * 将 V []  转化为 SQL 中 IN 关键字的范围
     *
     * @param targetType  数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param targetArray 目标数组
     * @param methodName  获取目标字段的 方法名
     * @param valueClass  数组对象类型
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    <V> String arrayToSQLRange(ColumnType targetType, V[] targetArray, String methodName, Class<V> valueClass);

    /**
     * 将 V []  转化为 SQL 中 IN 关键字的范围
     *
     * @param targetType  数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param minLength   目标字段最小长度
     * @param maxLength   目标字段最大长度
     * @param targetArray 目标数组
     * @param methodName  获取目标字段的 方法名
     * @param valueClass  数组对象类型
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    <V> String arrayToSQLRange(ColumnType targetType, Number minLength, Number maxLength, V[] targetArray, String methodName, Class<V> valueClass);

    /**
     * 将 List &lt;String&gt;  转化为 SQL 中 IN 关键字的范围
     *
     * @param targetType 数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param targetList 目标集合
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    String listToSQLRange(ColumnType targetType, List targetList);

    /**
     * 将 List &lt;String&gt;  转化为 SQL 中 IN 关键字的范围
     *
     * @param targetType 数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param minLength  目标字段最小长度
     * @param maxLength  目标字段最大长度
     * @param targetList 目标集合
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    String listToSQLRange(ColumnType targetType, Number minLength, Number maxLength, List targetList);

    /**
     * 将 List &lt;V&gt;  转化为 SQL 中 IN 关键字的范围
     *
     * @param targetType 数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param targetList 目标集合
     * @param methodName 获取目标字段的 方法名
     * @param valueClass 集合对象类型
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    <V> String listToSQLRange(ColumnType targetType, List<V> targetList, String itemName, String methodName, Class<V> valueClass);

    /**
     * 将 List &lt;V&gt;  转化为 SQL 中 IN 关键字的范围
     *
     * @param targetType 数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param minLength  目标字段最小长度
     * @param maxLength  目标字段最大长度
     * @param targetList 目标集合
     * @param methodName 获取目标字段的 方法名
     * @param valueClass 集合对象类型
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    <V> String listToSQLRange(ColumnType targetType, Number minLength, Number maxLength, List<V> targetList, String itemName, String methodName, Class<V> valueClass);

    /**
     * 将 Map &lt;K,V&gt;  转化为 SQL 中 IN 关键字的范围
     *
     * @param targetType 数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param targetMap  目标 Map
     * @param methodName 获取目标字段的 方法名
     * @param valueClass Map 的 Value 类型
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    <K, V> String mapToSQLRange(ColumnType targetType, Map<K, V> targetMap, String methodName, Class<V> valueClass);

    /**
     * 将 Map &lt;K,V&gt;  转化为 SQL 中 IN 关键字的范围
     *
     * @param targetType 数据库字段记录类型(ColumnType.Number 枚举禁止使用)
     * @param minLength  目标字段最小长度
     * @param maxLength  目标字段最大长度
     * @param targetMap  目标 Map
     * @param methodName 获取目标字段的 方法名
     * @param valueClass Map 的 Value 类型
     * @return (var1, var2) 或 ('var1','var2') 形式 的字符串
     */
    <K, V> String mapToSQLRange(ColumnType targetType, Number minLength, Number maxLength, Map<K, V> targetMap, String methodName, Class<V> valueClass);

    /**
     * 从原数据中筛选特定数据,并以 Map 形式返回
     *
     * @param raw_Data    Map 类型的待筛选数据
     * @param checkColumn 筛选规则信息
     * @return Map 形式的过筛信息
     */
    HashMap<String, Object> createFinalUpdateData(Map raw_Data, List<ColumnInfo> checkColumn);

    /**
     * 从原数据中筛选特定数据,并以 Map 形式返回
     *
     * @param raw_Data    Map 类型的待筛选数据
     * @param checkColumn 筛选规则信息
     * @param tsColumns   附加时间戳的字段名
     * @return Map 形式的过筛信息
     */
    HashMap<String, Object> createFinalUpdateDataWithTimeStamp(Map raw_Data, List<ColumnInfo> checkColumn, String... tsColumns);

}
