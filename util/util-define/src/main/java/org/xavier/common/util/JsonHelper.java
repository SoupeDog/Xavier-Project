package org.xavier.common.util;

import org.xavier.common.enums.ColumnType;
import org.xavier.common.util.exception.UtilRuntimeException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 描述信息：<br/>
 * Json 工具类接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.23
 * @since Jdk 1.8
 */
public interface JsonHelper<S> {
    String DEFAULT_PATH = "org.xavier.common.util.impl.DefaultJacksonJsonHelper";

    /**
     * 返回一个默认工具（这个方法会影响到 org.xavier.common.util.UtilsCreator 的静态实例）
     *
     * @param indent 是否开启缩进
     * @return 默认工具
     */
    static JsonHelper createHelper(boolean indent) {
        try {
            Class defaultClass = JsonHelper.class.getClassLoader().loadClass(DEFAULT_PATH);
            Constructor constructor = defaultClass.getConstructor(boolean.class);
            Object resultTemp = constructor.newInstance(indent);
            if (!(resultTemp instanceof JsonHelper)) {
                throw new UtilRuntimeException(String.format("Class(%s) should implement JsonHelper.", DEFAULT_PATH));
            }
            return (JsonHelper) resultTemp;
        } catch (ClassNotFoundException e) {
            throw new UtilRuntimeException(String.format("Class(%s) was not found.", DEFAULT_PATH));
        } catch (IllegalAccessException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        } catch (InstantiationException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        } catch (NoSuchMethodException e) {
            throw new UtilRuntimeException(String.format("Fail to get constructor of %s(Boolean).", DEFAULT_PATH));
        } catch (InvocationTargetException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        }
    }

    /**
     * 格式化对象或者字符串
     *
     * @param target 待格式化为 json 的目标
     * @return json 格式化的字符串
     */
    String format(Object target);

    /**
     * 将目标当做 json 解析，并获取特定 key 对应的 value(遇到收个符合条件的 key 即会返回)
     *
     * @param jsonType   对象类型
     * @param target     待解析对象
     * @param key        key
     * @param resultType 返回结果类型
     * @param tClass     返回结果类
     * @return 第一个符合条件的 value
     */
    <T> T getFirstValueByKey(ColumnType jsonType, Object target, String key, ColumnType resultType, Class<T> tClass);

    /**
     * 将目标当做 json 解析，并获取特定 key 对应的 value(根据序号从所有 key 条件的集合中返回最终结果)
     *
     * @param jsonType   对象类型
     * @param target     待解析对象
     * @param key        key
     * @param index      序号(从最外层向里匹配，首个匹配结果序号为 1 )
     * @param resultType 返回结果类型
     * @param tClass     返回结果类
     * @return 符合条件的 value
     */
    <T> T getValueByKeyIndex(ColumnType jsonType, Object target, String key, Integer index, ColumnType resultType, Class<T> tClass);

    /**
     * 获取序列化工具
     *
     * @return 返回当前 序列化工具依赖
     */
    S getDependence();
}