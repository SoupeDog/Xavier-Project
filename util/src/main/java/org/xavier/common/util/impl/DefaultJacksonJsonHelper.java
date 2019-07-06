package org.xavier.common.util.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.xavier.common.enums.ColumnType;
import org.xavier.common.util.base.BaseJacksonJsonHelper;

/**
 * 描述信息：<br/>
 * 基于 Jackson 不做任何额外处理的基本 JsonHelper
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.28
 * @since Jdk 1.8
 */
public class DefaultJacksonJsonHelper extends BaseJacksonJsonHelper {
    public DefaultJacksonJsonHelper() {
    }

    public DefaultJacksonJsonHelper(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    protected <T> T hookGetValueByKey(ColumnType resultType, T target, Class<T> tClass) {
        return target;
    }

    @Override
    public ObjectMapper getDependence() {
        return mapper;
    }
}
