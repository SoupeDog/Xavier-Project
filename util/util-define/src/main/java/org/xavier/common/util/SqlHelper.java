package org.xavier.common.util;


import org.xavier.common.util.bo.ColumnInfo;
import org.xavier.common.util.exception.UtilRuntimeException;

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
    String DEFAULT_PATH = "org.xavier.common.util.impl.DefaultSqlHelper";

    /**
     * 返回一个默认工具（这个方法会影响到 org.xavier.common.util.UtilsCreator 的静态实例）
     *
     * @return 默认工具
     */
    static SqlHelper createHelper() {
        try {
            Class defaultClass = ClassLoader.getSystemClassLoader().loadClass(DEFAULT_PATH);
            Object resultTemp = defaultClass.newInstance();
            if (!(resultTemp instanceof SqlHelper)) {
                throw new UtilRuntimeException(String.format("Class(%s) should implement SqlHelper.", DEFAULT_PATH));
            }
            return (SqlHelper) resultTemp;
        } catch (ClassNotFoundException e) {
            throw new UtilRuntimeException(String.format("Class(%s) was not found.", DEFAULT_PATH));
        } catch (IllegalAccessException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        } catch (InstantiationException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        }
    }

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