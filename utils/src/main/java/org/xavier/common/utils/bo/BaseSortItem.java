package org.xavier.common.utils.bo;

/**
 * 描述信息：<br/>
 * 排序时的单个元素 基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.11.30
 * @since Jdk 1.8
 */
public abstract class BaseSortItem<T> {
    /**
     * 存储的实际对象
     */
    private T targetObj;

    /**
     * 返回当前实际对象的排序依据值
     *
     * @return 排序依据值
     */
    public abstract int getCount();

    public T getTargetObj() {
        return targetObj;
    }

    public void setTargetObj(T targetObj) {
        this.targetObj = targetObj;
    }
}
