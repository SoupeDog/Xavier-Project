package org.xavier.common.utils.bo;

/**
 * 描述信息：<br/>
 * 自定排序工具，元素比较结果枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/5
 * @since Jdk 1.8
 */
public enum CompareRelativeResultEnum {

    SMALLER(-1, "当前的对象更小"),
    EQUAL(0, "相等"),
    BIGGER(1, "当前的对象更大");

    /**
     * 相对大小标识符
     */
    private byte val;
    private String description;

    CompareRelativeResultEnum(Number val, String description) {
        this.val = val.byteValue();
        this.description = description;
    }
}