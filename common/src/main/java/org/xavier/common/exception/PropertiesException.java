package org.xavier.common.exception;

import org.xavier.common.exception.base.RequestException;

/**
 * 描述信息：<br/>
 * 参数异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class PropertiesException extends RequestException {
    public PropertiesException() {
        super();
    }

    public PropertiesException(String msg) {
        super(msg);
    }

    public PropertiesException(String msg, Throwable cause) {
        super(400, msg, cause);
    }
}