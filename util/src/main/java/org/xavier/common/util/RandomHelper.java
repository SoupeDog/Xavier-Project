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
     * 可重复地生成随机字符串
     *
     * @param size           随机字符串目标长度
     * @param stringCategory 随机字符池类型
     * @return 随机字符串
     */
    String getRandomString(Integer size, StringCategory... stringCategory);

    /**
     * 返回 32位无空格 UUID
     */
    String getUUID();

}