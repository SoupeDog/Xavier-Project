package org.xavier.common.util;

import java.util.ArrayList;
import java.util.Collection;
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
     * @param target   待过滤的 Collection
     * @param msg      错误提示信息
     * @param function 提取 Collection 元素属性的函数
     * @param <T>      Collection 元素类型
     * @param <R>      Collection 元素属性类型
     * @return Collection 非空且字符串值不为 "" 的元素组成新的 ArrayList
     */
    <T, R> ArrayList<R> filterCollectionNotEmpty(Collection<T> target, String msg, Class<T> tClass, Class<R> rClass, Function<T, R> function);
}