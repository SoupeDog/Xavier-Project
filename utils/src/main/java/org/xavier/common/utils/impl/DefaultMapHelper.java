package org.xavier.common.utils.impl;

import org.xavier.common.utils.base.BaseMapHelper;

/**
 * 描述信息：<br/>
 * 不做任何额外处理的基本 MapHelper
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.01.09
 * @since Jdk 1.8
 */
public class DefaultMapHelper extends BaseMapHelper{
    @Override
    protected <T> T hook_getFirstItem(T item) {
        return item;
    }
}
