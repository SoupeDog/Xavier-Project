package org.xavier.common.utils.impl;

import org.xavier.common.utils.base.BaseJsonHelper;
import org.xavier.common.utils.enums.ColumnType;

/**
 * 描述信息：<br/>
 * 不做任何额外处理的基本 JsonHelper
 * @author Xavier
 * @version 1.0
 * @date 2017.11.28
 * @since Jdk 1.8
 */
public class DefaultJsonHelper extends BaseJsonHelper {
    @Override
    protected void hookGetValueByKey(ColumnType resultType, Object target) {

    }
}
