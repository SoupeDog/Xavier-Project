package org.xavier.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;

/**
 * 描述信息：<br/>
 * 集合工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.12.22
 * @since Jdk 1.8
 */
public interface CollectionHelper {

    /**
     * 过滤 Collection ,将目标 Collection 非空且字符串值不为 "" 的元素组成新的 ArrayList
     *
     * @param isUnique 返回结果元素是否要求唯一
     * @param target   待过滤的 Collection
     * @param msg      错误提示信息
     * @param tClass   待过滤的 Collection 元素类型
     * @param rClass   待过滤的 Collection 元素的目标属性类型
     * @param function 提取 Collection 元素属性的函数
     * @param <T>      Collection 元素类型
     * @param <R>      Collection 元素的目标属性类型
     * @return Collection 非空且字符串值不为 "" 的元素组成新的 ArrayList
     */
    <T, R> ArrayList<R> filterCollectionNotEmptyAsArrayList(Boolean isUnique, Collection<T> target, String msg, Class<T> tClass, Class<R> rClass, Function<T, R> function);

    /**
     * 过滤 Collection ,将目标 Collection 非空且字符串值不为 "" 的元素组成新的 HashMap
     *
     * @param target    待过滤的 Collection
     * @param msg       错误提示信息
     * @param tClass    待过滤的 Collection 元素类型
     * @param kClass    HashMap 的 Key 类型
     * @param vClass    HashMap 的 Value 类型
     * @param kFunction 提取 HashMap Key 函数
     * @param vFunction 提取 HashMap Value 函数
     * @param <T>       Collection 元素类型
     * @param <K>       HashMap 的 key 类型
     * @param <V>       HashMap 的 value 类型
     * @return Collection 非空且字符串值不为 "" 的元素组成新的 HashMap
     */
    <T, K, V> HashMap<K, V> filterCollectionNotEmptyAsHashMap(Collection<T> target, String msg, Class<T> tClass, Class<K> kClass, Class<V> vClass, Function<T, K> kFunction, Function<T, V> vFunction);
}