package org.xavier.common.exception;

import org.xavier.common.exception.base.RequestRuntimeException;

/**
 * 描述信息：<br/>
 * 参数异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class PropertiesRuntimeException extends RequestRuntimeException {
    public PropertiesRuntimeException() {
        super();
    }

    public PropertiesRuntimeException(String msg) {
        super(msg);
    }

    public PropertiesRuntimeException(String msg, Throwable cause) {
        super(400, msg, cause);
    }
}