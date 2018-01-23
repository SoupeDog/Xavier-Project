package org.xavier.common.utils.enums;

/**
 * 描述信息：<br/>
 * 字符串类型枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.12.22
 * @since Jdk 1.8
 */
public enum StringCategory {
    NUMBER("0~9", 48, 10),
    A_Z("大写字母A(65)~Z(90),", 65, 26),
    a_z("小写字母A(97)~Z(122),", 97, 26);

    private String description;
    /**
     * 首字符 ASCII 码起始序号
     */
    private Integer asciiStartPoint;
    /**
     * 该类型字符集字符总数
     */
    private Integer totalSize;

    StringCategory(String description, Integer asciiStartPoint, Integer totalSize) {
        this.description = description;
        this.asciiStartPoint = asciiStartPoint;
        this.totalSize = totalSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAsciiStartPoint() {
        return asciiStartPoint;
    }

    public void setAsciiStartPoint(Integer asciiStartPoint) {
        this.asciiStartPoint = asciiStartPoint;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }
}
