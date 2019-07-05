package org.xavier.common.exception;


import org.xavier.common.exception.base.RequestRuntimeException;

/**
 * 描述信息：<br/>
 * 403 通用型 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.06.27.
 * @since Jdk 1.8
 */
public class Universal403RuntimeException extends RequestRuntimeException {
    public Universal403RuntimeException() {
        super();
        setStateCode(403);
    }

    public Universal403RuntimeException(String msg) {
        super(msg);
        setStateCode(403);
    }

    public Universal403RuntimeException(Number stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal403RuntimeException(Number stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal403RuntimeException(Number stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal403RuntimeException(Number stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }
}