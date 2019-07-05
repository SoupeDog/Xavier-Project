package org.xavier.common.exception;

import org.xavier.common.exception.base.RequestException;

/**
 * 描述信息：<br/>
 * 通用型 400 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class Universal400Exception extends RequestException {
    public Universal400Exception() {
        super();
    }

    public Universal400Exception(String msg) {
        super(msg);
    }

    public Universal400Exception(Number stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal400Exception(Number stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal400Exception(Number stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal400Exception(Number stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }
}