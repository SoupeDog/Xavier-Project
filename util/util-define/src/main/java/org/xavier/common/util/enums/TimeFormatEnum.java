package org.xavier.common.util.enums;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2020/6/16
 * @since Jdk 1.8
 */
public enum TimeFormatEnum {

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
     * 样例 20190818183000
     */
    yyyyMMddHHmmss(3, "yyyyMMddHHmmss"),
    /**
     * 样例 20190818183000000
     */
    yyyyMMddHHmmssSSS(4, "yyyyMMddHHmmssSSS");

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