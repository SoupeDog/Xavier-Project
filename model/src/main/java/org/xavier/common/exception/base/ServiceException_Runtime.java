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
public class ServiceException_Runtime extends RuntimeException {
    /**
     * 自定义状态码 默认500d
     */
    private Double stateCode = 500d;
    /**
     * 存储的额外信息
     */
    private String extraInfo = "Initial value.";

    public ServiceException_Runtime() {
        super();
    }

    public ServiceException_Runtime(String msg) {
        super(msg);
    }

    public ServiceException_Runtime(Double stateCode, String msg) {
        super(msg);
        this.stateCode = stateCode;
    }

    public ServiceException_Runtime(Double stateCode, String msg, Throwable cause) {
        super(msg, cause);
        this.stateCode = stateCode;
    }

    public ServiceException_Runtime(Double stateCode, String msg, String extraInfo) {
        super(msg);
        this.stateCode = stateCode;
        this.extraInfo = extraInfo;
    }

    public ServiceException_Runtime(Double stateCode, String msg, String extraInfo, Throwable cause) {
        super(msg, cause);
        this.stateCode = stateCode;
        this.extraInfo = extraInfo;
    }

    public Double getStateCode() {
        return stateCode;
    }

    public void setStateCode(Double stateCode) {
        this.stateCode = stateCode;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
