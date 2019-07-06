package org.xavier.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.xavier.common.util.base.BasePropertiesHelper;
import org.xavier.common.util.impl.DefaultJacksonJsonHelper;
import org.xavier.common.util.impl.DefaultPropertiesHelper;

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
    private static volatile DefaultJacksonJsonHelper jsonHelper = null;
    private static volatile DefaultJacksonJsonHelper jsonHelper_Indent = null;
    private static volatile RandomHelper randomHelper = null;


    private UtilsCreator() {
    }

    /**
     * 返回一个 PropertiesHelper 实例
     *
     * @param tClass PropertiesHelper 的一个实现类
     */
    public static PropertiesHelper createPropertiesHelper(Class tClass) {
        try {
            Object result = tClass.newInstance();
            if (!(result instanceof BasePropertiesHelper)) {
                throw new UtilRuntimeException("[tClass] should extend BasePropertiesHelper.");
            }
            return (PropertiesHelper) result;
        } catch (InstantiationException e) {
            throw new UtilRuntimeException(500, "Fail to get PropertiesHelper.", e);
        } catch (IllegalAccessException e) {
            throw new UtilRuntimeException(500, "Fail to get PropertiesHelper.", e);
        }
    }


    /**
     * 返回一个 DefaultPropertiesHelper 实例(单例)
     */
    public static PropertiesHelper getDefaultPropertiesHelperInstance() {
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
     * 返回一个 JsonHelper 实例
     *
     * @param tClass JsonHelper 的一个实现类
     */
    public static JsonHelper createJsonHelper(Class tClass) {
        try {
            Object result = tClass.newInstance();
            if (!(result instanceof JsonHelper)) {
                throw new UtilRuntimeException(550, "[tClass] should extend JsonHelper.");
            }
            return (JsonHelper) result;
        } catch (InstantiationException e) {
            throw new UtilRuntimeException(550, "Fail to get BaseListHelper.", e);
        } catch (IllegalAccessException e) {
            throw new UtilRuntimeException(550, "[tClass] should extend JsonHelper.", e);
        }
    }

    /**
     * 返回一个 DefaultJacksonJsonHelper 实例(单例)
     */
    public static JsonHelper getDefaultJsonHelperInstance(Boolean openIndent) {
        if (openIndent == null || openIndent == false) {
            if (jsonHelper == null) {
                synchronized (DefaultJacksonJsonHelper.class) {
                    if (jsonHelper == null) {
                        jsonHelper = new DefaultJacksonJsonHelper(new ObjectMapper() {{
                            // 关闭缩进
                            configure(SerializationFeature.INDENT_OUTPUT, false);
                            // 开启允许数字以 0 开头
                            configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
                            // 反序列化出现多余属性时,选择忽略不抛出异常
                            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        }});
                    }
                }
            }
            return jsonHelper;
        } else {
            if (jsonHelper_Indent == null) {
                synchronized (DefaultJacksonJsonHelper.class) {
                    if (jsonHelper_Indent == null) {
                        jsonHelper_Indent = new DefaultJacksonJsonHelper();
                    }
                }
            }
            return jsonHelper_Indent;
        }
    }

    /**
     * 返回一个 RandomHelper 实例
     *
     * @param tClass RandomHelper 的一个实现类
     */
    public static RandomHelper createRandomHelper(Class tClass) {
        try {
            Object result = tClass.newInstance();
            if (!(result instanceof BaseRandomHelper)) {
                throw new Universal_500_X_Exception_Runtime(550, "[tClass] should extend BaseRandomHelper.");
            }
            return (RandomHelper) result;
        } catch (InstantiationException e) {
            throw new Universal_500_X_Exception_Runtime(550, "Fail to get BaseListHelper.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(550, "[tClass] should extend BaseRandomHelper.", e);
        }
    }

    /**
     * 返回一个 DefaultRandomHelper 实例(单例)<br/>
     * PS: 字母 O 会被替换成 X ,数字 0 会被替换成 2
     */
    public static RandomHelper getDefaultRandomHelperInstance() {
        if (randomHelper == null) {
            synchronized (DefaultRandomHelper.class) {
                if (randomHelper == null) {
                    randomHelper = new DefaultRandomHelper();
                }
            }
        }
        return randomHelper;
    }
}