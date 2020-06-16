package org.xavier.common.util;

/**
 * 描述信息：<br/>
 * 雪花算法生成器
 *
 * @author Xavier
 * @version 1.0
 * @date 2020/6/16
 * @since Jdk 1.8
 */
public interface SnowFlakeGenerator {
    /**
     * 返回一个不重复的雪花 id
     *
     * @return 不重复的雪花 id
     */
    long createKey();
}