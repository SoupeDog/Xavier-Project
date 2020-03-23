package org.xavier.common.util;


import org.xavier.common.util.bo.ColumnInfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述信息：<br/>
 * SQL 工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.12.22
 * @since Jdk 1.8
 */
public interface SqlHelper {

    /**
     * 根据属性 map 集合筛选出特定属性，并生成最终更新用的 map
     *
     * @param target              待筛选的属性
     * @param checkInfoCollection 筛选条件信息
     * @return 生成数据库记录更新用的 map
     */
    HashMap<String, Object> createFinalUpdateData(Map<?, ?> target, Collection<ColumnInfo> checkInfoCollection);

    /**
     * 根据属性 map 集合筛选出特定属性，并生成最终更新用的 map
     *
     * @param updateTs            更新时间戳
     * @param target              待筛选的属性
     * @param checkInfoCollection 筛选条件信息
     * @return 生成数据库记录更新用的 map
     */
    HashMap<String, Object> createFinalUpdateDataWithDefaultTsColumn(Long updateTs, Map<?, ?> target, Collection<ColumnInfo> checkInfoCollection);
}