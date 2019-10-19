package org.xavier.common.util.base;

import org.xavier.common.exception.PropertiesRuntimeException;
import org.xavier.common.util.SqlHelper;
import org.xavier.common.util.bo.ColumnInfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述信息：<br/>
 * 数据库工具类主基类
 *
 * @author Xavier
 * @version 1.0
 * @date 19-10-20
 * @since Jdk 1.8
 */
public abstract class BaseSqlHelper implements SqlHelper {

    @Override
    public HashMap<String, Object> createFinalUpdateData(Map target, Collection<ColumnInfo> checkInfoCollection) {
        if (target == null) {
            throw new PropertiesRuntimeException("Target of createFinalUpdateData can't be null.");
        }
        Object targetTemp;
        HashMap<String, Object> result = new HashMap(checkInfoCollection.size());
        for (ColumnInfo columnInfo : checkInfoCollection) {
            targetTemp = target.get(columnInfo.getColumnName());
            result.put(columnInfo.getColumnAlias(), columnInfo.checkAndGetColumn(targetTemp));
        }
        return result;
    }

    @Override
    public HashMap<String, Object> createFinalUpdateDataWithDefaultTsColumn(Long updateTs, Map target, Collection<ColumnInfo> checkInfoCollection) {
        HashMap<String, Object> result = createFinalUpdateData(target, checkInfoCollection);
        result.put("lastUpdateTs", updateTs);
        return result;
    }
}