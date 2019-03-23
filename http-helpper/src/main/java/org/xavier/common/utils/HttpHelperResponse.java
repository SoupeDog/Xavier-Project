package org.xavier.common.utils;


import org.springframework.http.HttpStatus;

import java.util.Optional;

/**
 * 描述信息：<br/>
 * http 请求结果
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/23
 * @since Jdk 1.8
 */
public class HttpHelperResponse<T> {
    public Optional<T> data = Optional.empty();
    public HttpStatus httpStatus;

    /**
     * 请求结果是否非 OK(200, "OK"),
     */
    public Boolean isFail() {
        return httpStatus == null || !HttpStatus.OK.equals(httpStatus);
    }

    /**
     * 请求结果是否为 OK(200, "OK"),
     */
    public Boolean isSuccess() {
        return httpStatus != null && HttpStatus.OK.equals(httpStatus);
    }

    public T getData() {
        return data.isPresent() ? data.get() : null;
    }

    public void setData(Optional<T> data) {
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}