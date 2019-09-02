package org.xavier.webtoolkit.domain;

/**
 * 描述信息：<br/>
 * 默认错误信息对象
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/9/2
 * @since Jdk 1.8
 */
public class ErrorResult {
    /**
     * 自定义状态码
     */
    private Number errorCode;
    /**
     * 错误信息
     */
    private String msg;

    public ErrorResult() {
    }

    public ErrorResult(Number errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public Number getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Number errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}