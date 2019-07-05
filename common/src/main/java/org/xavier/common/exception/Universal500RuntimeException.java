package org.xavier.common.exception;

import org.xavier.common.exception.base.ServiceRuntimeException;

/**
 * 描述信息：<br/>
 * 通用型 500 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class Universal500RuntimeException extends ServiceRuntimeException {
    public Universal500RuntimeException() {
        super();
    }

    public Universal500RuntimeException(String msg) {
        super(msg);
    }

    public Universal500RuntimeException(Number stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal500RuntimeException(Number stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal500RuntimeException(Number stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal500RuntimeException(Number stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }
}