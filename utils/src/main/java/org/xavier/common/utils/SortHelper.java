package org.xavier.common.utils;

import java.util.List;
import java.util.stream.BaseStream;

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
     * @param target     待排序的目标对象
     * @param startPoint 起始点序号(包括)
     * @param endPoint   结束点序号(不包括)
     * @param isDESC     是否倒序(从大到小)
     */
    <T extends BaseSortItem> void selectSort(List<T> target, int startPoint, int endPoint, Boolean isDESC);


    /**
     * 插入排序
     *
     * @param target     待排序的目标对象
     * @param startPoint 起始点序号(包括)
     * @param endPoint   结束点序号(不包括)
     * @param isDESC     是否倒序(从大到小)
     */
    <T extends BaseSortItem> void insertionSort(List<T> target, int startPoint, int endPoint, Boolean isDESC);

    /**
     * 归并排序
     *
     * @param target     待排序的目标对象
     * @param startPoint 起始点序号(包括)
     * @param endPoint   结束点序号(不包括)
     * @param isDESC     是否倒序(从大到小)
     */
    <T extends BaseSortItem> void mergeSort(List<T> target, int startPoint, int endPoint, Boolean isDESC);


    /**
     * 快速排序
     *
     * @param target     待排序的目标对象
     * @param startPoint 起始点序号(包括)
     * @param endPoint   结束点序号(不包括)
     * @param isDESC     是否倒序(从大到小)
     */
    <T extends BaseSortItem> void quickSort_3Ways(List<T> target, int startPoint, int endPoint, Boolean isDESC);


    /**
     * Top K 算法
     *
     * @param target     待排序的目标对象
     * @param startPoint 起始点序号(包括)
     * @param endPoint   结束点序号(不包括)
     * @param k          前 k 大(小)
     * @param isDESC     是否倒序(从大到小)
     */
    <T extends BaseSortItem> void topK(List<T> target, int startPoint, int endPoint, int k, Boolean isDESC);
}