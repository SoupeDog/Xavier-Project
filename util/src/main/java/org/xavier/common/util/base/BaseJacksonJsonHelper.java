package org.xavier.common.util.base;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.xavier.common.enums.ColumnType;
import org.xavier.common.exception.PropertiesRuntimeException;
import org.xavier.common.util.JsonHelper;
import org.xavier.common.util.PropertiesHelper;
import org.xavier.common.util.exception.UtilRuntimeException;
import org.xavier.common.util.UtilsCreator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 描述信息：<br/>
 * 基于 Jackson 的 Json 工具主基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.23
 * @since Jdk 1.8
 */
public abstract class BaseJacksonJsonHelper implements JsonHelper<ObjectMapper> {

    protected ObjectMapper mapper;
    protected PropertiesHelper propertiesHelper;

    public BaseJacksonJsonHelper() {
        initDefaultObjectMapper();
        propertiesHelper = UtilsCreator.getDefaultPropertiesHelperInstance();
    }

    public BaseJacksonJsonHelper(PropertiesHelper propertiesHelper) {
        initDefaultObjectMapper();
        this.propertiesHelper = propertiesHelper;
    }

    public BaseJacksonJsonHelper(ObjectMapper mapper) {
        this.mapper = mapper;
        propertiesHelper = UtilsCreator.getDefaultPropertiesHelperInstance();
    }

    public BaseJacksonJsonHelper(ObjectMapper mapper, PropertiesHelper propertiesHelper) {
        this.mapper = mapper;
        this.propertiesHelper = propertiesHelper;
    }

    protected void initDefaultObjectMapper() {
        mapper = new ObjectMapper();
        //反序列化出现多余属性时,选择忽略不抛出异常
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 开启缩进
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        // 开启允许数字以 0 开头
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * 根据 Key 获取 value 的钩子函数
     *
     * @param resultType 预期获取值的类型
     * @param target     预期获取值
     * @param tClass     预期获取值的 Class 信息
     * @return 处理后的预期值
     */
    protected abstract <T> T hookGetValueByKey(ColumnType resultType, T target, Class<T> tClass);


    @Override
    public String format(Object target) {
        try {
            String result;
            if (target instanceof String) {
                String firstVal = target.toString().substring(0, 1);
                switch (firstVal) {
                    case "[":
                        result = mapper.writeValueAsString(mapper.readValue((String) target, List.class));
                        break;
                    case "{":
                        result = mapper.writeValueAsString(mapper.readValue((String) target, HashMap.class));
                        break;
                    default:
                        throw new PropertiesRuntimeException("Fail to format : " + target);
                }
            } else {
                result = mapper.writeValueAsString(target);
            }
            return result;
        } catch (JsonProcessingException e) {
            throw new PropertiesRuntimeException("[" + target + "] can't format to Json.");
        } catch (IOException e) {
            throw new PropertiesRuntimeException("[" + target + "] can't format to Json.");
        }
    }

    @Override
    public <T> T getFirstValueByKey(ColumnType jsonType, Object target, String key, ColumnType resultType, Class<T> tClass) {
        T result = null;
        JsonNode root = null;
        try {
            switch (jsonType) {
                case STRING:
                    root = mapper.readTree(target.toString());
                    break;
                case LIST:
                case MAP:
                    // 遍历是否会更快？
                case OTHER_OBJECT:
                    root = mapper.readTree(mapper.writeValueAsString(target));
                    break;
                default:
                    new UtilRuntimeException("Unexpected [jsonType]:" + jsonType + ",it should be String,List,Map or OTHER_OBJECT.");
            }
            JsonNode resultNode = root.findValue(key);
            if (resultNode == null) {
                return hookGetValueByKey(resultType, null, tClass);
            }
            switch (resultType) {
                case STRING:
                    result = (T) propertiesHelper.string(resultNode.textValue());
                    break;
                case BYTE:
                case SHORT:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                    result = (T) propertiesHelper.numberFormat(resultNode.numberValue(), resultType, "Invalid [" + resultNode.textValue() + "],it can't format to " + resultType.getDescription());
                    break;
                case BOOLEAN:
                    result = (T) propertiesHelper.booleanFormat(resultNode.textValue(), "Invalid [" + resultNode.textValue() + "],it can't format to " + resultType.getDescription());
                    break;
                default:
                    new UtilRuntimeException("Unexpected [resultType]:" + jsonType + ",it should be String,Byte,Short,Integer,Long,Float,Double or Boolean.");
            }
            return hookGetValueByKey(resultType, result, tClass);
        } catch (IOException e) {
            throw new PropertiesRuntimeException("[" + target + "] can't format to Json.");
        }
    }

    @Override
    public <T> T getValueByKeyIndex(ColumnType jsonType, Object target, String key, Integer index, ColumnType resultType, Class<T> tClass) {
        T result = null;
        JsonNode root = null;
        try {
            switch (jsonType) {
                case STRING:
                    root = mapper.readTree(target.toString());
                    break;
                case LIST:
                case MAP:
                    // 遍历是否会更快？
                case OTHER_OBJECT:
                    root = mapper.readTree(mapper.writeValueAsString(target));
                    break;
                default:
                    new UtilRuntimeException("Unexpected [jsonType]:" + jsonType + ",it should be String,List,Map or OTHER_OBJECT(2).");
            }
            List<JsonNode> resultNodes = root.findValues(key);
            if (resultNodes == null) {
                return hookGetValueByKey(resultType, null, tClass);
            }
            switch (resultType) {
                case STRING:
                    result = (T) propertiesHelper.string(resultNodes.get(index).textValue());
                    break;
                case BYTE:
                case SHORT:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                    result = (T) propertiesHelper.numberFormat(resultNodes.get(index).numberValue(), resultType, "Invalid [" + resultNodes.get(index).textValue() + "],it can't format to " + resultType.getDescription());
                    break;
                case BOOLEAN:
                    result = (T) propertiesHelper.booleanFormat(resultNodes.get(index).textValue(), "Invalid [" + resultNodes.get(index).textValue() + "],it can't format to " + resultType.getDescription());
                    break;
                default:
                    new UtilRuntimeException("Unexpected [resultType]:" + jsonType + ",it should be String,Byte,Short,Integer,Long,Float,Double or Boolean.");
            }
            return hookGetValueByKey(resultType, result, tClass);
        } catch (IOException e) {
            throw new PropertiesRuntimeException("[" + target + "] can't format to Json.");
        }
    }

    @Override
    public ObjectMapper getDependence() {
        return mapper;
    }
}