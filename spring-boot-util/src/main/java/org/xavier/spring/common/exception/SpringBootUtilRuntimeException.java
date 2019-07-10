package org.xavier.spring.common.exception;

import org.xavier.common.exception.base.ServiceRuntimeException;

/**
 * 描述信息：<br/>
 * 工具类异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/7/6
 * @since Jdk 1.8
 */
public class SpringBootUtilRuntimeException extends ServiceRuntimeException {
    public SpringBootUtilRuntimeException() {
        super();
        setStateCode(551);
    }

    public SpringBootUtilRuntimeException(String msg) {
        super(msg);
        setStateCode(551);
    }

    public SpringBootUtilRuntimeException(Number stateCode, String msg) {
        super(stateCode, msg);
    }

    public SpringBootUtilRuntimeException(Number stateCode, String msg, Throwable cause) {
        super(stateCode, msg, cause);
    }

    public SpringBootUtilRuntimeException(Number stateCode, String msg, String extraInfo) {
        super(stateCode, msg, extraInfo);
    }

    public SpringBootUtilRuntimeException(Number stateCode, String msg, String extraInfo, Throwable cause) {
        super(stateCode, msg, extraInfo, cause);
    }
}