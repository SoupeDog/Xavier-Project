package org.xavier.common.exception;


import org.xavier.common.exception.base.RequestException_Runtime;

/**
 * 描述信息：<br/>
 * 403.XX 通用型 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.06.27.
 * @since Jdk 1.8
 */
public class Universal_403_X_Exception_Runtime extends RequestException_Runtime {
    public Universal_403_X_Exception_Runtime() {
        super();
        setStateCode(403F);
    }

    public Universal_403_X_Exception_Runtime(String msg) {
        super(msg);
        setStateCode(403F);
    }

    public Universal_403_X_Exception_Runtime(Float stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal_403_X_Exception_Runtime(Float stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal_403_X_Exception_Runtime(Float stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal_403_X_Exception_Runtime(Float stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }
}
