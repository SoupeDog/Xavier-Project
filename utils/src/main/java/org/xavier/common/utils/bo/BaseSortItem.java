package org.xavier.common.utils.bo;

/**
 * 描述信息：<br/>
 * 排序比较接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.11.30
 * @since Jdk 1.8
 */
public interface BaseSortItem<T> {
    /**
     * 用自身去和另一个同类对象比较，返回第一个元素的相对大小描述信息
     *
     * @param currentItem 当前元素
     * @param anotherItem 参照物
     * @return 当前元素与参照物的相对大小关系
     */
    CompareRelativeResultEnum toCompareAnother(T currentItem, T anotherItem);
}