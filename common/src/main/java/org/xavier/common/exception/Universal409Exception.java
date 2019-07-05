package org.xavier.common.exception;


import org.xavier.common.exception.base.RequestException;

/**
 * 描述信息：<br/>
 * 409 通用型 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.06.16.
 * @since Jdk 1.8
 */
public class Universal409Exception extends RequestException {
    public Universal409Exception() {
        super();
        setStateCode(409);
    }

    public Universal409Exception(String msg) {
        super(msg);
        setStateCode(409);
    }

    public Universal409Exception(Number stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal409Exception(Number stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal409Exception(Number stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal409Exception(Number stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }
}