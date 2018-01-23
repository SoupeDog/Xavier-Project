package org.xavier.common.utils.base;

import org.xavier.common.exception.PropertiesException_Runtime;
import org.xavier.common.exception.Universal_500_X_Exception_Runtime;
import org.xavier.common.utils.PropertiesHelper;
import org.xavier.common.utils.SQLHelper;
import org.xavier.common.utils.UtilsCreator;
import org.xavier.common.utils.bo.ColumnInfo;
import org.xavier.common.enums.ColumnType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述信息：<br/>
 * 默认 SQL 语句工具主基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.20
 * @since Jdk 1.8
 */
public abstract class BaseSQLHelper implements SQLHelper {
    protected PropertiesHelper propertiesHelper;

    public BaseSQLHelper() {
        propertiesHelper = UtilsCreator.getInstance_DefaultPropertiesHelper();
    }

    public BaseSQLHelper(PropertiesHelper propertiesHelper) {
        this.propertiesHelper = propertiesHelper;
    }

    protected abstract String hookArray_String(String item);

    protected abstract Number hookArray_Number(Number item);

    protected abstract void hookArray_Boolean(Boolean item);

    protected abstract String hookList_String(String item);

    protected abstract Number hookList_Number(Number item);

    protected abstract void hookList_Boolean(Boolean item);

    protected abstract String hookMap_String(String item);

    protected abstract Number hookMap_Number(Number item);

    protected abstract void hookMap_Boolean(Boolean item);

    @Override
    public String arrayToSQLRange(ColumnType targetType, Object[] targetArray) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        switch (targetType) {
            case STRING:
                for (int i = 0; i < targetArray.length; i++) {
                    builder.append("'");
                    String item = propertiesHelper.stringNotNull(targetArray[i], "Unexpected Properties,index: " + i + ".");
                    item = hookArray_String(item);
                    builder.append(item);
                    builder.append("'");
                    builder.append(",");
                }
                break;
            case BYTE:
            case INTEGER:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NUMBER:
                for (int i = 0; i < targetArray.length; i++) {
                    Number item = propertiesHelper.numberFormatNotNull(targetArray[i], targetType, "Unexpected Properties,index: " + i + ".");
                    item = hookArray_Number(item);
                    builder.append(item);
                    builder.append(",");
                }
                break;
            case BOOLEAN:
                for (int i = 0; i < targetArray.length; i++) {
                    Boolean item = propertiesHelper.booleanFormatNotNull(targetArray[i], "Unexpected Properties(1),index: " + i + ".");
                    hookArray_Boolean(item);
                    builder.append(item);
                    builder.append(",");
                }
                break;
            default:
                throw new PropertiesException_Runtime("[targetType] can't be null.");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        return builder.toString();
    }

    @Override
    public String arrayToSQLRange(ColumnType targetType, Number minLength, Number maxLength, Object[] targetArray) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        switch (targetType) {
            case STRING:
                for (int i = 0; i < targetArray.length; i++) {
                    builder.append("'");
                    String item = propertiesHelper.stringNotNull(targetArray[i], minLength.intValue(), maxLength.intValue(), "Unexpected Properties,index: " + i + ".");
                    item = hookArray_String(item);
                    builder.append(item);
                    builder.append("'");
                    builder.append(",");
                }
                break;
            case BYTE:
            case INTEGER:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NUMBER:
                for (int i = 0; i < targetArray.length; i++) {
                    Number item = propertiesHelper.numberFormatNotNull(targetArray[i], targetType, minLength, maxLength, "Unexpected Properties,index: " + i + ".");
                    item = hookArray_Number(item);
                    builder.append(item);
                    builder.append(",");
                }
                break;
            case BOOLEAN:
                for (int i = 0; i < targetArray.length; i++) {
                    Boolean item = propertiesHelper.booleanFormatNotNull(targetArray[i], "Unexpected Properties(2),index: " + i + ".");
                    hookArray_Boolean(item);
                    builder.append(item);
                    builder.append(",");
                }
                break;
            default:
                throw new PropertiesException_Runtime("[targetType] can't be null.");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        return builder.toString();
    }

