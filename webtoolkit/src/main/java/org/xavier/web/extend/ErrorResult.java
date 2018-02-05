package org.xavier.web.extend;

/**
 * 描述信息：<br/>
 * 错误信息对象
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/1/14
 * @since Jdk 1.8
 */
public class ErrorResult {

    /**
     * 自定义状态码
     */
    private Float errorCode;
    /**
     * 错误信息
     */
    private String msg;

    public ErrorResult() {
    }

    public ErrorResult(Float errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public Float getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Float errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
