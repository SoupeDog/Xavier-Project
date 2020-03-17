package org.xavier.common.util.impl;

import org.xavier.common.util.base.BasePropertiesHelper;

import java.math.BigDecimal;

/**
 * 描述信息：<br/>
 * 不做任何额外处理的基本 PropertiesHelper
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.11.20
 * @since Jdk 1.8
 */
public class DefaultPropertiesHelper extends BasePropertiesHelper {

    @Override
    protected String hookString(String target) {
        return target;
    }

    @Override
    protected Number hookNumber(Number target) {
        return target;
    }

    @Override
    protected Byte hookByte(Byte target) {
        return target;
    }

    @Override
    protected Short hookShort(Short target) {
        return target;
    }

    @Override
    protected Integer hookInteger(Integer target) {
        return target;
    }

    @Override
    protected Long hookLong(Long target) {
        return target;
    }

    @Override
    protected Float hookFloat(Float target) {
        return target;
    }

    @Override
    protected Double hookDouble(Double target) {
        return target;
    }

    @Override
    protected BigDecimal hookBigDecimal(BigDecimal target) {
        return target;
    }

    @Override
    protected Boolean hookBoolean(Boolean target) {
        return target;
    }

    @Override
    protected String hookFilling(String target) {
        return target;
    }
}