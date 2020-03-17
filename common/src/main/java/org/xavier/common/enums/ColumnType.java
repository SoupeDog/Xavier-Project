package org.xavier.common.enums;

/**
 * 描述信息：<br/>
 * 参数类型枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/7/5
 * @since Jdk 1.8
 */
public enum ColumnType {
    /**
     * 自动识别
     */
    AUTOMATIC(0, "Automatic detection(预留)"),
    /**
     * 字符串
     */
    STRING(1, "String"),
    /**
     * 字节型
     */
    BYTE(2, "Byte"),
    /**
     * 短整型
     */
    SHORT(3, "Short"),
    /**
     * 整型
     */
    INTEGER(4, "Integer"),
    /**
     * 长整型
     */
    LONG(5, "Long"),
    /**
     * 浮点型
     */
    FLOAT(6, "Float"),
    /**
     * 双精度浮点型
     */
    DOUBLE(7, "Double"),
    /**
     * 布尔型
     */
    BOOLEAN(8, "Boolean"),
    /**
     * 数字类型
     */
    NUMBER(9, "[Byte,Short,Integer,Long,Float,Double]"),
    /**
     * 变长数组类型
     */
    LIST(10, "List"),
    /**
     * 键值对集合类型
     */
    MAP(11, "Map"),
    /**
     * 长小数类型
     */
    BIG_DECIMAL(12, "BigDecimal"),
    /**
     * 其他对象类型
     */
    OTHER_OBJECT(13, "Object");

    private Number index;
    private String description;

    ColumnType(Number index, String description) {
        this.index = index;
        this.description = description;
    }

    public Number getIndex() {
        return index;
    }

    public void setIndex(Number index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}