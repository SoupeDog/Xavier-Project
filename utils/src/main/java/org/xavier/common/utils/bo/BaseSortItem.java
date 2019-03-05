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
public interface BaseSortItem {
    /**
     * 用自身去和另一个同类对象比较，返回当前元素的相对大小描述
     *
     * @param another 参照物
     * @return 自身与参照物的关系
     */
    CompareRelativeResultEnum toCompareAnother(BaseSortItem another);
}