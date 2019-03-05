package org.xavier.common.utils.base;

import org.xavier.common.enums.ColumnType;
import org.xavier.common.exception.PropertiesException_Runtime;
import org.xavier.common.exception.Universal_500_X_Exception_Runtime;
import org.xavier.common.utils.ListHelper;
import org.xavier.common.utils.PropertiesHelper;
import org.xavier.common.utils.UtilsCreator;
import org.xavier.common.utils.bo.BaseSortItem;
import org.xavier.common.utils.bo.CompareRelativeResultEnum;
import org.xavier.common.utils.bo.SortedTypeEnum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述信息：<br/>
 * List 工具类主基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.22
 * @since Jdk 1.8
 */
public abstract class BaseListHelper implements ListHelper {
    protected PropertiesHelper propertiesHelper;


    protected abstract void hook_Serialize_String(String item);

    protected abstract void hook_Serialize_Number(Number item);

    protected abstract void hook_Serialize_Boolean(Boolean item);

    public BaseListHelper() {
        propertiesHelper = UtilsCreator.getInstance_DefaultPropertiesHelper();
    }

    public BaseListHelper(PropertiesHelper propertiesHelper) {
        this.propertiesHelper = propertiesHelper;
    }

    @Override
    public void listNotEmpty(List list, String targetDescription) {
        if (list == null || list.size() < 1) {
            throw new PropertiesException_Runtime("[" + targetDescription + "] can't be null,and it can't be empty.");
        }
    }

    @Override
    public <T> ArrayList<T> createSingleList(T target) {
        ArrayList<T> result = new ArrayList();
        result.add(target);
        return result;
    }

