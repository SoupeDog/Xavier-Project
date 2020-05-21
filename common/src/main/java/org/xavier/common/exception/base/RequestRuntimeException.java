package org.xavier.common.exception.base;

/**
 * 描述信息：<br/>
 * 请求方引起的异常 RuntimeException
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class RequestRuntimeException extends RuntimeException {
    /**
     * 是否启用抑制功能 默认否
     */
    protected static boolean DEFAULT_ENABLE_SUPPRESSION = false;
    /**
     * 是否追溯堆栈 默认追溯
     */
    protected static boolean DEFAULT_WRITABLE_STACKTRACE = true;
    /**
     * 自定义状态码 默认400
     */
    private Number stateCode = 400;
    /**
     * 存储的额外信息
     */
    private String extraInfo = "Initial value.";

    public RequestRuntimeException() {
        super();
    }

    public RequestRuntimeException(String msg) {
        super(msg, null, DEFAULT_ENABLE_SUPPRESSION, DEFAULT_WRITABLE_STACKTRACE);
    }

    public RequestRuntimeException(Number stateCode, String msg) {
        super(msg, null, DEFAULT_ENABLE_SUPPRESSION, DEFAULT_WRITABLE_STACKTRACE);
        this.stateCode = stateCode;
    }

    public RequestRuntimeException(Number stateCode, String msg, Throwable cause) {
        super(msg, cause, DEFAULT_ENABLE_SUPPRESSION, DEFAULT_WRITABLE_STACKTRACE);
        this.stateCode = stateCode;
    }

    public RequestRuntimeException(Number stateCode, String msg, String extraInfo) {
        super(msg, null, DEFAULT_ENABLE_SUPPRESSION, DEFAULT_WRITABLE_STACKTRACE);
        this.stateCode = stateCode;
        this.extraInfo = extraInfo;
    }

    public RequestRuntimeException(Number stateCode, String msg, String extraInfo, Throwable cause) {
        super(msg, cause, DEFAULT_ENABLE_SUPPRESSION, DEFAULT_WRITABLE_STACKTRACE);
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