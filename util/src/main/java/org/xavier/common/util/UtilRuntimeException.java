package org.xavier.common.util;

import org.xavier.common.exception.base.ServiceRuntimeException;

/**
 * 描述信息：<br/>
 * 工具类异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/7/6
 * @since Jdk 1.8
 */
public class UtilRuntimeException extends ServiceRuntimeException {
    public UtilRuntimeException() {
        super();
        setStateCode(550);
    }

    public UtilRuntimeException(String msg) {
        super(msg);
        setStateCode(550);
    }

    public UtilRuntimeException(Number stateCode, String msg) {
        super(stateCode, msg);
    }

    public UtilRuntimeException(Number stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public UtilRuntimeException(Number stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public UtilRuntimeException(Number stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }
}