package org.xavier.common.utils.base;

import org.xavier.common.exception.PropertiesException_Runtime;
import org.xavier.common.utils.MapHelper;

import java.util.*;

/**
 * 描述信息：<br/>
 * Map 工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.01.09
 * @since Jdk 1.8
 */
public abstract class BaseMapHelper implements MapHelper {
    /**
     * 取到元素时触发，可能为 null
     *
     * @param item 假定的第一个元素
     */
    protected abstract <T> T hook_getFirstItem(T item);

    @Override
    public void mapNotEmpty(Map map, String targetDescription) {
        if (map == null || map.size() < 1) {
            throw new PropertiesException_Runtime("[" + targetDescription + "] can't be null,and it can't be empty.");
        }
    }

    @Override
    public <K, V> V getFirstItem(Map<K, V> targetMap, Class<K> keyClass, Class<V> valueClass) {
        V result = null;
        for (V temp : targetMap.values()) {
            result = temp;
            break;
        }
        result = hook_getFirstItem(result);
        return result;
    }

    @Override
    public <K, V> TreeMap<K, V> sortMapByKey(Map<K, V> targetMap, Comparator<K> comparator, Class<K> keyClass, Class<V> valueClass) {
        if (targetMap.size() < 1) {
            return null;
        }
        TreeMap<K, V> result = new TreeMap(comparator);
        for (Map.Entry<K, V> entry : targetMap.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    @Override
    public <K, V> LinkedHashMap<K, V> sortMapByValue(Map<K, V> targetMap, Comparator<Map.Entry<K, V>> comparator, Class<K> keyClass, Class<V> valueClass) {
        if (targetMap.size() < 1) {
            return null;
        }
        ArrayList<Map.Entry<K, V>> orderList = new ArrayList(targetMap.entrySet());
        orderList.sort(comparator);
        LinkedHashMap<K, V> result = new LinkedHashMap();
        for (Map.Entry<K, V> entry : orderList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
