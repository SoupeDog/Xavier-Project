package org.xavier.common.util;

/**
 * 描述信息：<br/>
 * 唯一 id 生成器
 *
 * @author Xavier
 * @version 1.0
 * @date 2020/6/16
 * @since Jdk 1.8
 */
public interface RandomUniqueGenerator {
    /**
     * 返回一个不重复的数字 id
     *
     * @return 不重复的数字 id
     */
    long createKey();
}