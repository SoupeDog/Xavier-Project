package org.xavier.common.util;

import org.xavier.common.util.exception.UtilRuntimeException;

/**
 * 描述信息：<br/>
 * 工具基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2020/6/16
 * @since Jdk 1.8
 */
public abstract class BaseHelper<T> {
    /**
     * 返回一个默认工具（这个方法会影响到 org.xavier.common.util.UtilsCreator 的静态实例）
     *
     * @return 默认工具
     */
    abstract T createHelper();

    /**
     * 创建用户自定义的工具类
     *
     * @param customHelper 自定义类
     * @return 自定义类实例
     */
    public <C> C createHelper(Class<C> customHelper) {
        if (customHelper == null) {
            throw new UtilRuntimeException(550, "Create target can't be null.");
        }
        try {
            C result = customHelper.newInstance();
            return result;
        } catch (InstantiationException e) {
            throw new UtilRuntimeException(550, "Fail to create " + customHelper.getName() + ".", e);
        } catch (IllegalAccessException e) {
            throw new UtilRuntimeException(550, "Fail to create " + customHelper.getName() + ".", e);
        }
    }
}