package org.xavier.common.util.http.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.xavier.common.util.exception.UtilRuntimeException;

import java.io.IOException;
import java.util.Optional;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/23
 * @since Jdk 1.8
 */
public abstract class BaseHttpHelper implements HttpHelper {
    protected int maxRequestLogLength = 200;
    protected RestTemplate restTemplate;
    protected ObjectMapper mapper;

    /**
     * 初始化 ObjectMapper
     */
    public abstract void initObjectMapper();

    /**
     * 初始化 RestTemplate
     */
    public abstract void initRestTemplate();

    public BaseHttpHelper() {
        initObjectMapper();
        initRestTemplate();
    }

    public BaseHttpHelper(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.mapper = objectMapper;
    }

    private HttpHeaders creatHttpHeaders(HttpHeaders httpHeaders, MediaType mediaType) {
        HttpHeaders realHeaders = httpHeaders;
        if (realHeaders == null) {
            realHeaders = new HttpHeaders();
        }
        realHeaders.setContentType(mediaType);
        return realHeaders;
    }

    private <T> HttpHelperResponse<T> createStringHttpHelperResponse(ResponseEntity<T> responseEntity) {
        HttpHelperResponse<T> result;
        result = new HttpHelperResponse();
        result.setData(Optional.of(responseEntity.getBody()));
        result.setHttpStatus(responseEntity.getStatusCode());
        return result;
    }

    private <T> HttpHelperResponse<T> createHttpHelperResponse(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, MediaType mediaType, ResponseEntity<String> responseEntity, Class<T> tClass) {
        HttpHelperResponse<T> result = new HttpHelperResponse();
        String responseBody = responseEntity.getBody();
        try {
            T dataTemp = mapper.readValue(responseBody, tClass);
            result.setData(Optional.of(dataTemp));
            result.setHttpStatus(responseEntity.getStatusCode());
        } catch (IOException e) {
            serializeExceptionCallBack(url, httpMethod, httpHeaders, mediaType, responseEntity, e);
        }
        return result;
    }

    private <T> HttpHelperResponse<T> createHttpHelperResponse(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, MediaType mediaType, ResponseEntity<String> responseEntity, TypeReference<T> typeReference) {
        String responseBody = responseEntity.getBody();
        HttpHelperResponse<T> result = new HttpHelperResponse();
        try {
            T dataTemp = mapper.readValue(responseBody, typeReference);
            result.setHttpStatus(responseEntity.getStatusCode());
            result.setData(Optional.of(dataTemp));
        } catch (IOException e) {
            return serializeExceptionCallBack(url, httpMethod, httpHeaders, mediaType, null, e);
        }
        return result;
    }

    private <T> HttpHelperResponse<T> serializeExceptionCallBack(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, MediaType mediaType, ResponseEntity<String> responseEntity, IOException e) {
        String responseBody = responseEntity.getBody();
        RequestLogEntity requestLogEntity = new RequestLogEntity(url, httpMethod, httpHeaders, mediaType, responseEntity.getStatusCode(), "Serialize Exception", System.currentTimeMillis());
        if (responseBody.length() > maxRequestLogLength) {
            throw new UtilRuntimeException(550, "HttpHelper fail to deserialization :[" + responseBody.substring(0, 200) + " …… " + (responseBody.length() - 200) + "]" + requestLogEntity.toString(), e);
        } else {
            throw new UtilRuntimeException(550, "HttpHelper fail to deserialization :[" + responseBody + "]", e);
        }
    }

    @Override
    public <T> HttpHelperResponse<T> get(String url, Class<T> tClass) {
        return get(url, null, MediaType.APPLICATION_JSON, tClass);
    }

    @Override
    public <T> HttpHelperResponse<T> get(String url, HttpHeaders httpHeaders, Class<T> tClass) {
        return get(url, httpHeaders, MediaType.APPLICATION_JSON, tClass);
    }

    @Override
    public <T> HttpHelperResponse<T> get(String url, MediaType mediaType, Class<T> tClass) {
        return get(url, null, mediaType, tClass);
    }

