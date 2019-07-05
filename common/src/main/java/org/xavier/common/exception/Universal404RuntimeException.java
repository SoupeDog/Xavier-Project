package org.xavier.common.exception;

import org.xavier.common.exception.base.RequestRuntimeException;

/**
 * 描述信息：<br/>
 * 通用型 404 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class Universal404RuntimeException extends RequestRuntimeException {
    public Universal404RuntimeException() {
        super();
        setStateCode(404);
    }

    public Universal404RuntimeException(String msg) {
        super(msg);
        setStateCode(404);
    }

    public Universal404RuntimeException(Number stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal404RuntimeException(Number stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal404RuntimeException(Number stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal404RuntimeException(Number stateCode, String msg, Throwable cause, String extraInfo) {
        super(stateCode, msg, extraInfo, cause);
    }
}