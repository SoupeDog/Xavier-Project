package org.xavier.common.utils;


import org.xavier.common.utils.enums.ColumnType;

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
     * 序列化基本数据类型或其包装类 List 对象
     *
     * @param format   是否打印 [ ]
     * @param itemType   ListItem 数据类型
     * @param targetList 目标 List
     * @return List 的序列化对象
     */
    String serializeList(Boolean format, ColumnType itemType, List targetList);

    /**
     * 序列化特定 Item 字段
     *
     * @param format   是否打印 [ ]
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
}
