package org.xavier.common.utils;

import java.util.List;

import org.xavier.common.utils.bo.BaseSortItem;

/**
 * 描述信息：<br/>
 * 排序工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.11.30
 * @since Jdk 1.8
 */
public interface SortHelper {
    /**
     * 选择排序
     *
     * @param target 待排序的目标对象
     * @param isDESC 是否倒序(从大到小)
     */
    void selectSort(List<BaseSortItem> target, Boolean isDESC);
}