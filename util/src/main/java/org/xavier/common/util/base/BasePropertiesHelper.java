package org.xavier.common.util.base;

import org.xavier.common.enums.ColumnType;
import org.xavier.common.enums.StringFormatMode;
import org.xavier.common.exception.PropertiesRuntimeException;
import org.xavier.common.exception.Universal500RuntimeException;
import org.xavier.common.util.PropertiesHelper;

/**
 * 描述信息：<br/>
 * 参数工具基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/7/5
 * @since Jdk 1.8
 */
public abstract class BasePropertiesHelper implements PropertiesHelper {
    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @param tClass 转化目标类型
     */
    protected abstract <T> T hookObject(T target, Class<T> tClass);

    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @return 转化后的参数
     */
    protected abstract String hookString(String target);

    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @return 转化后的参数
     */
    protected abstract Number hookNumber(Number target);

    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @return 转化后的参数
     */
    protected abstract Byte hookByte(Byte target);

    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @return 转化后的参数
     */
    protected abstract Short hookShort(Short target);


    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @return 转化后的参数
     */
    protected abstract Integer hookInteger(Integer target);

    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @return 转化后的参数
     */
    protected abstract Long hookLong(Long target);

    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @return 转化后的参数
     */
    protected abstract Float hookFloat(Float target);

    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @return 转化后的参数
     */
    protected abstract Double hookDouble(Double target);

    /**
     * 参数非空且符合预期时触发
     *
     * @param target 被转化的对象
     * @return 转化后的参数
     */
    protected abstract Boolean hookBoolean(Boolean target);

    /**
     * 需要补全字符时触发
     *
     * @param target 大小写处理前的补全字符
     * @return 转化后的参数
     */
    protected abstract String hookFilling(String target);

    @Override
    public String string(Object target) {
        if (target == null) {
            return hookString(null);
        }
        return hookString(target.toString());
    }

    @Override
    public String string(Object target, Integer minLength, Integer maxLength, String msg) {
        if (target == null) {
            return hookString(null);
        }
        String result = target.toString();
        int length = result.length();
        if (length < minLength || length > maxLength) {
            throw new PropertiesRuntimeException(msg);
        }
        return hookString(result);
    }

