package org.xavier.common.util;

/**
 * 描述信息：<br/>
 * 默认的时间工具类接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/8/18
 * @since Jdk 1.8
 */
public interface TimeHelper {

    /**
     * 字符串转化为 long 型毫秒级时间戳
     *
     * @param target         需要格式化的时间戳字符串
     * @param timeFormatEnum 格式化目标枚举
     * @return 秒级时间戳
     */
    long stringToUTCTimeStamp(String target, TimeFormatEnum timeFormatEnum);


    /**
     * long 型毫秒级时间戳 转字符串形式
     *
     * @param target         需要格式化的时间戳
     * @param timeFormatEnum 格式化目标枚举
     * @return 格式化后的字符串
     */
    String antiStringToUTCTimeStamp(Long target, TimeFormatEnum timeFormatEnum);


    enum TimeFormatEnum {
        /**
         * 样例 20190818
         */
        yyyyMMdd(0, "yyyyMMdd"),
        /**
         * 样例 20190818 18:30:00
         */
        yyyyMMdd_HH_mm_ss(1, "yyyyMMdd HH:mm:ss"),
        /**
         * 样例 2019-08-18 18:30:00
         */
        yyyy_MM_dd_HH_mm_ss(2, "yyyy-MM-dd HH:mm:ss"),
        /**
         * 样例 20190818183000000
         */
        yyyyMMddHHmmssSSS(3, "yyyyMMddHHmmssSSS");

        /**
         * 序号
         */
        public final int index;

        /**
         * pattern
         */
        public final String pattern;

        TimeFormatEnum(int index, String pattern) {
            this.index = index;
            this.pattern = pattern;
        }
    }
}