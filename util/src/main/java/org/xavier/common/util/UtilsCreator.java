package org.xavier.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.xavier.common.exception.Universal_500_X_Exception_Runtime;
import org.xavier.common.util.base.*;
import org.xavier.common.util.impl.*;

import java.security.Security;

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
    private static volatile JsonHelper jsonHelper = null;
    private static volatile JsonHelper jsonHelper_Indent = null;
    private static volatile RandomHelper randomHelper = null;


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
     * 返回一个 DefaultJsonHelper 实例(单例)
     */
    public static JsonHelper getInstance_DefaultJsonHelper(Boolean openIndent) {
        if (openIndent == null || openIndent == false) {
            if (jsonHelper == null) {
                synchronized (DefaultJsonHelper.class) {
                    if (jsonHelper == null) {
                        jsonHelper = new DefaultJsonHelper(new ObjectMapper() {{
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
                synchronized (DefaultJsonHelper.class) {
                    if (jsonHelper_Indent == null) {
                        jsonHelper_Indent = new DefaultJsonHelper();
                    }
                }
            }
            return jsonHelper_Indent;
        }
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
}