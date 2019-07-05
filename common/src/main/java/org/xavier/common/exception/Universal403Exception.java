package org.xavier.common.exception;

import org.xavier.common.exception.base.RequestException;

/**
 * 描述信息：<br/>
 * 403 通用型 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.06.27.
 * @since Jdk 1.8
 */
public class Universal403Exception extends RequestException {
    public Universal403Exception() {
        super();
        setStateCode(403);
    }

    public Universal403Exception(String msg) {
        super(msg);
        setStateCode(403);
    }

    public Universal403Exception(Number stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal403Exception(Number stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal403Exception(Number stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal403Exception(Number stateCode, String msg, Throwable cause, String extraInfo) {
        super(stateCode, msg, extraInfo, cause);
    }
}