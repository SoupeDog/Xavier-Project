package org.xavier.common.utils.bo;


import org.xavier.common.enums.ColumnType;
import org.xavier.common.exception.PropertiesException_Runtime;
import org.xavier.common.utils.PropertiesHelper;
import org.xavier.common.utils.UtilsCreator;
import org.xavier.common.utils.impl.DefaultPropertiesHelper;

/**
 * 描述信息：<br/>
 * 字段筛选信息
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.10.19
 * @since Jdk 1.8
 */
public class ColumnInfo {
    /**
     * 数据表参数名称
     */
    private String columnName;
    /**
     * 参数别名
     */
    private String columnName_As;
    /**
     * 参数类型枚举
     */
    private ColumnType type;
    /**
     * 是否可为 null
     */
    private Boolean null_Flag;
    /**
     * 最小长度
     */
    private Number minLength;
    /**
     * 最大长度
     */
    private Number maxLength;

    private PropertiesHelper propertiesHelper;

    public ColumnInfo() {
        this.type = ColumnType.STRING;
        this.columnName = "Default";
        this.minLength = 0;
        this.minLength = 100;
        this.null_Flag = true;
        this.columnName_As = columnName;
        this.propertiesHelper = UtilsCreator.getPropertiesHelper(DefaultPropertiesHelper.class);
    }

    public ColumnInfo(ColumnType columnType, String columnName, String columnName_As, Boolean null_Flag, Number minLength, Number maxLength) {
        this.type = columnType;
        this.columnName = columnName;
        this.columnName_As = columnName_As;
        this.null_Flag = null_Flag;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.propertiesHelper = UtilsCreator.getPropertiesHelper(DefaultPropertiesHelper.class);
    }

    public ColumnInfo(ColumnType columnType, String columnName, String columnName_As, Boolean null_Flag, Number minLength, Number maxLength, PropertiesHelper propertiesHelper) {
        this.type = columnType;
        this.columnName = columnName;
        this.columnName_As = columnName_As;
        this.null_Flag = null_Flag;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.propertiesHelper = propertiesHelper;
    }


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName_As() {
        return columnName_As;
    }

    public void setColumnName_As(String columnName_As) {
        this.columnName_As = columnName_As;
    }

    public ColumnType getType() {
        return type;
    }

    public void setType(ColumnType type) {
        this.type = type;
    }

    public Boolean getNull_Flag() {
        return null_Flag;
    }

    public void setNull_Flag(Boolean null_Flag) {
        this.null_Flag = null_Flag;
    }

    public Number getMinLength() throws PropertiesException_Runtime {
        return minLength;
    }

    public void setMinLength(Number minLength) throws PropertiesException_Runtime {
        switch (type) {
            case BYTE:
                this.minLength = propertiesHelper.byteRange(minLength, String.format("Unexpected [minLength]: %s, it should be %s .", minLength, type.getMsg()));
            case INTEGER:
                this.minLength = propertiesHelper.intRange(minLength, String.format("Unexpected [minLength]: %s, it should be %s .", minLength, type.getMsg()));
            case LONG:
                this.minLength = propertiesHelper.longRange(minLength, String.format("Unexpected [minLength]: %s, it should be %s .", minLength, type.getMsg()));
            case FLOAT:
                this.minLength = propertiesHelper.floatRange(minLength, String.format("Unexpected [minLength]: %s, it should be %s .", minLength, type.getMsg()));
            case DOUBLE:
                this.minLength = propertiesHelper.doubleRange(minLength, String.format("Unexpected [minLength]: %s, it should be %s .", minLength, type.getMsg()));
            case STRING:
                this.minLength = propertiesHelper.intRange(minLength, String.format("Unexpected [minLength]: %s, it should be %s .", minLength, type.getMsg()));
            default:
                throw new PropertiesException_Runtime(String.format("Unexpected [type]: %s", type.getMsg()));
        }
    }