    @Override
    public <V> String arrayToSQLRange(ColumnType targetType, V[] targetArray, String methodName, Class<V> valueClass) {
        StringBuilder builder = new StringBuilder();
        try {
            Method method = valueClass.getDeclaredMethod(methodName);
            builder.append("(");
            switch (targetType) {
                case STRING:
                    for (int i = 0; i < targetArray.length; i++) {
                        builder.append("'");
                        String item = propertiesHelper.stringNotNull(method.invoke(targetArray[i]), "Unexpected Properties,index: " + i + ".");
                        item = hookArray_String(item);
                        builder.append(item);
                        builder.append("'");
                        builder.append(",");
                    }
                    break;
                case BYTE:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                case NUMBER:
                    for (int i = 0; i < targetArray.length; i++) {
                        Number item = propertiesHelper.numberFormatNotNull(method.invoke(targetArray[i]), targetType, "Unexpected Properties,index: " + i + ".");
                        item = hookArray_Number(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                case BOOLEAN:
                    for (int i = 0; i < targetArray.length; i++) {
                        Boolean item = propertiesHelper.booleanFormatNotNull(method.invoke(targetArray[i]), "Unexpected Properties(1),index: " + i + ".");
                        hookArray_Boolean(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                default:
                    throw new PropertiesException_Runtime("[targetType] can't be null.");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(")");
        } catch (NoSuchMethodException e) {
            throw new Universal_500_X_Exception_Runtime(555d, methodName + "() was not found.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        } catch (InvocationTargetException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        }
        return builder.toString();
    }

    @Override
    public <V> String arrayToSQLRange(ColumnType targetType, Number minLength, Number maxLength, V[] targetArray, String methodName, Class<V> valueClass) {
        StringBuilder builder = new StringBuilder();
        try {
            Method method = valueClass.getDeclaredMethod(methodName);
            builder.append("(");
            switch (targetType) {
                case STRING:
                    for (int i = 0; i < targetArray.length; i++) {
                        builder.append("'");
                        String item = propertiesHelper.stringNotNull(method.invoke(targetArray[i]), minLength.intValue(), maxLength.intValue(), "Unexpected Properties,index: " + i + ".");
                        item = hookArray_String(item);
                        builder.append(item);
                        builder.append("'");
                        builder.append(",");
                    }
                    break;
                case BYTE:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                case NUMBER:
                    for (int i = 0; i < targetArray.length; i++) {
                        Number item = propertiesHelper.numberFormatNotNull(method.invoke(targetArray[i]), targetType, minLength, maxLength, "Unexpected Properties,index: " + i + ".");
                        item = hookArray_Number(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                case BOOLEAN:
                    for (int i = 0; i < targetArray.length; i++) {
                        Boolean item = propertiesHelper.booleanFormatNotNull(method.invoke(targetArray[i]), "Unexpected Properties(2),index: " + i + ".");
                        hookArray_Boolean(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                default:
                    throw new PropertiesException_Runtime("[targetType] can't be null.");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(")");
        } catch (NoSuchMethodException e) {
            throw new Universal_500_X_Exception_Runtime(555d, methodName + "() was not found.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        } catch (InvocationTargetException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        }
        return builder.toString();
    }

    @Override
    public String listToSQLRange(ColumnType targetType, List targetList) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        switch (targetType) {
            case STRING:
                for (int i = 0; i < targetList.size(); i++) {
                    builder.append("'");
                    String item = propertiesHelper.stringNotNull(targetList.get(i), "Unexpected Properties,index: " + i + ".");
                    item = hookList_String(item);
                    builder.append(item);
                    builder.append("'");
                    builder.append(",");
                }
                break;
            case BYTE:
            case INTEGER:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NUMBER:
                for (int i = 0; i < targetList.size(); i++) {
                    Number item = propertiesHelper.numberFormatNotNull(targetList.get(i), targetType, "Unexpected Properties,index: " + i + ".");
                    item = hookList_Number(item);
                    builder.append(item);
                    builder.append(",");
                }
                break;
            case BOOLEAN:
                for (int i = 0; i < targetList.size(); i++) {
                    Boolean item = propertiesHelper.booleanFormatNotNull(targetList.get(i), "Unexpected Properties(1),index: " + i + ".");
                    hookList_Boolean(item);
                    builder.append(item);
                    builder.append(",");
                }
                break;
            default:
                throw new PropertiesException_Runtime("[targetType] can't be null.");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        return builder.toString();
    }

    @Override
    public String listToSQLRange(ColumnType targetType, Number minLength, Number maxLength, List targetList) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        switch (targetType) {
            case STRING:
                for (int i = 0; i < targetList.size(); i++) {
                    builder.append("'");
                    String item = propertiesHelper.stringNotNull(targetList.get(i), minLength.intValue(), maxLength.intValue(), "Unexpected Properties,index: " + i + ".");
                    item = hookList_String(item);
                    builder.append(item);
                    builder.append("'");
                    builder.append(",");
                }
                break;
            case BYTE:
            case INTEGER:
            case LONG:
            case FLOAT:
            case DOUBLE:
            case NUMBER:
                for (int i = 0; i < targetList.size(); i++) {
                    Number item = propertiesHelper.numberFormatNotNull(targetList.get(i), targetType, minLength, maxLength, "Unexpected Properties,index: " + i + ".");
                    item = hookList_Number(item);
                    builder.append(item);
                    builder.append(",");
                }
                break;
            case BOOLEAN:
                for (int i = 0; i < targetList.size(); i++) {
                    Boolean item = propertiesHelper.booleanFormatNotNull(targetList.get(i), "Unexpected Properties(2),index: " + i + ".");
                    hookList_Boolean(item);
                    builder.append(item);
                    builder.append(",");
                }
                break;
            default:
                throw new PropertiesException_Runtime("[targetType] can't be null.");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        return builder.toString();
    }

    @Override
    public <V> String listToSQLRange(ColumnType targetType, List<V> targetList, String itemName, String methodName, Class<V> valueClass) {
        StringBuilder builder = new StringBuilder();
        try {
            Method method = valueClass.getDeclaredMethod(methodName);
            builder.append("(");
            switch (targetType) {
                case STRING:
                    for (int i = 0; i < targetList.size(); i++) {
                        builder.append("'");
                        String item = propertiesHelper.stringNotNull(method.invoke(targetList.get(i)), "Unexpected Properties,index: " + i + ".");
                        item = hookList_String(item);
                        builder.append(item);
                        builder.append("'");
                        builder.append(",");
                    }
                    break;
                case BYTE:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                case NUMBER:
                    for (int i = 0; i < targetList.size(); i++) {
                        Number item = propertiesHelper.numberFormatNotNull(method.invoke(targetList.get(i)), targetType, "Unexpected Properties,index: " + i + ".");
                        item = hookList_Number(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                case BOOLEAN:
                    for (int i = 0; i < targetList.size(); i++) {
                        Boolean item = propertiesHelper.booleanFormatNotNull(method.invoke(targetList.get(i)), "Unexpected Properties(1),index: " + i + ".");
                        hookList_Boolean(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                default:
                    throw new PropertiesException_Runtime("[targetType] can't be null.");
            }

            builder.deleteCharAt(builder.length() - 1);
            builder.append(")");
        } catch (NoSuchMethodException e) {
            throw new Universal_500_X_Exception_Runtime(555d, methodName + "() was not found.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        } catch (InvocationTargetException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        }
        return builder.toString();
    }

    @Override
    public <V> String listToSQLRange(ColumnType targetType, Number minLength, Number maxLength, List<V> targetList, String itemName, String methodName, Class<V> valueClass) {
        StringBuilder builder = new StringBuilder();
        try {
            Method method = valueClass.getDeclaredMethod(methodName);
            builder.append("(");
            switch (targetType) {
                case STRING:
                    for (int i = 0; i < targetList.size(); i++) {
                        builder.append("'");
                        String item = propertiesHelper.stringNotNull(method.invoke(targetList.get(i)), minLength.intValue(), maxLength.intValue(), "Unexpected Properties,index: " + i + ".");
                        item = hookList_String(item);
                        builder.append(item);
                        builder.append("'");
                        builder.append(",");
                    }
                    break;
                case BYTE:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                case NUMBER:
                    for (int i = 0; i < targetList.size(); i++) {
                        Number item = propertiesHelper.numberFormatNotNull(method.invoke(targetList.get(i)), targetType, minLength, maxLength, "Unexpected Properties,index: " + i + ".");
                        item = hookList_Number(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                case BOOLEAN:
                    for (int i = 0; i < targetList.size(); i++) {
                        Boolean item = propertiesHelper.booleanFormatNotNull(method.invoke(targetList.get(i)), "Unexpected Properties(2),index: " + i + ".");
                        hookList_Boolean(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                default:
                    throw new PropertiesException_Runtime("[targetType] can't be null.");
            }

            builder.deleteCharAt(builder.length() - 1);
            builder.append(")");
        } catch (NoSuchMethodException e) {
            throw new Universal_500_X_Exception_Runtime(555d, methodName + "() was not found.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        } catch (InvocationTargetException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        }
        return builder.toString();
    }

    @Override
    public <K, V> String mapToSQLRange(ColumnType targetType, Map<K, V> targetMap, String methodName, Class<V> valueClass) {
        StringBuilder builder = new StringBuilder();
        try {
            Method method = valueClass.getDeclaredMethod(methodName);
            builder.append("(");
            switch (targetType) {
                case STRING:
                    for (V mapObj : targetMap.values()) {
                        builder.append("'");
                        String item = propertiesHelper.stringNotNull(method.invoke(mapObj), "Unexpected Properties,value: " + mapObj.toString() + ".");
                        item = hookMap_String(item);
                        builder.append(item);
                        builder.append("'");
                        builder.append(",");
                    }
                    break;
                case BYTE:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                case NUMBER:
                    for (V mapObj : targetMap.values()) {
                        Number item = propertiesHelper.numberFormatNotNull(method.invoke(mapObj), targetType, "Unexpected Properties,value: " + mapObj.toString() + ".");
                        item = hookMap_Number(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                case BOOLEAN:
                    for (V mapObj : targetMap.values()) {
                        Boolean item = propertiesHelper.booleanFormatNotNull(method.invoke(mapObj), "Unexpected Properties(1),value: " + mapObj.toString() + ".");
                        hookMap_Boolean(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                default:
                    throw new PropertiesException_Runtime("[targetType] can't be null.");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(")");
        } catch (NoSuchMethodException e) {
            throw new Universal_500_X_Exception_Runtime(555d, methodName + "() was not found.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        } catch (InvocationTargetException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        }
        return builder.toString();
    }

    @Override
    public <K, V> String mapToSQLRange(ColumnType targetType, Number minLength, Number maxLength, Map<K, V> targetMap, String methodName, Class<V> valueClass) {
        StringBuilder builder = new StringBuilder();
        try {
            Method method = valueClass.getDeclaredMethod(methodName);
            builder.append("(");
            switch (targetType) {
                case STRING:
                    for (V mapObj : targetMap.values()) {
                        builder.append("'");
                        String item = propertiesHelper.stringNotNull(method.invoke(mapObj), minLength.intValue(), maxLength.intValue(), "Unexpected Properties,value: " + mapObj.toString() + ".");
                        item = hookMap_String(item);
                        builder.append(item);
                        builder.append("'");
                        builder.append(",");
                    }
                    break;
                case BYTE:
                case INTEGER:
                case LONG:
                case FLOAT:
                case DOUBLE:
                case NUMBER:
                    for (V mapObj : targetMap.values()) {
                        Number item = propertiesHelper.numberFormatNotNull(method.invoke(mapObj), targetType, minLength, maxLength, "Unexpected Properties,value: " + mapObj.toString() + ".");
                        item = hookMap_Number(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                case BOOLEAN:
                    for (V mapObj : targetMap.values()) {
                        Boolean item = propertiesHelper.booleanFormatNotNull(method.invoke(mapObj), "Unexpected Properties(2),value: " + mapObj.toString() + ".");
                        hookMap_Boolean(item);
                        builder.append(item);
                        builder.append(",");
                    }
                    break;
                default:
                    throw new PropertiesException_Runtime("[targetType] can't be null.");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(")");
        } catch (NoSuchMethodException e) {
            throw new Universal_500_X_Exception_Runtime(555d, methodName + "() was not found.", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        } catch (InvocationTargetException e) {
            throw new Universal_500_X_Exception_Runtime(555d, "Fail to execute " + methodName + "()", e);
        }
        return builder.toString();
    }

    @Override
    public HashMap<String, Object> createFinalUpdateData(Map raw_Data, List<ColumnInfo> checkColumn) {
        if (raw_Data == null) {
            return null;
        }
        HashMap result = new HashMap();
        for (int i = 0; i < checkColumn.size(); i++) {
            ColumnInfo checkTemp = checkColumn.get(i);
            if (raw_Data.containsKey(checkTemp.getColumnName_As())) {
                result.put(checkTemp.getColumnName(), checkTemp.check_Get_Column(raw_Data.get(checkTemp.getColumnName_As())));
            }
        }
        return result.size() > 0 ? result : null;
    }

    @Override
    public HashMap<String, Object> createFinalUpdateDataWithTimeStamp(Map raw_Data, List<ColumnInfo> checkColumn, String... tsColumns) {
        String[] columns = tsColumns.clone();
        if (columns.length < 1) {
            throw new PropertiesException_Runtime("[tsColumns] can't be empty.");
        }
        if (raw_Data == null) {
            return null;
        }
        HashMap result = new HashMap();
        for (int i = 0; i < checkColumn.size(); i++) {
            ColumnInfo checkTemp = checkColumn.get(i);
            if (raw_Data.containsKey(checkTemp.getColumnName_As())) {
                result.put(checkTemp.getColumnName(), checkTemp.check_Get_Column(raw_Data.get(checkTemp.getColumnName_As())));
            }
        }
        if (result.size() > 0) {
            Long currentTs = System.currentTimeMillis();
            for (int i = 0; i < columns.length; i++) {
                result.put(columns[i], currentTs);
            }
        } else {
            result = null;
        }
        return result;
    }
}
