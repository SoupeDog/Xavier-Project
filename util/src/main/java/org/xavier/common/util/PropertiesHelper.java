package org.xavier.common.util;


import org.xavier.common.enums.ColumnType;
import org.xavier.common.enums.StringFormatMode;

/**
 * 描述信息：<br/>
 * 数据校验工具类 接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.14
 * @since Jdk 1.8
 */
public interface PropertiesHelper {

    /**
     * 判断字符串是否为 空(去格式后空字符串) 或 null
     *
     * @param target 目标对象
     * @return true 为 null 或空串  false 为有效值
     */
    boolean stringIsNullOrEmpty(String target);

    /**
     * 将目标对象转化为字符串，可为 null  非空时调用其 toString() 方法
     *
     * @param target 目标对象
     * @return 转化后的字符串
     */
    String string(Object target);

    /**
     * 将目标对象转化为字符串，可为 null ，若不为 null 时，要求字符串长度在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的字符串
     */
    String string(Object target, Integer minLength, Integer maxLength, String msg);

    /**
     * 将目标对象转化为字符串，且要求对象不为 null 或 空字符串  非空时调用其 toString() 方法
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的字符串
     */
    String stringNotNull(Object target, String msg);

    /**
     * 将目标对象转化为字符串，且要求对象不为 null 或 空字符串,且要求字符串长度在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的字符串
     */
    String stringNotNull(Object target, Integer minLength, Integer maxLength, String msg);

    /**
     * 将目标对象转化为字符串，若对象为 null 或 空字符串时,将被赋为默认值
     *
     * @param target       目标对象
     * @param defaultValue 默认值
     * @return 转化后的字符串
     */
    String stringOfNullable(Object target, String defaultValue);

    /**
     * 将目标对象转化为字符串,若对象为 null 或 空字符串时,将被赋为默认值,且要求字符串长度在 minLength~maxLength 之间(闭区间)
     *
     * @param target       目标对象
     * @param msg          错误提示信息
     * @param minLength    最小长度
     * @param maxLength    最大长度
     * @param defaultValue 默认值
     * @return 转化后的字符串
     */
    String stringOfNullable(Object target, String defaultValue, Integer minLength, Integer maxLength, String msg);


    /**
     * 将目标对象转化为数字类型，可为 null
     *
     * @param target     目标对象
     * @param targetType 目标对象类型
     * @param msg        错误提示信息
     * @return 转化后的 Number 对象
     */
    Number numberFormat(Object target, ColumnType targetType, String msg);

