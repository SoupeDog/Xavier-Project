package org.xavier.common.utils;


import org.xavier.common.enums.ColumnType;
import org.xavier.common.utils.bo.BaseSortItem;
import org.xavier.common.utils.bo.SortedTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述信息：<br/>
 * List
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.22
 * @since Jdk 1.8
 */
public interface ListHelper {

    /**
     * 校验 目标 list 不可为空 且 size 不小于 1
     *
     * @param list              待校验 List
     * @param targetDescription 待校验描述信息
     */
    @Deprecated
    void listNotEmpty(List list, String targetDescription);

    /**
     * 快捷创建一个只有一个元素的 ArrayList
     */
    <T> ArrayList<T> createSingleList(T target);

    /**
     * 序列化基本数据类型或其包装类 List 对象
     *
     * @param format     是否打印 [ ]
     * @param itemType   ListItem 数据类型
     * @param targetList 目标 List
     * @return List 的序列化对象
     */
    String serializeList(Boolean format, ColumnType itemType, List targetList);

    /**
     * 序列化特定 Item 字段
     *
     * @param format     是否打印 [ ]
     * @param itemType   ListItem 数据类型
     * @param targetList 目标 List
     * @param methodName 对象获取方法名
     * @return List 的序列化对象
     */
    <T> String serializeList(Boolean format, ColumnType itemType, List<T> targetList, String methodName, Class<T> tClass);

    /**
     * @param targetList 需要分组的 List ，前提是 ListItem 存在某字段有序排列(例如 sql  order by XXX 查询结果集)
     * @param methodName 分组依据属性的 get方法名称
     * @param tClass     分组项的类型
     * @return 分组拆分 index 信息
     */
    <T> ArrayList<Integer> getListGroupIndex(List<T> targetList, String methodName, Class<T> tClass);

    /**
     * @param indexInfo  分组拆分 index 信息
     * @param targetList 拆分 LIst 对象
     * @return 分组拆分结果
     */
    <T> ArrayList<List<T>> groupListByGroupIndex(List<Integer> indexInfo, ArrayList<T> targetList);

    /**
     * 过滤传入数组数据，要求传入数组不为空，item 不为空串 ，过滤完成后返回的 List size>0
     *
     * @param targetList 需要过滤的 List 目标
     * @param name       需要过滤的 List 目标的对外称呼，抛出异常时用 (传入样例 deviceIdList)
     * @return 过滤后的 List
     */
    ArrayList<String> filterStringListNotEmpty(List<String> targetList, String name, Integer minLength, Integer maxLength);

    /**
     * 检查当前数组排序类型
     *
     * @param targetList 检查目标(请提前自行非空等校验，且要求至少 2 个元素)
     * @return 排序类型枚举
     */
    SortedTypeEnum checkSorttedType(List<BaseSortItem> targetList);
}