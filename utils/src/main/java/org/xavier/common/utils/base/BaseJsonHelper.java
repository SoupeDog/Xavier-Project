package org.xavier.common.utils.base;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.xavier.common.exception.PropertiesException_Runtime;
import org.xavier.common.exception.Universal_400_X_Exception_Runtime;
import org.xavier.common.exception.Universal_500_X_Exception_Runtime;
import org.xavier.common.utils.JsonHelper;
import org.xavier.common.utils.PropertiesHelper;
import org.xavier.common.utils.UtilsCreator;
import org.xavier.common.enums.ColumnType;

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
public abstract class BaseJsonHelper implements JsonHelper {

    protected ObjectMapper mapper;
    protected PropertiesHelper propertiesHelper;

    public BaseJsonHelper() {
        initDefaultObjectMapper();
        propertiesHelper = UtilsCreator.getInstance_DefaultPropertiesHelper();
    }

    public BaseJsonHelper(PropertiesHelper propertiesHelper) {
        initDefaultObjectMapper();
        this.propertiesHelper = propertiesHelper;
    }

    public BaseJsonHelper(ObjectMapper mapper) {
        this.mapper = mapper;
        propertiesHelper = UtilsCreator.getInstance_DefaultPropertiesHelper();
    }

    public BaseJsonHelper(ObjectMapper mapper, PropertiesHelper propertiesHelper) {
        this.mapper = mapper;
        this.propertiesHelper = propertiesHelper;
    }

    protected void initDefaultObjectMapper() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//反序列化出现多余属性时,选择忽略不抛出异常
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);// 开启缩进
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);// 开启允许数字以 0 开头
    }

    protected abstract void hookGetValueByKey(ColumnType resultType, Object target);


    @Override
    public String format(Object target) {
        try {
            String result;
            if (target instanceof String) {
                String firstVal = target.toString().substring(0, 1);
                switch (firstVal) {
                    case "[":
                        result = mapper.writeValueAsString(mapper.readValue(target.toString(), List.class));
                        break;
                    case "{":
                        result = mapper.writeValueAsString(mapper.readValue(target.toString(), HashMap.class));
                        break;
                    default:
                        throw new Universal_400_X_Exception_Runtime(400F, "Fail to format : " + target);
                }
            } else {
                result = mapper.writeValueAsString(target);
            }
            return result;
        } catch (JsonProcessingException e) {
            throw new PropertiesException_Runtime("Invalid targetObjc,it can't format to Json.");
        } catch (IOException e) {
            throw new PropertiesException_Runtime("Invalid targetObjc,it can't format to Json.");
        }
    }

    @Override
    public <T> T getFirstValueByKey(ColumnType jsonType, Object targetObj, String key, ColumnType resultType, Class<T> tClass) {
        T result;
        JsonNode root = null;
        try {
            switch (jsonType) {
                case STRING:
                    root = mapper.readTree(targetObj.toString());
                    break;
                case LIST:
                case MAP:
                case OBJECT:
                    root = mapper.readTree(mapper.writeValueAsString(targetObj));//TODO 可优化为遍历
                    break;
                default:
                    new Universal_500_X_Exception_Runtime(555F, "[jsonType] should be String,List,Map or Object.(1)");
            }
            JsonNode resultNode = root.findValue(key);
            if (resultNode == null) {
                throw new PropertiesException_Runtime("Result of Key(" + key + ") was not found.");
            }
            switch (resultType) {
                case STRING:
                    result = (T) propertiesHelper.string(resultNode.textValue());
                    break;
                case BYTE:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                    result = (T) propertiesHelper.numberFormat(resultNode.numberValue(), resultType, "Invalid [" + resultNode.textValue() + "],it can't format to " + resultType.getMsg());
                    break;
                case BOOLEAN:
                    result = (T) propertiesHelper.booleanFormat(resultNode.textValue(), "Invalid [" + resultNode.textValue() + "],it can't format to " + resultType.getMsg());
                    break;
                default:
                    throw new Universal_500_X_Exception_Runtime(555F, "Invalid [resultType].");
            }
            hookGetValueByKey(resultType, result);
            return result;
        } catch (IOException e) {
            throw new PropertiesException_Runtime("Invalid targetObjc,it can't format to Json.");
        }
    }

    @Override
    public <T> T getValueByKey_Index(ColumnType jsonType, Object targetObj, String key, Integer index, ColumnType resultType, Class<T> tClass) {
        T result;
        JsonNode root = null;
        if (index < 1 || index > Integer.MAX_VALUE) {
            throw new PropertiesException_Runtime("[index] starts at 1,1 means the first one.");
        }
        index--;
        try {
            switch (jsonType) {
                case STRING:
                    root = mapper.readTree(targetObj.toString());
                    break;
                case LIST:
                case MAP:
                case OBJECT:
                    root = mapper.readTree(mapper.writeValueAsString(targetObj));//TODO 可优化为遍历
                    break;
                default:
                    new Universal_500_X_Exception_Runtime(555F, "[jsonType] should be String,List,Map or Object.(2)");
            }
            List<JsonNode> resultNodes = root.findValues(key);
            if (resultNodes == null) {
                throw new PropertiesException_Runtime("Result of Key(" + key + ") was not found.");
            }
            switch (resultType) {
                case STRING:
                    result = (T) propertiesHelper.string(resultNodes.get(index).textValue());
                    break;
                case BYTE:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                    result = (T) propertiesHelper.numberFormat(resultNodes.get(index).numberValue(), resultType, "Invalid [" + resultNodes.get(index).textValue() + "],it can't format to " + resultType.getMsg());
                    break;
                case BOOLEAN:
                    result = (T) propertiesHelper.booleanFormat(resultNodes.get(index).textValue(), "Invalid [" + resultNodes.get(index).textValue() + "],it can't format to " + resultType.getMsg());
                    break;
                default:
                    throw new Universal_500_X_Exception_Runtime(555F, "Invalid [resultType].");
            }
            hookGetValueByKey(resultType, result);
            return result;
        } catch (IOException e) {
            throw new PropertiesException_Runtime("Invalid targetObjc,it can't format to Json.");
        }
    }
}
