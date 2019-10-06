package org.xavier.common.util.http.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

/**
 * 描述信息：<br/>
 * 请求错误日志 对象
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/23
 * @since Jdk 1.8
 */
public class RequestLogEntity {
    private String url;
    private HttpMethod httpMethod;
    private HttpHeaders httpHeaders;
    private MediaType mediaType;
    private HttpStatus httpStatus;
    private String msg;
    private Long ts;

    public RequestLogEntity(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, MediaType mediaType, HttpStatus httpStatus, String msg, Long ts) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.httpHeaders = httpHeaders;
        this.mediaType = mediaType;
        this.httpStatus = httpStatus;
        this.msg = msg;
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "{" +
                "\"url\":\"" + url + "\"," +
                "\"httpMethod\":\"" + httpMethod + "\"," +
                "\"httpHeaders\":\"" + httpHeaders.toString().replace("\"", "\\\"") + "\"," +
                "\"mediaType\":\"" + mediaType + "\"," +
                "\"httpStatus\":\"" + httpStatus + "\"," +
                "\"msg\":\"" + msg + "\"," +
                "\"ts\":" + ts +
                "}";
    }
}
