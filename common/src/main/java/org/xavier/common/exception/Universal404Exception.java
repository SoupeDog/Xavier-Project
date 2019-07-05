package org.xavier.common.exception;

import org.xavier.common.exception.base.RequestException;

/**
 * 描述信息：<br/>
 * 通用型 404 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class Universal404Exception extends RequestException {
    public Universal404Exception() {
        super();
        setStateCode(404);
    }

    public Universal404Exception(String msg) {
        super(msg);
        setStateCode(404);
    }

    public Universal404Exception(Number stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal404Exception(Number stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal404Exception(Number stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal404Exception(Number stateCode, String msg, Throwable cause, String extraInfo) {
        super(stateCode, msg, extraInfo, cause);
    }
}