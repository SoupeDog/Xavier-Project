package org.xavier.common.util;

import org.xavier.common.util.exception.UtilRuntimeException;

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
    private static volatile CollectionHelper collectionHelper = null;
    private static volatile RandomHelper randomHelper = null;
    private static volatile TimeHelper timeHelper = null;
    private static volatile SqlHelper sqlHelper = null;
    private static volatile JsonHelper<?> jsonHelper = null;
    private static volatile JsonHelper<?> jsonHelper_Indent = null;
    private static volatile EncryptHelper encryptHelper = null;


    private UtilsCreator() {
    }

    /**
     * 返回一个 DefaultPropertiesHelper 实例(单例)<br/>
     */
    public static PropertiesHelper getDefaultPropertiesHelperInstance() {
        if (propertiesHelper == null) {
            synchronized (SqlHelper.class) {
                if (propertiesHelper == null) {
                    propertiesHelper = PropertiesHelper.createHelper();
                }
            }
        }
        return propertiesHelper;
    }

    /**
     * 返回一个自定义 PropertiesHelper 实例
     *
     * @param tClass PropertiesHelper 的一个实现类
     */
    public static <T> T createCustomPropertiesHelper(Class<T> tClass) {
        T result = createInstanceByClass(tClass);
        if (!(result instanceof PropertiesHelper)) {
            throw new UtilRuntimeException(String.format("Class(%s) should implement PropertiesHelper.", tClass.getName()));
        }
        return result;
    }


    /**
     * 返回一个 DefaultCollectionHelper 实例(单例)<br/>
     */
    public static CollectionHelper getDefaultCollectionHelperInstance() {
        if (collectionHelper == null) {
            synchronized (SqlHelper.class) {
                if (collectionHelper == null) {
                    collectionHelper = CollectionHelper.createHelper();
                }
            }
        }
        return collectionHelper;
    }

    /**
     * 返回一个自定义 CollectionHelper 实例
     *
     * @param tClass CollectionHelper 的一个实现类
     */
    public static <T> T createCustomCollectionHelper(Class<T> tClass) {
        T result = createInstanceByClass(tClass);
        if (!(result instanceof CollectionHelper)) {
            throw new UtilRuntimeException(String.format("Class(%s) should implement CollectionHelper.", tClass.getName()));
        }
        return result;
    }


    /**
     * 返回一个 DefaultRandomHelper 实例(单例)<br/>
     */
    public static RandomHelper getDefaultRandomHelperInstance() {
        if (randomHelper == null) {
            synchronized (SqlHelper.class) {
                if (randomHelper == null) {
                    randomHelper = RandomHelper.createHelper();
                }
            }
        }
        return randomHelper;
    }

    /**
     * 返回一个自定义 RandomHelper 实例
     *
     * @param tClass RandomHelper 的一个实现类
     */
    public static <T> T createCustomRandomHelper(Class<T> tClass) {
        T result = createInstanceByClass(tClass);
        if (!(result instanceof RandomHelper)) {
            throw new UtilRuntimeException(String.format("Class(%s) should implement RandomHelper.", tClass.getName()));
        }
        return result;
    }

    /**
     * 返回一个 DefaultTimeHelper 实例(单例)<br/>
     */
    public static TimeHelper getDefaultTimeHelperInstance() {
        if (timeHelper == null) {
            synchronized (SqlHelper.class) {
                if (timeHelper == null) {
                    timeHelper = TimeHelper.createHelper();
                }
            }
        }
        return timeHelper;
    }

    /**
     * 返回一个自定义 TimeHelper 实例
     *
     * @param tClass TimeHelper 的一个实现类
     */
    public static <T> T createCustomTimeHelper(Class<T> tClass) {
        T result = createInstanceByClass(tClass);
        if (!(result instanceof TimeHelper)) {
            throw new UtilRuntimeException(String.format("Class(%s) should implement TimeHelper.", tClass.getName()));
        }
        return result;
    }

    /**
     * 返回一个 DefaultSqlHelper 实例(单例)<br/>
     */
    public static SqlHelper getDefaultSqlHelperInstance() {
        if (sqlHelper == null) {
            synchronized (SqlHelper.class) {
                if (sqlHelper == null) {
                    sqlHelper = SqlHelper.createHelper();
                }
            }
        }
        return sqlHelper;
    }

    /**
     * 返回一个自定义 SqlHelper 实例
     *
     * @param tClass SqlHelper 的一个实现类
     */
    public static <T> T createCustomSqlHelper(Class<T> tClass) {
        T result = createInstanceByClass(tClass);
        if (!(result instanceof SqlHelper)) {
            throw new UtilRuntimeException(String.format("Class(%s) should implement SqlHelper.", tClass.getName()));
        }
        return result;
    }

    /**
     * 返回一个 DefaultJsonHelper 实例(单例)<br/>
     */
    public static JsonHelper<?> getDefaultJsonHelperInstance(Boolean indent) {
        if (indent) {
            if (jsonHelper_Indent == null) {
                synchronized (JsonHelper.class) {
                    if (jsonHelper_Indent == null) {
                        jsonHelper_Indent = JsonHelper.createHelper(true);
                    }
                }
            }
            return jsonHelper_Indent;
        } else {
            if (jsonHelper == null) {
                synchronized (JsonHelper.class) {
                    if (jsonHelper == null) {
                        jsonHelper = JsonHelper.createHelper(false);
                    }
                }
            }
            return jsonHelper;
        }
    }

    /**
     * 返回一个自定义 JsonHelper 实例
     *
     * @param tClass JsonHelper 的一个实现类
     */
    public static <T> T createCustomJsonHelper(Class<T> tClass) {
        T result = createInstanceByClass(tClass);
        if (!(result instanceof JsonHelper)) {
            throw new UtilRuntimeException(String.format("Class(%s) should implement JsonHelper.", tClass.getName()));
        }
        return result;
    }

    /**
     * 返回一个 DefaultEncryptHelper 实例(单例)<br/>
     */
    public static EncryptHelper getDefaultEncryptHelperInstance() {
        if (encryptHelper == null) {
            synchronized (EncryptHelper.class) {
                if (encryptHelper == null) {
                    encryptHelper = EncryptHelper.createHelper();
                }
            }
        }
        return encryptHelper;
    }

    /**
     * 返回一个自定义 EncryptHelper 实例
     *
     * @param tClass EncryptHelper 的一个实现类
     */
    public static <T> T createCustomEncryptHelper(Class<T> tClass) {
        T result = createInstanceByClass(tClass);
        if (!(result instanceof EncryptHelper)) {
            throw new UtilRuntimeException(String.format("Class(%s) should implement EncryptHelper.", tClass.getName()));
        }
        return result;
    }

    /**
     * 创建用户自定义的类实例
     *
     * @param customClass 自定义类
     * @return 自定义类实例
     */
    public static <C> C createInstanceByClass(Class<C> customClass) {
        if (customClass == null) {
            throw new UtilRuntimeException(550, "Create target can't be null.");
        }
        try {
            return customClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new UtilRuntimeException(550, "Fail to get instance of " + customClass.getName() + ".", e);
        }
    }
}