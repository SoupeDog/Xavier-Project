package org.xavier.common.util.base;

import org.xavier.common.exception.PropertiesRuntimeException;
import org.xavier.common.util.CollectionHelper;
import org.xavier.common.util.PropertiesHelper;
import org.xavier.common.util.UtilsCreator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
    public <T, R> ArrayList<R> filterCollectionNotEmpty(Collection<T> target, String msg, Class<T> tClass, Class<R> rClass, Function<T, R> function) {
        if (target == null) {
            throw new PropertiesRuntimeException(msg);
        }
        Iterator iterator = target.iterator();
        ArrayList<R> result = new ArrayList(target.size());
        while (iterator.hasNext()) {
            R item = function.apply((T) iterator.next());
            if (item != null && !propertiesHelper.stringIsNullOrEmpty(item.toString())) {
                result.add(item);
            }
        }
        return result;
    }
}