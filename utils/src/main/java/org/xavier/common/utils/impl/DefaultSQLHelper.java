package org.xavier.common.utils.impl;

import org.xavier.common.utils.base.BaseSQLHelper;

/**
 * 描述信息：<br/>
 * 不做任何额外处理的基本 SQLHelper
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.22
 * @since Jdk 1.8
 */
public class DefaultSQLHelper extends BaseSQLHelper {

    @Override
    protected String hookArray_String(String item) {
        return item;
    }

    @Override
    protected Number hookArray_Number(Number item) {
        return item;
    }

    @Override
    protected void hookArray_Boolean(Boolean item) {

    }

    @Override
    protected String hookList_String(String item) {
        return item;
    }

    @Override
    protected Number hookList_Number(Number item) {
        return item;
    }

    @Override
    protected void hookList_Boolean(Boolean item) {

    }

    @Override
    protected String hookMap_String(String item) {
        return item;
    }

    @Override
    protected Number hookMap_Number(Number item) {
        return item;
    }

    @Override
    protected void hookMap_Boolean(Boolean item) {

    }
}
