package org.xavier.common.util.bo;

import org.xavier.common.enums.ColumnType;
import org.xavier.common.util.PropertiesHelper;
import org.xavier.common.util.UtilsCreator;
import org.xavier.common.util.exception.UtilRuntimeException;

/**
 * 描述信息：<br/>
 * 对象属性信息
 *
 * @author Xavier
 * @version 1.0
 * @date 19-10-20
 * @since Jdk 1.8
 */
public class ColumnInfo {
    private static PropertiesHelper propertiesHelper= UtilsCreator.getDefaultPropertiesHelperInstance();
    /**
     * 属性名称
     */
    private String columnName;
    /**
     * 属性别名(为空则直接取 columnName)
     */
    private String columnAlias;
    /**
     * 属性类型
     */
    private ColumnType columnType;
    /**
     * 是否可空
     */
    private boolean nullable;
    /**
     * 最小长度
     */
    private Number minLength;
    /**
     * 最大长度
     */
    private Number maxLength;

    public ColumnInfo(String columnName, String columnAlias, ColumnType columnType, boolean nullable, Number minLength, Number maxLength) {
        this.columnName = columnName;
        this.columnAlias = propertiesHelper.stringOfNullable(columnAlias, columnName);
        this.columnType = columnType;
        this.nullable = propertiesHelper.booleanFormatOfNullable(nullable, true, String.format("[%s] should be a [%s] property.", columnName, columnType.getDescription()));
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    /**
     * 检测并获取属性是否符合要求
     *
     * @param target 待检测的对象
     */
    public Object checkAndGetColumn(Object target) {
        if (nullable) {
            switch (columnType) {
                case BYTE:
                    return propertiesHelper.byteRange(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case SHORT:
                    return propertiesHelper.shortRange(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case INTEGER:
                    return propertiesHelper.intRange(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case LONG:
                    return propertiesHelper.longRange(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case FLOAT:
                    return propertiesHelper.floatRange(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case DOUBLE:
                    return propertiesHelper.doubleRange(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case BOOLEAN:
                    return propertiesHelper.booleanFormat(target, String.format("[%s] should be a [%s] property.", columnName, columnType.getDescription()));
                case STRING:
                    return propertiesHelper.string(target, minLength.intValue(), maxLength.intValue(), String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                default:
                    throw new UtilRuntimeException("Unexpected columnType: " + columnType);
            }
        } else {
            switch (columnType) {
                case BYTE:
                    return propertiesHelper.byteRangeNotNull(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case SHORT:
                    return propertiesHelper.shortRangeNotNull(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case INTEGER:
                    return propertiesHelper.intRangeNotNull(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case LONG:
                    return propertiesHelper.longRangeNotNull(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case FLOAT:
                    return propertiesHelper.floatRangeNotNull(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case DOUBLE:
                    return propertiesHelper.doubleRangeNotNull(target, minLength, maxLength, String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                case BOOLEAN:
                    return propertiesHelper.booleanFormatNotNull(target, String.format("[%s] should be a [%s] property.", columnName, columnType.getDescription()));
                case STRING:
                    return propertiesHelper.stringNotNull(target, minLength.intValue(), maxLength.intValue(), String.format("[%s] should be a [%s] property,its length should more than %s and not more than %s .", columnName, columnType.getDescription(), minLength.toString(), maxLength.toString()));
                default:
                    throw new UtilRuntimeException("Unexpected columnType: " + columnType);
            }
        }
    }

    public static PropertiesHelper getPropertiesHelper() {
        return propertiesHelper;
    }

    public static void setPropertiesHelper(PropertiesHelper propertiesHelper) {
        ColumnInfo.propertiesHelper = propertiesHelper;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnAlias() {
        return columnAlias;
    }

    public void setColumnAlias(String columnAlias) {
        this.columnAlias = columnAlias;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public Number getMinLength() {
        return minLength;
    }

    public void setMinLength(Number minLength) {
        this.minLength = minLength;
    }

    public Number getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Number maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String toString() {
        return "ColumnInfo{" +
                "columnName='" + columnName + '\'' +
                ", columnAlias='" + columnAlias + '\'' +
                ", columnType=" + columnType +
                ", nullable=" + nullable +
                ", minLength=" + minLength +
                ", maxLength=" + maxLength +
                '}';
    }
}