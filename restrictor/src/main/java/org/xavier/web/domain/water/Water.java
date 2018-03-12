package org.xavier.web.domain.water;

import org.springframework.http.HttpMethod;

/**
 * 描述信息：<br/>
 * 单个流量信息
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.09
 * @since Jdk 1.8
 */
public class Water {
    /**
     * 请求路径信息
     */
    protected String path;
    /**
     * 请求类型信息
     */
    protected HttpMethod httpMethod;

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
}
