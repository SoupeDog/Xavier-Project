package org.xavier.common.exception;

import org.xavier.common.exception.base.ServiceException_Runtime;

/**
 * 描述信息：<br/>
 * 通用型 500 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class Universal_500_X_Exception_Runtime extends ServiceException_Runtime {
    public Universal_500_X_Exception_Runtime() {
        super();
    }

    public Universal_500_X_Exception_Runtime(String msg) {
        super(msg);
    }

    public Universal_500_X_Exception_Runtime(Double stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal_500_X_Exception_Runtime(Double stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal_500_X_Exception_Runtime(Double stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal_500_X_Exception_Runtime(Double stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }

}
