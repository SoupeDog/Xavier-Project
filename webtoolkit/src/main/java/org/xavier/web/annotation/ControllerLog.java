package org.xavier.web.annotation;

import org.springframework.http.HttpMethod;

import java.util.LinkedHashMap;

/**
 * 描述信息：<br/>
 * 日志对象
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.07.06
 * @since Jdk 1.8
 */
public abstract class ControllerLog {
    public String path;
    public HttpMethod httpMethod;
    public Long startTs;
    public Long endTs;
    public Integer httpStatus;
    public LinkedHashMap requestProperties;
    public Object responseProperties;

    public ControllerLog() {
    }

    public abstract void initRequest(String[] paths, String[] ignoreProperties, String[] propertiesNames, Object[] propertiesValue);

    public abstract void initResponse(Object responseOBJ);
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Long getStartTs() {
        return startTs;
    }

    public void setStartTs(Long startTs) {
        this.startTs = startTs;
    }

    public Long getEndTs() {
        return endTs;
    }

    public void setEndTs(Long endTs) {
        this.endTs = endTs;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public LinkedHashMap getRequestProperties() {
        return requestProperties;
    }

    public void setRequestProperties(LinkedHashMap requestProperties) {
        this.requestProperties = requestProperties;
    }

    public Object getResponseProperties() {
        return responseProperties;
    }

    public void setResponseProperties(Object responseProperties) {
        this.responseProperties = responseProperties;
    }
}