    public Number getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Number maxLength) throws PropertiesException_Runtime {
        switch (type) {
            case BYTE:
                this.maxLength = propertiesHelper.byteRange(maxLength, String.format("Unexpected [maxLength]: %s, it should be %s .", maxLength, type.getMsg()));
            case INTEGER:
                this.maxLength = propertiesHelper.intRange(maxLength, String.format("Unexpected [maxLength]: %s, it should be %s .", maxLength, type.getMsg()));
            case LONG:
                this.maxLength = propertiesHelper.longRange(maxLength, String.format("Unexpected [maxLength]: %s, it should be %s .", maxLength, type.getMsg()));
            case FLOAT:
                this.maxLength = propertiesHelper.floatRange(maxLength, String.format("Unexpected [maxLength]: %s, it should be %s .", maxLength, type.getMsg()));
            case DOUBLE:
                this.maxLength = propertiesHelper.doubleRange(maxLength, String.format("Unexpected [maxLength]: %s, it should be %s .", maxLength, type.getMsg()));
            case STRING:
                this.maxLength = propertiesHelper.intRange(maxLength, String.format("Unexpected [maxLength]: %s, it should be %s .", maxLength, type.getMsg()));
            default:
                throw new PropertiesException_Runtime(String.format("Unexpected [type]: %s", type.getMsg()));
        }
    }

    /**
     * 验证参数并返回目标参数的预期类型值
     *
     * @param target 目标参数
     * @return 目标参数预期类型值
     */
    public Object check_Get_Column(Object target) throws PropertiesException_Runtime {
        if (null_Flag) {
            switch (type) {
                case BYTE:
                    return propertiesHelper.byteRange(target, minLength.byteValue(), maxLength.byteValue(), String.format("Unexpected [%s]: %s, its length should between %s and %s .", columnName_As, target, minLength, maxLength));
                case INTEGER:
                    return propertiesHelper.intRange(target, minLength.intValue(), maxLength.intValue(), String.format("Unexpected [%s]: %s, its length should between %s and %s  .", columnName_As, target, minLength, maxLength));
                case LONG:
                    return propertiesHelper.longRange(target, minLength.longValue(), maxLength.longValue(), String.format("Unexpected [%s]: %s, its length should between %s and %s  .", columnName_As, target, minLength, maxLength));
                case FLOAT:
                    return propertiesHelper.floatRange(target, minLength.floatValue(), maxLength.floatValue(), String.format("Unexpected [%s]: %s, its length should between %s and %s  .", columnName_As, target, minLength, maxLength));
                case DOUBLE:
                    return propertiesHelper.doubleRange(target, minLength.doubleValue(), maxLength.doubleValue(), String.format("Unexpected [%s]: %s, its length should between %s and %s  .", columnName_As, target, minLength, maxLength));
                case STRING:
                    return propertiesHelper.string(target, minLength.intValue(), maxLength.intValue(), String.format("Unexpected [%s]: %s, its length should within %s .", columnName_As, target, maxLength));
                case BOOLEAN:
                    return propertiesHelper.booleanFormat(target, String.format("Unexpected [%s]: %s, it should be 0/1/false/true .", columnName_As, target));
                default:
                    throw new PropertiesException_Runtime(String.format("Unexpected [type]: %s", type.getMsg()));
            }
        } else {
            switch (type) {
                case BYTE:
                    return propertiesHelper.byteRangeNotNull(target, minLength.byteValue(), maxLength.byteValue(), String.format("Unexpected [%s]: %s, its length should within %s and its value can't be null .", columnName_As, target, maxLength));
                case INTEGER:
                    return propertiesHelper.intRangeNotNull(target, minLength.intValue(), maxLength.intValue(), String.format("Unexpected [%s]: %s, its length should within %s and its value can't be null .", columnName_As, target, maxLength));
                case LONG:
                    return propertiesHelper.longRangeNotNull(target, minLength.longValue(), maxLength.longValue(), String.format("Unexpected [%s]: %s, its length should within %s and its value can't be null .", columnName_As, target, maxLength));
                case FLOAT:
                    return propertiesHelper.floatRangeNotNull(target, minLength.floatValue(), maxLength.floatValue(), String.format("Unexpected [%s]: %s, its length should within %s and its value can't be null .", columnName_As, target, maxLength));
                case DOUBLE:
                    return propertiesHelper.doubleRangeNotNull(target, minLength.doubleValue(), maxLength.doubleValue(), String.format("Unexpected [%s]: %s, its length should within %s and its value can't be null .", columnName_As, target, maxLength));
                case STRING:
                    return propertiesHelper.stringNotNull(target, minLength.intValue(), maxLength.intValue(), String.format("Unexpected [%s]: %s, its length should within %s and its value can't be null .", columnName_As, target, maxLength));
                case BOOLEAN:
                    return propertiesHelper.booleanFormatNotNull(target, String.format("Unexpected [%s]: %s, it should be 0/1/false/true .", columnName_As, target));
                default:
                    throw new PropertiesException_Runtime(String.format("Unexpected [type]: %s", type.getMsg()));
            }
        }
    }
}