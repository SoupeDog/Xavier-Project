package org.xavier.common.utils.enums;

/**
 * 描述信息：<br/>
 * 参数类型枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.10.19
 * @since Jdk 1.8
 */
public enum ColumnType {
    AUTOMATIC(0, "Automatic detection(预留)"),
    STRING(1, "String"),
    BYTE(2, "Byte"),
    INTEGER(3, "Integer"),
    LONG(4, "Long"),
    FLOAT(5, "Float"),
    DOUBLE(6, "Double"),
    BOOLEAN(7, "Boolean"),
    NUMBER(8, "[Byte,Integer,Long,Float,Double]"),
    LIST(9, "List"),
    MAP(10, "Map"),
    OBJECT(11, "Object");

    private Byte index;
    private String msg;

    private ColumnType(Number index, String msg) {
        this.index = index.byteValue();
        this.msg = msg;
    }

    public Byte getValue() {
        return index;
    }

    public String getMsg() {
        return msg;
    }
}
