package org.xavier.common.util;


import org.xavier.common.enums.StringCategory;
import org.xavier.common.util.exception.UtilRuntimeException;

/**
 * 描述信息：<br/>
 * 随机工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.12.22
 * @since Jdk 1.8
 */
public interface RandomHelper {
    String DEFAULT_PATH = "org.xavier.common.util.impl.DefaultRandomHelper";

    /**
     * 返回一个默认工具（这个方法会影响到 org.xavier.common.util.UtilsCreator 的静态实例）
     *
     * @return 默认工具
     */
    static RandomHelper createHelper() {
        try {
            Class defaultClass = RandomHelper.class.getClassLoader().loadClass(DEFAULT_PATH);
            Object resultTemp = defaultClass.newInstance();
            if (!(resultTemp instanceof RandomHelper)) {
                throw new UtilRuntimeException(String.format("Class(%s) should implement RandomHelper.", DEFAULT_PATH));
            }
            return (RandomHelper) resultTemp;
        } catch (ClassNotFoundException e) {
            throw new UtilRuntimeException(String.format("Class(%s) was not found.", DEFAULT_PATH));
        } catch (IllegalAccessException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        } catch (InstantiationException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        }
    }

    /**
     * 生成随机数字
     *
     * @param minValue 随机值最小值
     * @param maxValue 随机值最大值
     * @return 一个随机整数
     */
    int getRandomInteger(Number minValue, Number maxValue);

    /**
     * 可重复地生成随机字符串
     *
     * @param size           随机字符串目标长度
     * @param stringCategory 随机字符池类型
     * @return 随机字符串
     */
    String getRandomString(Integer size, StringCategory... stringCategory);

    /**
     * 生成无 "-" 符号的 UUID
     *
     * @return 无 "-" 符号的 UUID
     */
    String getUniversallyUniqueIdentifier();

    /**
     * 返回一个默认唯一编号生成器 (默认雪花算法 id 生成器)
     *
     * @return 默认唯一编号生成器
     */
    RandomUniqueGenerator getSnowFlakeGenerator();
}