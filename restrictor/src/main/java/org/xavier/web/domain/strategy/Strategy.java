package org.xavier.web.domain.strategy;

import org.springframework.http.HttpMethod;

/**
 * 描述信息：<br/>
 * 策略基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public class Strategy {
    protected HttpMethod httpMethod;
    protected String path;

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
