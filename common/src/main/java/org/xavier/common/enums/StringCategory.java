package org.xavier.common.enums;

/**
 * 描述信息：<br/>
 * 字符串取值范围类型枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/7/5
 * @since Jdk 1.8
 */
public enum StringCategory {

    /**
     * 所有数字类型
     */
    NUMBER(0, "0~9", 48, 10),
    /**
     * 所有大写字母
     */
    A_Z(1, "大写字母A(65)~Z(90),", 65, 26),
    /**
     * 所有小写字母
     */
    a_z(2, "小写字母A(97)~Z(122),", 97, 26);
    /**
     * 序号
     */
    private Number index;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 首字符 ASCII 码起始序号
     */
    private Integer asciiStartPoint;
    /**
     * 该类型字符集字符总数
     */
    private Integer totalSize;

    StringCategory(Number index, String description, Integer asciiStartPoint, Integer totalSize) {
        this.index = index;
        this.description = description;
        this.asciiStartPoint = asciiStartPoint;
        this.totalSize = totalSize;
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