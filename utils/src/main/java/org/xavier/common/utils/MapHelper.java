package org.xavier.common.utils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 描述信息：<br/>
 * Map 工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/1/4
 * @since Jdk 1.8
 */
public interface MapHelper {

    /**
     * 从目标 Map 中取出第一个元素(可能为空)
     *
     * @param targetMap 目标Map
     * @return 目标 Map 的第一个元素
     */
    <K, V> V getFirstItem(Map<K, V> targetMap, Class<K> keyClass, Class<V> valueClass);

    /**
     * 根据 Key 将目标 Map 转化为按比较器排序后的 TreeMap
     *
     * @param targetMap  目标 Map
     * @param comparator Key 的比较器
     * @return 按比较器排序后的 TreeMap
     */
    <K, V> TreeMap<K, V> sortMapByKey(Map<K, V> targetMap, Comparator<K> comparator, Class<K> keyClass, Class<V> valueClass);

    /**
     * 根据 Value 将目标 Map 转化为按比较器排序后的 LinkedHashMap
     *
     * @param targetMap  目标 Map
     * @param comparator Map.Entry 的比较器
     * @return 按比较器排序后的 LinkedHashMap
     */
    <K, V> LinkedHashMap<K, V> sortMapByValue(Map<K, V> targetMap, Comparator<Map.Entry<K, V>> comparator, Class<K> keyClass, Class<V> valueClass);

}
