package org.xavier.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * 描述信息：<br/>
 * Http 请求工具
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/23
 * @since Jdk 1.8
 */
public interface HttpHelpper {

    /**
     * 同步的 get 请求
     *
     * @param url    请求地址
     * @param tClass 目标反序列化类
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> get(String url, Class<T> tClass);

    /**
     * 同步的 get 请求
     *
     * @param url         请求地址
     * @param httpHeaders 请求头
     * @param tClass      目标反序列化类
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> get(String url, HttpHeaders httpHeaders, Class<T> tClass);

    /**
     * 同步的 get 请求
     *
     * @param url       请求地址
     * @param mediaType mediaType
     * @param tClass    目标反序列化类
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> get(String url, MediaType mediaType, Class<T> tClass);

    /**
     * 同步的 get 请求
     *
     * @param url         请求地址
     * @param httpHeaders 请求头
     * @param mediaType   mediaType
     * @param tClass      目标反序列化类
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> get(String url, HttpHeaders httpHeaders, MediaType mediaType, Class<T> tClass);

    /**
     * 同步的 get 请求
     *
     * @param url           请求地址
     * @param typeReference 目标反序列化泛型
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> get(String url, TypeReference<T> typeReference);

    /**
     * 同步的 get 请求
     *
     * @param url           请求地址
     * @param httpHeaders   请求头
     * @param typeReference 目标反序列化泛型
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> get(String url, HttpHeaders httpHeaders, TypeReference<T> typeReference);

    /**
     * 同步的 get 请求
     *
     * @param url           请求地址
     * @param mediaType     mediaType
     * @param typeReference 目标反序列化泛型
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> get(String url, MediaType mediaType, TypeReference<T> typeReference);

    /**
     * 同步的 get 请求
     *
     * @param url           请求地址
     * @param httpHeaders   请求头
     * @param mediaType     mediaType
     * @param typeReference 目标反序列化泛型
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> get(String url, HttpHeaders httpHeaders, MediaType mediaType, TypeReference<T> typeReference);

    /**
     * 同步的 post 请求
     *
     * @param url    请求地址
     * @param body   http body 体
     * @param tClass 目标反序列化类
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> post(String url, Object body, Class<T> tClass);

    /**
     * 同步的 post 请求
     *
     * @param url         请求地址
     * @param body        http body 体
     * @param httpHeaders 请求头
     * @param tClass      目标反序列化类
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> post(String url, Object body, HttpHeaders httpHeaders, Class<T> tClass);

    /**
     * 同步的 post 请求
     *
     * @param url       请求地址
     * @param body      http body 体
     * @param mediaType mediaType
     * @param tClass    目标反序列化类
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> post(String url, Object body, MediaType mediaType, Class<T> tClass);

    /**
     * 同步的 post 请求
     *
     * @param url         请求地址
     * @param body        http body 体
     * @param httpHeaders 请求头
     * @param mediaType   mediaType
     * @param tClass      目标反序列化类
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> post(String url, Object body, HttpHeaders httpHeaders, MediaType mediaType, Class<T> tClass);

    /**
     * 同步的 post 请求
     *
     * @param url           请求地址
     * @param body          http body 体
     * @param typeReference 目标反序列化泛型
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> post(String url, Object body, TypeReference<T> typeReference);

    /**
     * 同步的 post 请求
     *
     * @param url           请求地址
     * @param body          http body 体
     * @param httpHeaders   请求头
     * @param typeReference 目标反序列化泛型
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> post(String url, Object body, HttpHeaders httpHeaders, TypeReference<T> typeReference);

    /**
     * 同步的 post 请求
     *
     * @param url           请求地址
     * @param body          http body 体
     * @param mediaType     mediaType
     * @param typeReference 目标反序列化泛型
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> post(String url, Object body, MediaType mediaType, TypeReference<T> typeReference);

    /**
     * 同步的 post 请求
     *
     * @param url           请求地址
     * @param body          http body 体
     * @param httpHeaders   请求头
     * @param mediaType     mediaType
     * @param typeReference 目标反序列化泛型
     * @return http 请求结果
     */
    <T> HttpHelperResponse<T> post(String url, Object body, HttpHeaders httpHeaders, MediaType mediaType, TypeReference<T> typeReference);


}