    /**
     * 将目标对象转化为数字类型，可为 null
     *
     * @param target     目标对象
     * @param targetType 目标对象类型
     * @param msg        错误提示信息
     * @param minLength  最小长度
     * @param maxLength  最大长度
     * @return 转化后的 Number 对象
     */
    Number numberFormat(Object target, ColumnType targetType, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为数字类型，不可为 null
     *
     * @param target     目标对象
     * @param targetType 目标对象类型
     * @param msg        错误提示信息
     * @return 转化后的 Number 对象
     */
    Number numberFormatNotNull(Object target, ColumnType targetType, String msg);

    /**
     * 将目标对象转化为数字类型，不可为 null
     *
     * @param target     目标对象
     * @param targetType 目标对象类型
     * @param minLength  最小长度
     * @param maxLength  最大长度
     * @param msg        错误提示信息
     * @return 转化后的 Number 对象
     */
    Number numberFormatNotNull(Object target, ColumnType targetType, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为数字类型，若对象为 null 或 空字符串时,将被赋为默认值
     *
     * @param target       目标对象
     * @param targetType   目标对象类型
     * @param defaultValue 默认值
     * @param msg          错误提示信息
     * @return 转化后的 Number 对象
     */
    Number numberFormatOfNullable(Object target, Number defaultValue, ColumnType targetType, String msg);

    /**
     * 将目标对象转化为数字类型，若对象为 null 或 空字符串时,将被赋为默认值,且要求字符串长度在 minLength~maxLength 之间(闭区间)
     *
     * @param target       目标对象
     * @param targetType   目标对象类型
     * @param defaultValue 默认值
     * @param minLength    最小长度
     * @param maxLength    最大长度
     * @param msg          错误提示信息
     * @return 转化后的 Number 对象
     */
    Number numberFormatOfNullable(Object target, Number defaultValue, ColumnType targetType, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Byte，可为 null ,若不为 null 时，要求其取值上下限约为 ± 127
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的 Byte
     */
    Byte byteRange(Object target, String msg);

    /**
     * 将目标对象转化为 Byte，可为 null ,若不为 null 时，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小值
     * @param maxLength 最大值
     * @param msg       错误提示信息
     * @return 转化后的 Byte
     */
    Byte byteRange(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Byte，不可为 null ,要求其取值上下限约为 ± 127
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的 Byte
     */
    Byte byteRangeNotNull(Object target, String msg);

    /**
     * 将目标对象转化为 Byte，不可为 null ，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小值
     * @param maxLength 最大值
     * @param msg       错误提示信息
     * @return 转化后的 Byte
     */
    Byte byteRangeNotNull(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Byte，若对象为 null 或 空字符串时,将被赋为默认值
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Byte byteRangeOfNullable(Object target, Number defaultValue, String msg);

    /**
     * 将目标对象转化为 Byte，若对象为 null 或 空字符串时,将被赋为默认值,且要求字符串长度在 minLength~maxLength 之间(闭区间)
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param minLength    最小值
     * @param maxLength    最大值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Byte byteRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Short，可为 null ,若不为 null 时，要求其取值上下限约为 ± 127
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的 Byte
     */
    Short shortRange(Object target, String msg);

    /**
     * 将目标对象转化为 Short，可为 null ,若不为 null 时，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小值
     * @param maxLength 最大值
     * @param msg       错误提示信息
     * @return 转化后的 Byte
     */
    Short shortRange(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Short，不可为 null ,要求其取值上下限约为 ± 32767
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的 Byte
     */
    Short shortRangeNotNull(Object target, String msg);

    /**
     * 将目标对象转化为 Short，不可为 null ，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小值
     * @param maxLength 最大值
     * @param msg       错误提示信息
     * @return 转化后的 Byte
     */
    Short shortRangeNotNull(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Short，若对象为 null 或 空字符串时,将被赋为默认值
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Short shortRangeOfNullable(Object target, Number defaultValue, String msg);

    /**
     * 将目标对象转化为 Short，若对象为 null 或 空字符串时,将被赋为默认值,且要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param minLength    最小值
     * @param maxLength    最大值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Short shortRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Integer，可为 null ,若不为 null 时，要求其取值上下限约为 ± 2147483647
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的整型
     */
    Integer intRange(Object target, String msg);

    /**
     * 将目标对象转化为 Integer，可为 null ,若不为 null 时，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的整型
     */
    Integer intRange(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Integer，不可为 null ,要求其取值上下限约为 ± 2147483647
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的整型
     */
    Integer intRangeNotNull(Object target, String msg);

    /**
     * 将目标对象转化为 Integer，不可为 null ，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的整型
     */
    Integer intRangeNotNull(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Integer，若对象为 null 或 空字符串时,将被赋为默认值
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Integer intRangeOfNullable(Object target, Number defaultValue, String msg);

    /**
     * 将目标对象转化为 Integer，若对象为 null 或 空字符串时,将被赋为默认值,且要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param minLength    最小值
     * @param maxLength    最大值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Integer intRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Long ，可为 null,若不为 null 时，要求其取值上下限约为  ± 9223372036854775807
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的长整型
     */
    Long longRange(Object target, String msg);

    /**
     * 将目标对象转化为 Long ，可为 null,若不为 null 时，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的整型
     */
    Long longRange(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Long ，不可为 null，要求其取值上下限约为  ± 9223372036854775807
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的长整型
     */
    Long longRangeNotNull(Object target, String msg);

    /**
     * 将目标对象转化为 Long ，不可为 null，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的长整型
     */
    Long longRangeNotNull(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Long，若对象为 null 或 空字符串时,将被赋为默认值
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Long longRangeOfNullable(Object target, Number defaultValue, String msg);

    /**
     * 将目标对象转化为 Long，若对象为 null 或 空字符串时,将被赋为默认值,且要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param minLength    最小值
     * @param maxLength    最大值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Long longRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Float ，可为 null,若不为 null 时，要求其取值上下限约为 ± 3.4028235E38
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的单精度浮点型
     */
    Float floatRange(Object target, String msg);

    /**
     * 将目标对象转化为 Float ，可为 null,若不为 null 时，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的单精度浮点型
     */
    Float floatRange(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Float ，不可为 null,要求其取值上下限约为 ± 3.4028235E38
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的单精度浮点型
     */
    Float floatRangeNotNull(Object target, String msg);

    /**
     * 将目标对象转化为 Float ，不可为 null,要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的单精度浮点型
     */
    Float floatRangeNotNull(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Long，若对象为 null 或 空字符串时,将被赋为默认值
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Float floatRangeOfNullable(Object target, Number defaultValue, String msg);

    /**
     * 将目标对象转化为 Long，若对象为 null 或 空字符串时,将被赋为默认值,且要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param minLength    最小值
     * @param maxLength    最大值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Float floatRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Double ，可为 null，若不为 null 时，要求其取值上下限约为 ± 1.7976931348623157E308
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的双精度浮点型
     */
    Double doubleRange(Object target, String msg);

    /**
     * 将目标对象转化为 Double ，可为 null，若不为 null 时，要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的双精度浮点型
     */
    Double doubleRange(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Double ，不可为 null,要求其取值上下限约为 ± 1.7976931348623157E308
     *
     * @param target 目标对象
     * @param msg    错误提示信息
     * @return 转化后的双精度浮点型
     */
    Double doubleRangeNotNull(Object target, String msg);

    /**
     * 将目标对象转化为 Double ，不可为 null,要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target    目标对象
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @param msg       错误提示信息
     * @return 转化后的双精度浮点型
     */
    Double doubleRangeNotNull(Object target, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Double，若对象为 null 或 空字符串时,将被赋为默认值
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Double doubleRangeOfNullable(Object target, Number defaultValue, String msg);

    /**
     * 将目标对象转化为 Double，若对象为 null 或 空字符串时,将被赋为默认值,且要求其取值在 minLength~maxLength 之间(闭区间)
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param minLength    最小值
     * @param maxLength    最大值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Double doubleRangeOfNullable(Object target, Number defaultValue, Number minLength, Number maxLength, String msg);

    /**
     * 将目标对象转化为 Boolean ,可为 null {有效参数：true、false（不区分大小写）；数字 1、0）}
     *
     * @param target 目标对象
     * @param msg    错误信息
     * @return 转化后的布尔型
     */
    Boolean booleanFormat(Object target, String msg);

    /**
     * 将目标对象转化为 Boolean ,不可为 null {有效参数：true、false（不区分大小写）；数字 1、0）}
     *
     * @param target 目标对象
     * @param msg    错误信息
     * @return 转化后的布尔型
     */
    Boolean booleanFormatNotNull(Object target, String msg);

    /**
     * 将目标对象转化为 Boolean，若对象为 null 或 空字符串时,将被赋为默认值 {有效参数：true、false（不区分大小写）；数字 1、0）}
     *
     * @param target       目标对象
     * @param defaultValue 为 null 或 空字符串时的默认值
     * @param msg          错误提示信息
     * @return 转化后的 Byte
     */
    Boolean booleanFormatOfNullable(Object target, Boolean defaultValue, String msg);

    /**
     * 以 fillingChar 将target 从高位补齐到 totalSize <br/>
     * 例: totalSize=4 fillingChar='0' target="A4Q"<br/>
     * 结果 "0A4Q"<br/>
     * PS: 此方法会抛出 PropertiesException_Runtime (如长度为10的字符串要求补齐成长度为5)
     *
     * @param target           目标字符
     * @param totalSize        补位后预期字符串总长度
     * @param fillingChar      补位字符
     * @param stringFormatMode 返回值字符串大小写类型
     * @return 以 fillingChar 将target 从高位补齐到 totalSize 的字符串
     */
    String fillingTarget(Object target, Integer totalSize, char fillingChar, StringFormatMode stringFormatMode);
}