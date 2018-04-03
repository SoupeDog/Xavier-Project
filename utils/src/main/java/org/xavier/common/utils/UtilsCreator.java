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
    private static volatile PropertiesHelper propertiesHelper = null;
    private static volatile SQLHelper sqlHelper = null;
    private static volatile ListHelper listHelper = null;
    private static volatile JsonHelper jsonHelper = null;
    private static volatile RandomHelper randomHelper = null;
    private static volatile MapHelper mapHelper = null;
    private static volatile TimeHelper timeHelper = null;


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
        if (propertiesHelper == null) {
            synchronized (DefaultPropertiesHelper.class) {
                if (propertiesHelper == null) {
                    propertiesHelper = new DefaultPropertiesHelper();
                }
            }
        }
        return propertiesHelper;
    }

    /**
     * 返回一个 DefaultSQLHelper 实例(单例)
     */
    public static SQLHelper getInstance_DefaultSQLHelper() {
        if (sqlHelper == null) {
            synchronized (DefaultSQLHelper.class) {
                if (sqlHelper == null) {
                    sqlHelper = new DefaultSQLHelper();
                }
            }
        }
        return sqlHelper;
    }

    /**
     * 返回一个 DefaultListHelper 实例(单例)
     */
    public static ListHelper getInstance_DefaultListHelper() {
        if (listHelper == null) {
            synchronized (DefaultListHelper.class) {
                if (listHelper == null) {
                    listHelper = new DefaultListHelper();
                }
            }
        }
        return listHelper;
    }

    /**
     * 返回一个 DefaultJsonHelper 实例(单例)
     */
    public static JsonHelper getInstance_DefaultJsonHelper() {
        if (jsonHelper == null) {
            synchronized (DefaultJsonHelper.class) {
                if (jsonHelper == null) {
                    jsonHelper = new DefaultJsonHelper();
                }
            }
        }
        return jsonHelper;
    }

    /**
     * 返回一个 DefaultRandomHelper 实例(单例)<br/>
     * PS: 字母 O 会被替换成 X ,数字 0 会被替换成 2
     */
    public static RandomHelper getInstance_DefaultRandomHelper() {
        if (randomHelper == null) {
            synchronized (DefaultRandomHelper.class) {
                if (randomHelper == null) {
                    randomHelper = new DefaultRandomHelper();
                }
            }
        }
        return randomHelper;
    }

    /**
     * 返回一个 DefaultMapHelper 实例(单例)<br/>
     */
    public static MapHelper getInstance_DefaultMapHelper() {
        if (mapHelper == null) {
            synchronized (DefaultMapHelper.class) {
                if (mapHelper == null) {
                    mapHelper = new DefaultMapHelper();
                }
            }
        }
        return mapHelper;
    }

    /**
     * 返回一个 DefaultTimeHelper 实例(单例)<br/>
     */
    public static TimeHelper getInstance_DefaultTimeHelper() {
        if (timeHelper == null) {
            synchronized (DefaultTimeHelper.class) {
                if (timeHelper == null) {
                    timeHelper = new DefaultTimeHelper();
                }
            }
        }
        return timeHelper;
    }
}