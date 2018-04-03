package org.xavier.web.limiter.api;

import org.springframework.http.HttpMethod;

/**
 * 描述信息：<br/>
 * 字符串式接口描述
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public class ApiInfo_Default extends ApiInfo {
    /**
     * 接口请求路径
     */
    private String path;

    /**
     * 请求类型
     */
    private HttpMethod httpMethod;
}
