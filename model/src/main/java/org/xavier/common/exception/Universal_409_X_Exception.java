package org.xavier.common.exception;


import org.xavier.common.exception.base.RequestException;

/**
 * 描述信息：<br/>
 * 409.XX 通用型 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.06.16.
 * @since Jdk 1.8
 */
public class Universal_409_X_Exception extends RequestException {
    public Universal_409_X_Exception() {
        super();
        setStateCode(409d);
    }

    public Universal_409_X_Exception(String msg) {
        super(msg);
        setStateCode(409d);
    }

    public Universal_409_X_Exception(Double stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal_409_X_Exception(Double stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal_409_X_Exception(Double stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal_409_X_Exception(Double stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }
}
