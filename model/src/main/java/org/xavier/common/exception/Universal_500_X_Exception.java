package org.xavier.common.exception;

import org.xavier.common.exception.base.ServiceException;

/**
 * 描述信息：<br/>
 * 通用型 500 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class Universal_500_X_Exception extends ServiceException {
    public Universal_500_X_Exception() {
        super();
    }

    public Universal_500_X_Exception(String msg) {
        super(msg);
    }

    public Universal_500_X_Exception(Float stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal_500_X_Exception(Float stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal_500_X_Exception(Float stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal_500_X_Exception(Float stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }

}