    @Override
    public <T> HttpHelperResponse<T> get(String url, HttpHeaders httpHeaders, MediaType mediaType, Class<T> tClass) {
        HttpHeaders realHeaders = creatHttpHeaders(httpHeaders, mediaType);
        HttpEntity<String> entity = new HttpEntity(null, realHeaders);
        HttpHelperResponse<T> result;
        if (String.class.equals(tClass)) {
            ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, tClass);
            result = createStringHttpHelperResponse(responseEntity);
        } else {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            result = createHttpHelperResponse(url, HttpMethod.GET, realHeaders, mediaType, responseEntity, tClass);
        }
        return result;
    }


    @Override
    public <T> HttpHelperResponse<T> get(String url, TypeReference<T> typeReference) {
        return get(url, null, MediaType.APPLICATION_JSON, typeReference);
    }

    @Override
    public <T> HttpHelperResponse<T> get(String url, HttpHeaders httpHeaders, TypeReference<T> typeReference) {
        return get(url, httpHeaders, MediaType.APPLICATION_JSON, typeReference);
    }

    @Override
    public <T> HttpHelperResponse<T> get(String url, MediaType mediaType, TypeReference<T> typeReference) {
        return get(url, null, mediaType, typeReference);
    }

    @Override
    public <T> HttpHelperResponse<T> get(String url, HttpHeaders httpHeaders, MediaType mediaType, TypeReference<T> typeReference) {
        HttpHeaders realHeaders = creatHttpHeaders(httpHeaders, mediaType);
        HttpEntity<String> entity = new HttpEntity(null, realHeaders);
        HttpHelperResponse<T> result;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        result = createHttpHelperResponse(url, HttpMethod.GET, realHeaders, mediaType, responseEntity, typeReference);
        return result;
    }

    @Override
    public <T> HttpHelperResponse<T> post(String url, Object body, Class<T> tClass) {
        return post(url, body, null, MediaType.APPLICATION_JSON, tClass);
    }

    @Override
    public <T> HttpHelperResponse<T> post(String url, Object body, HttpHeaders httpHeaders, Class<T> tClass) {
        return post(url, body, httpHeaders, MediaType.APPLICATION_JSON, tClass);
    }

    @Override
    public <T> HttpHelperResponse<T> post(String url, Object body, MediaType mediaType, Class<T> tClass) {
        return post(url, body, null, mediaType, tClass);
    }

    @Override
    public <T> HttpHelperResponse<T> post(String url, Object body, HttpHeaders httpHeaders, MediaType mediaType, Class<T> tClass) {
        HttpHeaders realHeaders = creatHttpHeaders(httpHeaders, mediaType);
        HttpEntity<String> entity = new HttpEntity(body, realHeaders);
        HttpHelperResponse<T> result;
        if (String.class.equals(tClass)) {
            ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, tClass);
            result = createStringHttpHelperResponse(responseEntity);
        } else {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            result = createHttpHelperResponse(url, HttpMethod.POST, realHeaders, mediaType, responseEntity, tClass);
        }
        return result;
    }

    @Override
    public <T> HttpHelperResponse<T> post(String url, Object body, TypeReference<T> typeReference) {
        return post(url, body, null, MediaType.APPLICATION_JSON, typeReference);
    }

    @Override
    public <T> HttpHelperResponse<T> post(String url, Object body, HttpHeaders httpHeaders, TypeReference<T> typeReference) {
        return post(url, body, httpHeaders, MediaType.APPLICATION_JSON, typeReference);
    }

    @Override
    public <T> HttpHelperResponse<T> post(String url, Object body, MediaType mediaType, TypeReference<T> typeReference) {
        return post(url, body, null, mediaType, typeReference);
    }

    @Override
    public <T> HttpHelperResponse<T> post(String url, Object body, HttpHeaders httpHeaders, MediaType mediaType, TypeReference<T> typeReference) {
        HttpHeaders realHeaders = creatHttpHeaders(httpHeaders, mediaType);
        realHeaders.setContentType(mediaType);
        HttpEntity<String> entity = new HttpEntity(body, realHeaders);
        HttpHelperResponse<T> result;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        result = createHttpHelperResponse(url, HttpMethod.POST, realHeaders, mediaType, responseEntity, typeReference);
        return result;
    }
}