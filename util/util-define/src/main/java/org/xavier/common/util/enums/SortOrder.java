package org.xavier.common.util.enums;

/**
 * 描述信息：<br/>
 * 容器排序规律类型
 *
 * @author Xavier
 * @version 1.0
 * @date 2020/6/16
 * @since Jdk 1.8
 */
enum SortOrder {
    /**
     * 不包含元素
     */
    EMPTY(0, "空容器"),
    /**
     * 全部元素值等效
     */
    CONGRUENCE(99, "全等"),
    /**
     * 排序无规律
     */
    DISORDER(100, "无序"),
    /**
     * 升序规律：满足下一个元素 >= 上一个元素
     */
    ASCENDING(200, "升序"),
    /**
     * 升序递增规律：满足下一个元素 > 上一个元素
     */
    ASCENDING_INCREMENTAL(250, "升序递增"),
    /**
     * 降序规律 满足下一个元素 <= 上一个元素
     */
    DESCENDING(300, "降序"),
    /**
     * 降序递减规律 满足下一个元素 < 上一个元素
     */
    DESCENDING_DECREASING(350, "降序递减");

    /**
     * 序号
     */
    private final int index;
    /**
     * 描述
     */
    private final String description;

    SortOrder(int index, String description) {
        this.index = index;
        this.description = description;
    }
}