    @Override
    public String serializeList(Boolean format, ColumnType itemType, List targetList) {
        StringBuilder builder = new StringBuilder();
        if (targetList == null || targetList.size() < 1) {
            builder.append("Null");
        } else {
            if (format) {
                builder.append("[");
                switch (itemType) {
                    case STRING:
                        for (int i = 0; i < targetList.size(); i++) {
                            builder.append("\"");
                            String item = propertiesHelper.stringNotNull(targetList.get(i), "Unexpected Properties(1),index: " + i + ".");
                            hook_Serialize_String(item);
                            builder.append(item);
                            builder.append("\"");
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
                            Number item = propertiesHelper.numberFormatNotNull(targetList.get(i), itemType, "Unexpected Properties(1),index: " + i + ".");
                            hook_Serialize_Number(item);
                            builder.append(item);
                            builder.append(",");
                        }
                        break;
                    case BOOLEAN:
                        for (int i = 0; i < targetList.size(); i++) {
                            Boolean item = propertiesHelper.booleanFormat(targetList.get(i), "Unexpected Properties(1),index: " + i + ".");
                            hook_Serialize_Boolean(item);
                            builder.append(item);
                            builder.append(",");
                        }
                    default:
                        throw new PropertiesException_Runtime("Unexpected ColumnType.");
                }
                builder.deleteCharAt(builder.length() - 1);
                builder.append("]");
            } else {
                switch (itemType) {
                    case STRING:
                        for (int i = 0; i < targetList.size(); i++) {
                            builder.append("\"");
                            String item = propertiesHelper.stringNotNull(targetList.get(i), "Unexpected Properties(2),index: " + i + ".");
                            builder.append(item);
                            builder.append("\"");
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
                            Number item = propertiesHelper.numberFormatNotNull(targetList.get(i), itemType, "Unexpected Properties(2),index: " + i + ".");
                            builder.append(item);
                            builder.append(",");
                        }
                        break;
                    case BOOLEAN:
                        for (int i = 0; i < targetList.size(); i++) {
                            Boolean item = propertiesHelper.booleanFormat(targetList.get(i), "Unexpected Properties(2),index: " + i + ".");
                            builder.append(item);
                            builder.append(",");
                        }
                    default:
                        throw new PropertiesException_Runtime("Unexpected ColumnType.");
                }
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return builder.toString();
    }

    @Override
    public <T> String serializeList(Boolean format, ColumnType itemType, List<T> targetList, String methodName, Class<T> tClass) {
        try {
            Method method = tClass.getDeclaredMethod(methodName);
            StringBuilder builder = new StringBuilder();
            if (targetList == null || targetList.size() < 1) {
                builder.append("Null");
            } else {
                if (format) {
                    builder.append("[");
                    switch (itemType) {
                        case STRING:
                            for (int i = 0; i < targetList.size(); i++) {
                                builder.append("\"");
                                String item = propertiesHelper.stringNotNull(method.invoke(targetList.get(i)), "Unexpected Properties(1),index: " + i + ".");
                                builder.append(item);
                                builder.append("\"");
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
                                Number item = propertiesHelper.numberFormatNotNull(method.invoke(targetList.get(i)), itemType, "Unexpected Properties(1),index: " + i + ".");
                                builder.append(item);
                                builder.append(",");
                            }
                            break;
                        case BOOLEAN:
                            for (int i = 0; i < targetList.size(); i++) {
                                Boolean item = propertiesHelper.booleanFormat(method.invoke(targetList.get(i)), "Unexpected Properties(1),index: " + i + ".");
                                builder.append(item);
                                builder.append(",");
                            }
                        default:
                            throw new PropertiesException_Runtime("Unexpected ColumnType.");
                    }
                    builder.deleteCharAt(builder.length() - 1);
                    builder.append("]");
                } else {
                    switch (itemType) {
                        case STRING:
                            for (int i = 0; i < targetList.size(); i++) {
                                builder.append("\"");
                                String item = propertiesHelper.stringNotNull(method.invoke(targetList.get(i)), "Unexpected Properties(2),index: " + i + ".");
                                builder.append(item);
                                builder.append("\"");
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
                                Number item = propertiesHelper.numberFormatNotNull(method.invoke(targetList.get(i)), itemType, "Unexpected Properties(2),index: " + i + ".");
                                builder.append(item);
                                builder.append(",");
                            }
                            break;
                        case BOOLEAN:
                            for (int i = 0; i < targetList.size(); i++) {
                                Boolean item = propertiesHelper.booleanFormat(method.invoke(targetList.get(i)), "Unexpected Properties(2),index: " + i + ".");
                                builder.append(item);
                                builder.append(",");
                            }
                        default:
                            throw new PropertiesException_Runtime("Unexpected ColumnType.");
                    }
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
            return builder.toString();
        } catch (NoSuchMethodException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Fail to execute " + methodName + "()", e);
        } catch (IllegalAccessException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Fail to execute " + methodName + "()", e);
        } catch (InvocationTargetException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Fail to execute " + methodName + "()", e);
        }
    }

    @Override
    public <T> ArrayList<Integer> getListGroupIndex(List<T> targetList, String methodName, Class<T> tClass) {
        ArrayList<Integer> result = new ArrayList();
        result.add(0);
        if (targetList.size() > 0) {
            try {
                Method method = tClass.getDeclaredMethod(methodName);
                String previousEqVal = method.invoke(targetList.get(0)).toString();
                for (int i = 0; i < targetList.size(); i++) {
                    T temp = targetList.get(i);
                    String currentEqVal = method.invoke(temp).toString();
                    if (previousEqVal.equals(currentEqVal)) {
                        continue;
                    } else {
                        previousEqVal = currentEqVal;
                        result.add(i);
                    }
                }
            } catch (NoSuchMethodException e) {
                throw new Universal_500_X_Exception_Runtime(555F, methodName + "() was not found.", e);
            } catch (IllegalAccessException e) {
                throw new Universal_500_X_Exception_Runtime(555F, "Fail to execute " + methodName + "()", e);
            } catch (InvocationTargetException e) {
                throw new Universal_500_X_Exception_Runtime(555F, "Fail to execute " + methodName + "()", e);
            }
        }
        return result;
    }

    @Override
    public <T> ArrayList<List<T>> groupListByGroupIndex(List<Integer> indexInfo, ArrayList<T> targetList) {
        ArrayList<List<T>> result = new ArrayList<>();
        Integer currentIndex;
        Integer nextIndex;
        for (int i = 0; i < indexInfo.size(); i++) {
            currentIndex = indexInfo.get(i);
            if (i + 1 < indexInfo.size()) {
                nextIndex = indexInfo.get(i + 1);
            } else {
                nextIndex = targetList.size();
            }
            List<T> temp = targetList.subList(currentIndex, nextIndex);
            result.add(temp);
        }
        return result;
    }

    @Override
    public ArrayList<String> filterStringListNotEmpty(List<String> targetList, String name, Integer minLength, Integer maxLength) {
        if (targetList == null) {
            throw new PropertiesException_Runtime("[" + name + "] can't be null.");
        }
        ArrayList<String> result = new ArrayList(targetList.size());
        for (String temp : targetList) {
            if (!"".equals(temp.trim())) {
                if (temp.length() < minLength) {
                    throw new PropertiesException_Runtime("Length of [" + temp + "] shouldn't less than " + minLength + ".");
                }
                if (temp.length() > maxLength) {
                    throw new PropertiesException_Runtime("Length of [" + temp + "] shouldn't more than " + maxLength + ".");
                }
                result.add(temp);
            }
        }
        if (result.size() < 1) {
            throw new PropertiesException_Runtime("Effective item of [" + name + "] was not found.");
        }
        return result;
    }

    @Override
    public SortedTypeEnum checkSorttedType(List<? extends BaseSortItem> targetList) {
        SortedTypeEnum result = null;
        BaseSortItem currentItem, nextItem;
        currentItem = targetList.get(0);
        CompareRelativeResultEnum compareRelativeResult = null, compareRelativeResultTemp;
        for (int i = 1; i < targetList.size(); i++) {
            nextItem = targetList.get(i);
            compareRelativeResultTemp = currentItem.toCompareAnother(currentItem, nextItem);
            if (compareRelativeResult == null) {
                compareRelativeResult = compareRelativeResultTemp;
                result = resetSortedTypeResult(compareRelativeResult);
            } else {
                if (CompareRelativeResultEnum.EQUAL.equals(compareRelativeResult)) {
                    compareRelativeResult = compareRelativeResultTemp;
                    result = resetSortedTypeResult(compareRelativeResult);
                } else {
                    if (!compareRelativeResult.equals(compareRelativeResultTemp)) {
                        result = SortedTypeEnum.DEFAULT;
                        break;
                    }
                }
            }
            // 一轮校验完毕，当前的下一个元素替换为当前元素，并开始下一轮
            currentItem = nextItem;
        }
        return result;
    }

    private SortedTypeEnum resetSortedTypeResult(CompareRelativeResultEnum currentCompareRelativeResult) {
        SortedTypeEnum result;
        switch (currentCompareRelativeResult) {
            case BIGGER:
                result = SortedTypeEnum.DESC;
                break;
            case SMALLER:
                result = SortedTypeEnum.ASC;
                break;
            default:
                result = SortedTypeEnum.DEFAULT;
        }
        return result;
    }
}
