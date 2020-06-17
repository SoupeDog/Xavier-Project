package org.xavier.common.util;

import org.xavier.common.util.exception.UtilRuntimeException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
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
    String DEFAULT_PATH = "org.xavier.common.util.impl.DefaultCollectionHelper";

    /**
     * 返回一个默认工具（这个方法会影响到 org.xavier.common.util.UtilsCreator 的静态实例）
     *
     * @return 默认工具
     */
    static CollectionHelper createHelper() {
        try {
            Class defaultClass = CollectionHelper.class.getClassLoader().loadClass(DEFAULT_PATH);
            Object resultTemp = defaultClass.newInstance();
            if (!(resultTemp instanceof CollectionHelper)) {
                throw new UtilRuntimeException(String.format("Class(%s) should implement CollectionHelper.", DEFAULT_PATH));
            }
            return (CollectionHelper) resultTemp;
        } catch (ClassNotFoundException e) {
            throw new UtilRuntimeException(String.format("Class(%s) was not found.", DEFAULT_PATH));
        } catch (IllegalAccessException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        } catch (InstantiationException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        }
    }

    /**
     * 过滤 Collection ,将目标 Collection 非空且字符串值不为 "" 的元素组成新的 ArrayList
     *
     * @param isUnique 返回结果元素是否要求唯一
     * @param target   待过滤的 Collection
     * @param msg      错误提示信息
     * @param function 提取 Collection 元素属性的函数
     * @param <T>      Collection 元素类型
     * @param <R>      Collection 元素的目标属性类型
     * @return Collection 非空且字符串值不为 "" 的元素组成的新 ArrayList
     */
    <T, R> ArrayList<R> filterCollectionNotEmptyAsArrayList(Boolean isUnique, Collection<T> target, String msg, Function<T, R> function);

    /**
     * 过滤 Collection ,将目标 Collection 的非空元素组成新的 HashMap
     *
     * @param target    待过滤的 Collection
     * @param msg       错误提示信息
     * @param kFunction 提取 HashMap Key 函数
     * @param vFunction 提取 HashMap Value 函数
     * @param <T>       Collection 元素类型
     * @param <K>       HashMap 的 key 类型
     * @param <V>       HashMap 的 value 类型
     * @return Collection 的非空元素组成新的 HashMap
     */
    <T, K, V> HashMap<K, V> filterCollectionNotEmptyAsHashMap(Collection<T> target, String msg, Function<T, K> kFunction, Function<T, V> vFunction);

    /**
     * 过滤 Collection ,将目标 Collection 的非空 且 key 不为空元素组成的新 TreeMap
     *
     * @param target    待过滤的 Collection
     * @param msg       错误提示信息
     * @param kFunction 提取 TreeMap Key 函数
     * @param vFunction 提取 TreeMap Value 函数
     * @param <T>       Collection 元素类型
     * @param <K>       TreeMap 的 key 类型
     * @param <V>       TreeMap 的 value 类型
     * @return Collection 的非空 且 key 不为空元素组成的新 TreeMap
     */
    <T, K, V> TreeMap<K, V> filterCollectionNotEmptyAsTreeMap(Collection<T> target, String msg, Function<T, K> kFunction, Function<T, V> vFunction);

    /**
     * 过滤 Collection ,将目标 Collection 的非空 且 key/value 均不为空元素组成的新 ConcurrentHashMap
     *
     * @param target    待过滤的 Collection
     * @param msg       错误提示信息
     * @param kFunction 提取 ConcurrentHashMap Key 函数
     * @param vFunction 提取 ConcurrentHashMap Value 函数
     * @param <T>       Collection 元素类型
     * @param <K>       ConcurrentHashMap 的 key 类型
     * @param <V>       ConcurrentHashMap 的 value 类型
     * @return Collection 的非空 且 key/value 均不为空元素组成的新 ConcurrentHashMap
     */
    <T, K, V> ConcurrentHashMap<K, V> filterCollectionNotEmptyAsConcurrentHashMap(Collection<T> target, String msg, Function<T, K> kFunction, Function<T, V> vFunction);
}