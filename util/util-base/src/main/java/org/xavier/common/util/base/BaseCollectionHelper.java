package org.xavier.common.util.base;

import org.xavier.common.exception.PropertiesRuntimeException;
import org.xavier.common.util.CollectionHelper;
import org.xavier.common.util.PropertiesHelper;
import org.xavier.common.util.UtilsCreator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 19-10-19
 * @since Jdk 1.8
 */
public abstract class BaseCollectionHelper implements CollectionHelper {

    protected PropertiesHelper propertiesHelper;

    public BaseCollectionHelper() {
        propertiesHelper = UtilsCreator.getDefaultPropertiesHelperInstance();
    }

    @Override
    public <T, R> ArrayList<R> filterCollectionNotEmptyAsArrayList(Boolean isUnique, Collection<T> target, String msg, Function<T, R> function) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        ArrayList<R> result = new ArrayList(target.size());
        for (T collectionItem : target) {
            if (collectionItem != null) {
                R resultItem = function.apply(collectionItem);
                if (resultItem != null && !propertiesHelper.stringIsNullOrEmpty(resultItem.toString())) {
                    if (isUnique) {
                        if (!result.contains(resultItem)) {
                            result.add(resultItem);
                        }
                    } else {
                        result.add(resultItem);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public <T, K, V> HashMap<K, V> filterCollectionNotEmptyAsHashMap(Collection<T> target, String msg, Function<T, K> kFunction, Function<T, V> vFunction) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        HashMap<K, V> result = new HashMap(target.size());
        for (T collectionItem : target) {
            if (collectionItem != null) {
                K key = kFunction.apply(collectionItem);
                V value = vFunction.apply(collectionItem);
                result.put(key, value);
            }
        }
        return result;
    }

    @Override
    public <T, K, V> TreeMap<K, V> filterCollectionNotEmptyAsTreeMap(Collection<T> target, String msg, Function<T, K> kFunction, Function<T, V> vFunction) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        TreeMap<K, V> result = new TreeMap();
        for (T collectionItem : target) {
            if (collectionItem != null) {
                K key = kFunction.apply(collectionItem);
                V value = vFunction.apply(collectionItem);
                if (key != null) {
                    result.put(key, value);
                }
            }
        }
        return result;
    }

    @Override
    public <T, K, V> ConcurrentHashMap<K, V> filterCollectionNotEmptyAsConcurrentHashMap(Collection<T> target, String msg, Function<T, K> kFunction, Function<T, V> vFunction) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        ConcurrentHashMap<K, V> result = new ConcurrentHashMap(target.size());
        for (T collectionItem : target) {
            if (collectionItem != null) {
                K key = kFunction.apply(collectionItem);
                V value = vFunction.apply(collectionItem);
                if (key != null && value != null) {
                    result.put(key, value);
                }
            }
        }
        return result;
    }

    public PropertiesHelper getPropertiesHelper() {
        return propertiesHelper;
    }

    public void setPropertiesHelper(PropertiesHelper propertiesHelper) {
        this.propertiesHelper = propertiesHelper;
    }
}