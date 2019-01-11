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
     * 从目标集合中获排序依据值第 K 大元素的 index，该操作会影响 target 内部顺序。<br/>
     * 若 index 对应元素的排序依据值为 x<br/>
     * 索引值小于 index 的元素，排序依据值均大于或等于 x,但无序<br/>
     * 索引值大于 index 的元素，排序依据值均小于或等于 x,但无序<br/>
     *
     * @param target 待排序的集合
     * @param k      指定寻找第 k 大的元素索引
     * @return 第 k 大的索引值
     */
    int getIndexOfTopK(List<BaseSortItem> target, Integer k);

    /**
     * 快速排序
     *
     * @param target 待排序的目标对象
     * @param isDESC 是否倒序(从大到小)
     */
    void quickSort(List<BaseSortItem> target, Boolean isDESC);
}