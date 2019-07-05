package org.xavier.common.exception.base;

/**
 * 描述信息：<br/>
 * 服务端引起的异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class ServiceRuntimeException extends RuntimeException {
    /**
     * 自定义状态码 默认500
     */
    private Number stateCode = 500;
    /**
     * 存储的额外信息
     */
    private String extraInfo = "Initial value.";

    public ServiceRuntimeException() {
        super();
    }

    public ServiceRuntimeException(String msg) {
        super(msg);
    }

    public ServiceRuntimeException(Number stateCode, String msg) {
        super(msg);
        this.stateCode = stateCode;
    }

    public ServiceRuntimeException(Number stateCode, String msg, Throwable cause) {
        super(msg, cause);
        this.stateCode = stateCode;
    }

    public ServiceRuntimeException(Number stateCode, String msg, String extraInfo) {
        super(msg);
        this.stateCode = stateCode;
        this.extraInfo = extraInfo;
    }

    public ServiceRuntimeException(Number stateCode, String msg, String extraInfo, Throwable cause) {
        super(msg, cause);
        this.stateCode = stateCode;
        this.extraInfo = extraInfo;
    }

    public Number getStateCode() {
        return stateCode;
    }

    public void setStateCode(Number stateCode) {
        this.stateCode = stateCode;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}