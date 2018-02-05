package org.xavier.common.utils;

import org.xavier.common.exception.Universal_500_X_Exception_Runtime;
import org.xavier.common.utils.base.*;
import org.xavier.common.utils.impl.*;

/**
 * 描述信息：<br/>
 * 工具类工厂
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.20
 * @since Jdk 1.8
 */
public class UtilsCreator {
    private static PropertiesHelper propertiesHelper = getPropertiesHelper(DefaultPropertiesHelper.class);
    private static SQLHelper sqlHelper = getSQLHelper(DefaultSQLHelper.class);
    private static ListHelper listHelper = getListHelper(DefaultListHelper.class);
    private static JsonHelper jsonHelper = getJsonHelper(DefaultJsonHelper.class);
    private static RandomHelper randomHelper = getRandomHelper(DefaultRandomHelper.class);
    private static MapHelper mapHelper = getMapHelper(DefaultMapHelper.class);


    private UtilsCreator() {
    }

    /**
     * 返回一个 PropertiesHelper 实例
     *
     * @param tClass PropertiesHelper 的一个实现类
     */
    public static PropertiesHelper getPropertiesHelper(Class tClass) {
        try {
            Object result = tClass.newInstance();
            if (!(result instanceof BasePropertiesHelper)) {
                throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BasePropertiesHelper.");
            }
            return (PropertiesHelper) result;
        } catch (InstantiationException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Fail to get PropertiesHelper.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend PropertiesHelper.", e);
        }
    }

    /**
     * 返回一个 SQLHelper 实例
     *
     * @param tClass SQLHelper 的一个实现类
     */
    public static SQLHelper getSQLHelper(Class tClass) {
        try {
            Object result = tClass.newInstance();
            if (!(result instanceof BaseSQLHelper)) {
                throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseSQLHelper.");
            }
            return (SQLHelper) result;
        } catch (InstantiationException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Fail to get BaseSQLHelper.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseSQLHelper.", e);
        }
    }

    /**
     * 返回一个 ListHelper 实例
     *
     * @param tClass ListHelper 的一个实现类
     */
    public static ListHelper getListHelper(Class tClass) {
        try {
            Object result = tClass.newInstance();
            if (!(result instanceof BaseListHelper)) {
                throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseListHelper.");
            }
            return (ListHelper) result;
        } catch (InstantiationException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Fail to get BaseListHelper.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseListHelper.", e);
        }
    }

    /**
     * 返回一个 JsonHelper 实例
     *
     * @param tClass JsonHelper 的一个实现类
     */
    public static JsonHelper getJsonHelper(Class tClass) {
        try {
            Object result = tClass.newInstance();
            if (!(result instanceof BaseJsonHelper)) {
                throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseJsonHelper.");
            }
            return (JsonHelper) result;
        } catch (InstantiationException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Fail to get BaseListHelper.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseJsonHelper.", e);
        }
    }

    /**
     * 返回一个 RandomHelper 实例
     *
     * @param tClass RandomHelper 的一个实现类
     */
    public static RandomHelper getRandomHelper(Class tClass) {
        try {
            Object result = tClass.newInstance();
            if (!(result instanceof BaseRandomHelper)) {
                throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseRandomHelper.");
            }
            return (RandomHelper) result;
        } catch (InstantiationException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Fail to get BaseListHelper.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseRandomHelper.", e);
        }
    }

    /**
     * 返回一个 MapHelper 实例
     *
     * @param tClass MapHelper 的一个实现类
     */
    public static MapHelper getMapHelper(Class tClass) {
        try {
            Object result = tClass.newInstance();
            if (!(result instanceof BaseMapHelper)) {
                throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseMapHelper.");
            }
            return (MapHelper) result;
        } catch (InstantiationException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Fail to get BaseListHelper.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "[tClass] should extend BaseMapHelper.", e);
        }
    }

    /**
     * 返回一个 DefaultPropertiesHelper 实例(单例)
     */
    public static PropertiesHelper getInstance_DefaultPropertiesHelper() {
        return propertiesHelper;
    }

    /**
     * 返回一个 DefaultSQLHelper 实例(单例)
     */
    public static SQLHelper getInstance_DefaultSQLHelper() {
        return sqlHelper;
    }

    /**
     * 返回一个 DefaultListHelper 实例(单例)
     */
    public static ListHelper getInstance_DefaultListHelper() {
        return listHelper;
    }

    /**
     * 返回一个 DefaultJsonHelper 实例(单例)
     */
    public static JsonHelper getInstance_DefaultJsonHelper() {
        return jsonHelper;
    }

    /**
     * 返回一个 DefaultRandomHelper 实例(单例)<br/>
     * PS: 字母 O 会被替换成 X ,数字 0 会被替换成 2
     */
    public static RandomHelper getInstance_DefaultRandomHelper() {
        return randomHelper;
    }

    /**
     * 返回一个 DefaultMapHelper 实例(单例)<br/>
     */
    public static MapHelper getInstance_DefaultMapHelper() {
        return mapHelper;
    }
}