    @Override
    public String stringNotNull(Object target, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            throw new PropertiesRuntimeException(msg);
        }
        return string(target);
    }

    @Override
    public String stringNotNull(Object target, Integer minLength, Integer maxLength, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            throw new PropertiesRuntimeException(msg);
        }
        return string(target, minLength, maxLength, msg);
    }

    @Override
    public String stringOfNullable(Object target, String defaultValue) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue;
        }
        return string(target);
    }

    @Override
    public String stringOfNullable(Object target, String defaultValue, Integer minLength, Integer maxLength, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue;
        }
        return string(target, minLength, maxLength, msg);
    }

    @Override
    public Number numberFormat(Object target, ColumnType targetType, String msg) {
        if (target == null) {
            return hookNumber(null);
        }
        try {
            Number result;
            switch (targetType) {
                case BYTE:
                    result = Byte.valueOf(target.toString());
                    break;
                case SHORT:
                    result = Short.valueOf(target.toString());
                    break;
                case INTEGER:
                    result = Integer.valueOf(target.toString());
                    break;
                case LONG:
                    result = Long.valueOf(target.toString());
                    break;
                case FLOAT:
                    result = Float.valueOf(target.toString());
                    break;
                case DOUBLE:
                    result = Double.valueOf(target.toString());
                    break;
                default:
                    throw new PropertiesRuntimeException("ColumnType can't be null,and it should be [BYTE、SHORT、INTEGER、LONG、FLOAT、DOUBLE].");
            }
            return hookNumber(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Number numberFormat(Object target, ColumnType targetType, Number minLength, Number maxLength, String msg) {
        if (target == null) {
            return hookNumber(null);
        }
        try {
            Number result;
            switch (targetType) {
                case BYTE:
                    result = Byte.valueOf(target.toString());
                    if (result.byteValue() < minLength.byteValue() || result.byteValue() > maxLength.byteValue()) {
                        throw new PropertiesRuntimeException(msg);
                    }
                    break;
                case SHORT:
                    result = Short.valueOf(target.toString());
                    if (result.shortValue() < minLength.shortValue() || result.shortValue() > maxLength.shortValue()) {
                        throw new PropertiesRuntimeException(msg);
                    }
                    break;
                case INTEGER:
                    result = Integer.valueOf(target.toString());
                    if (result.intValue() < minLength.intValue() || result.intValue() > maxLength.intValue()) {
                        throw new PropertiesRuntimeException(msg);
                    }
                    break;
                case LONG:
                    result = Long.valueOf(target.toString());
                    if (result.longValue() < minLength.longValue() || result.longValue() > maxLength.longValue()) {
                        throw new PropertiesRuntimeException(msg);
                    }
                    break;
                case FLOAT:
                    result = Float.valueOf(target.toString());
                    if (result.floatValue() < minLength.floatValue() || result.floatValue() > maxLength.floatValue()) {
                        throw new PropertiesRuntimeException(msg);
                    }
                    break;
                case DOUBLE:
                    result = Double.valueOf(target.toString());
                    if (result.doubleValue() < minLength.doubleValue() || result.doubleValue() > maxLength.doubleValue()) {
                        throw new PropertiesRuntimeException(msg);
                    }
                    break;
                default:
                    throw new PropertiesRuntimeException("ColumnType can't be null,and it should be [BYTE、SHORT、INTEGER、LONG、FLOAT、DOUBLE].");
            }
            return hookNumber(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Number numberFormatNotNull(Object target, ColumnType targetType, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return numberFormat(target, targetType, msg);
    }

    @Override
    public Number numberFormatNotNull(Object target, ColumnType targetType, Number minLength, Number maxLength, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return numberFormat(target, targetType, minLength, maxLength, msg);
    }

    @Override
    public Number numberFormatOfNullable(Object target, Number defaultValue, ColumnType targetType, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue;
        }
        return numberFormat(target, targetType, msg);
    }

    @Override
    public Number numberFormatOfNullable(Object target, Number defaultValue, ColumnType targetType, Number minLength, Number maxLength, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue;
        }
        return numberFormat(target, targetType, minLength, maxLength, msg);
    }

    @Override
    public Byte byteRange(Object target, String msg) {
        if (target == null) {
            return hookByte(null);
        }
        try {
            Byte result = Byte.valueOf(target.toString());
            return hookByte(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Byte byteRange(Object target, Number minLength, Number maxLength, String msg) {
        if (target == null) {
            return hookByte(null);
        }
        try {
            Byte result = Byte.valueOf(target.toString());
            if (result < minLength.byteValue() || result > maxLength.byteValue()) {
                throw new PropertiesRuntimeException(msg);
            }
            return hookByte(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Byte byteRangeNotNull(Object target, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return byteRange(target, msg);
    }

    @Override
    public Byte byteRangeNotNull(Object target, Number minLength, Number maxLength, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return byteRange(target, minLength, maxLength, msg);
    }

    @Override
    public Byte byteRangeOfNullable(Object target, Number defaultValue, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue.byteValue();
        }
        return byteRange(target, msg);
    }

    @Override
    public Byte byteRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue.byteValue();
        }
        return byteRange(target, minLength, maxLength, msg);
    }

    @Override
    public Short shortRange(Object target, String msg) {
        if (target == null) {
            return hookShort(null);
        }
        try {
            Short result = Short.valueOf(target.toString());
            return hookShort(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Short shortRange(Object target, Number minLength, Number maxLength, String msg) {
        if (target == null) {
            return hookShort(null);
        }
        try {
            Short result = Short.valueOf(target.toString());
            if (result < minLength.shortValue() || result > maxLength.shortValue()) {
                throw new PropertiesRuntimeException(msg);
            }
            return hookShort(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Short shortRangeNotNull(Object target, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return shortRange(target, msg);
    }


    @Override
    public Short shortRangeNotNull(Object target, Number minLength, Number maxLength, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return shortRange(target, minLength, maxLength, msg);
    }

    @Override
    public Short shortRangeOfNullable(Object target, Number defaultValue, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue.shortValue();
        }
        return shortRange(target, msg);
    }

    @Override
    public Short shortRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue.shortValue();
        }
        return shortRange(target, minLength, maxLength, msg);
    }

    @Override
    public Integer intRange(Object target, String msg) {
        if (target == null) {
            return hookInteger(null);
        }
        try {
            Integer result = Integer.valueOf(target.toString());
            return hookInteger(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Integer intRange(Object target, Number minLength, Number maxLength, String msg) {
        if (target == null) {
            return hookInteger(null);
        }
        try {
            Integer result = Integer.valueOf(target.toString());
            if (result < minLength.intValue() || result > maxLength.intValue()) {
                throw new PropertiesRuntimeException(msg);
            }
            return hookInteger(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Integer intRangeNotNull(Object target, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return intRange(target, msg);
    }

    @Override
    public Integer intRangeNotNull(Object target, Integer minLength, Integer maxLength, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return intRange(target, minLength, maxLength, msg);
    }

    @Override
    public Integer intRangeOfNullable(Object target, Number defaultValue, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue.intValue();
        }
        return intRange(target, msg);
    }

    @Override
    public Integer intRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue.intValue();
        }
        return intRange(target, minLength, maxLength, msg);
    }

    @Override
    public Long longRange(Object target, String msg) {
        if (target == null) {
            return hookLong(null);
        }
        try {
            Long result = Long.valueOf(target.toString());
            return hookLong(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Long longRange(Object target, Number minLength, Number maxLength, String msg) {
        if (target == null) {
            return hookLong(null);
        }
        try {
            Long result = Long.valueOf(target.toString());
            if (result < minLength.longValue() || result > maxLength.longValue()) {
                throw new PropertiesRuntimeException(msg);
            }
            return hookLong(result);
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Long longRangeNotNull(Object target, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return longRange(target, msg);
    }

    @Override
    public Long longRangeNotNull(Object target, Number minLength, Number maxLength, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        return longRange(target, minLength, maxLength, msg);
    }

    @Override
    public Long longRangeOfNullable(Object target, Number defaultValue, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue.longValue();
        }
        return longRange(target, msg);
    }

    @Override
    public Long longRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg) {
        if (target == null || "".equals(target.toString().trim())) {
            return defaultValue.longValue();
        }
        return longRange(target, minLength, maxLength, msg);
    }

    @Override
    public Float floatRange(Object target, String msg) {
        Float result;
        try {
            if (target != null) {
                result = Float.valueOf(target.toString());
                result = hookFloat(result);
            } else {
                result = null;
            }
            return result;
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Float floatRangeNotNull(Object target, String msg) {
        Float result;
        try {
            if (target == null) {
                throw new PropertiesRuntimeException(msg);
            }
            result = Float.valueOf(target.toString());
            result = hookFloat(result);
            return result;
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Float floatRange(Object target, Number minLength, Number maxLength, String msg) {
        Float result;
        try {
            if (target != null) {
                result = Float.valueOf(target.toString());
                if (result < minLength.floatValue() || result > maxLength.floatValue()) {
                    throw new PropertiesRuntimeException(msg);
                }
                result = hookFloat(result);
            } else {
                result = null;
            }
            return result;
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Float floatRangeNotNull(Object target, Number minLength, Number maxLength, String msg) {
        Float result;
        try {
            if (target == null) {
                throw new PropertiesRuntimeException(msg);
            }
            result = Float.valueOf(target.toString());
            if (result < minLength.floatValue() || result > maxLength.floatValue()) {
                throw new PropertiesRuntimeException(msg);
            }
            result = hookFloat(result);
            return result;
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Double doubleRange(Object target, String msg) {
        Double result;
        try {
            if (target != null) {
                result = Double.valueOf(target.toString());
                result = hookDouble(result);
            } else {
                result = null;
            }
            return result;
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Double doubleRangeNotNull(Object target, String msg) {
        Double result;
        try {
            if (target == null) {
                throw new PropertiesRuntimeException(msg);
            }
            result = Double.valueOf(target.toString());
            result = hookDouble(result);
            return result;
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Double doubleRange(Object target, Number minLength, Number maxLength, String msg) {
        Double result;
        try {
            if (target != null) {
                result = Double.valueOf(target.toString());
                if (result < minLength.doubleValue() || result > maxLength.doubleValue()) {
                    throw new PropertiesRuntimeException(msg);
                }
                result = hookDouble(result);
            } else {
                result = null;
            }
            return result;
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Double doubleRangeNotNull(Object target, Number minLength, Number maxLength, String msg) {
        Double result;
        try {
            if (target == null) {
                throw new PropertiesRuntimeException(msg);
            }
            result = Double.valueOf(target.toString());
            if (result < minLength.doubleValue() || result > maxLength.doubleValue()) {
                throw new PropertiesRuntimeException(msg);
            }
            result = hookDouble(result);
            return result;
        } catch (NumberFormatException e) {
            throw new PropertiesRuntimeException(msg, e);
        }
    }

    @Override
    public Boolean booleanFormat(Object target, String msg) {
        if (target == null) {
            return null;
        }
        switch (target.toString().toLowerCase()) {
            case "true":
                hookBoolean(true);
                return true;
            case "false":
                hookBoolean(false);
                return false;
            case "1":
                hookBoolean(true);
                return true;
            case "0":
                hookBoolean(false);
                return false;
            default:
                throw new PropertiesRuntimeException(msg);
        }
    }

    @Override
    public Boolean booleanFormatNotNull(Object target, String msg) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        switch (target.toString().toLowerCase()) {
            case "1":
                hookBoolean(true);
                return true;
            case "0":
                hookBoolean(false);
                return false;
            case "true":
                hookBoolean(true);
                return true;
            case "false":
                hookBoolean(false);
                return false;
            default:
                throw new PropertiesRuntimeException(msg);
        }
    }

    @Override
    public String fillingTarget(Object target, Integer totalSize, char fillingChar, StringFormatMode stringFormatMode) {
        String result;
        String rowString = string(target, 0, totalSize, "Length of " + target + " should within " + totalSize + " .");
        StringBuilder fillPart = new StringBuilder();
        int needFillCount = totalSize;
        if (target != null) {
            needFillCount = totalSize - target.toString().length();
        }
        for (int i = 0; i < needFillCount; i++) {
            fillPart.append(fillingChar);
        }
        if (rowString != null) {
            result = fillPart.toString() + rowString;
        } else {
            result = fillPart.toString();
        }
        result = hookFilling(result);
        switch (stringFormatMode) {
            case DEFAULT:
                break;
            case UPPERCASE:
                result = result.toUpperCase();
                break;
            case LOWERCASE:
                result = result.toLowerCase();
                break;
            default:
                throw new Universal500RuntimeException("Unexpected [StringFormatMode]:" + stringFormatMode.getDescription() + " .");
        }
        return result;
    }

}