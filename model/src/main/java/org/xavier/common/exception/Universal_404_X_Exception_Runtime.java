package org.xavier.common.exception;

import org.xavier.common.exception.base.RequestException_Runtime;

/**
 * 描述信息：<br/>
 * 通用型 404 异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class Universal_404_X_Exception_Runtime extends RequestException_Runtime {
    public Universal_404_X_Exception_Runtime() {
        super();
        setStateCode(404F);
    }

    public Universal_404_X_Exception_Runtime(String msg) {
        super(msg);
        setStateCode(404F);
    }

    public Universal_404_X_Exception_Runtime(Float stateCode, String msg) {
        super(stateCode, msg);
    }

    public Universal_404_X_Exception_Runtime(Float stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public Universal_404_X_Exception_Runtime(Float stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public Universal_404_X_Exception_Runtime(Float stateCode, String msg, Throwable cause, String extraInfo) {
        super(stateCode, msg, extraInfo, cause);
    }

}
