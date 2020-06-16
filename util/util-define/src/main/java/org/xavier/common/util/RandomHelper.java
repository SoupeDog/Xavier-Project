package org.xavier.common.util;


import org.xavier.common.enums.StringCategory;

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
     * 返回一个默认的雪花 id 工厂
     *
     * @return 一个默认的雪花 id 工厂
     */
    SnowFlakeGenerator getSnowFlakeGenerator();

}