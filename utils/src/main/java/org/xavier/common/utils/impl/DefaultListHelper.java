package org.xavier.common.utils.impl;

import org.xavier.common.utils.base.BaseListHelper;
import org.xavier.common.utils.PropertiesHelper;

/**
 * 描述信息：<br/>
 * 不做任何额外处理的基本 ListHelper
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.22
 * @since Jdk 1.8
 */
public class DefaultListHelper extends BaseListHelper {
    public DefaultListHelper() {
        super();
    }

    public DefaultListHelper(PropertiesHelper propertiesHelper) {
        super(propertiesHelper);
    }

    @Override
    protected void hook_Serialize_String(String item) {

    }

    @Override
    protected void hook_Serialize_Number(Number item) {

    }

    @Override
    protected void hook_Serialize_Boolean(Boolean item) {

    }
}
