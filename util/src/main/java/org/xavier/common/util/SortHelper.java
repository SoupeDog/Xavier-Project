package org.xavier.common.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/**
 * 描述信息：<br/>
 * 排序工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2020.03.23
 * @since Jdk 1.8
 */
public interface SortHelper {

    /**
     * 分析目标的排序规律
     *
     * @param collection 分析目标
     * @param comparator 比较器
     * @return 排序规律类型
     */
    <T> SortOrder analysisSortOrder(Collection<T> collection, Comparator<T> comparator);

    /**
     * 分析目标的排序规律
     *
     * @param map        分析目标
     * @param comparator 比较器
     * @param checkCount 检测次数。多次检测以减少巧合导致的分析错误概率 (不小于 1)
     * @return 排序规律类型
     */
    <T> SortOrder analysisSortOrder(Map<?, T> map, Comparator<T> comparator, int checkCount);

    /**
     * 排序规律类型
     */
    enum SortOrder {
        /**
         * 不包含元素
         */
        EMPTY(0, "空容器"),
        /**
         * 排序无规律
         */
        DISORDER(100, "无序"),
        /**
         * 升序规律：满足下一个元素 >= 上一个元素
         */
        ASCENDING(200, "升序"),
        /**
         * 降序规律 满足下一个元素 <= 上一个元素
         */
        DESCENDING(300, "降序");

        /**
         * 序号
         */
        private final int index;
        /**
         * 描述
         */
        private final String description;

        SortOrder(int index, String description) {
            this.index = index;
            this.description = description;
        }
    }
}