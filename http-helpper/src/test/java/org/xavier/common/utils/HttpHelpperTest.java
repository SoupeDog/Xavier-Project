package org.xavier.common.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/23
 * @since Jdk 1.8
 */
public class HttpHelpperTest {

    private HttpHelpper httpHelpper;

    @Before
    public void init() {
        httpHelpper = new BaseHttpHelper() {
            @Override
            void initObjectMapper() {
                mapper = new ObjectMapper();
                //反序列化出现多余属性时,选择忽略不抛出异常
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                // 开启允许数字以 0 开头
                mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
            }

            @Override
            void initRestTemplate() {
                restTemplate = new RestTemplate();
                ResponseErrorHandler responseErrorHandler = new ResponseErrorHandler() {
                    @Override
                    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                        return true;
                    }

                    @Override
                    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

                    }
                };
                restTemplate.setErrorHandler(responseErrorHandler);
                restTemplate.setMessageConverters(new ArrayList() {{
                    add(new StringHttpMessageConverter(Charset.forName("utf-8")));
                }});
            }
        };
    }

    @Test
    public void get() {
        HttpHelperResponse<Integer> response = httpHelpper.get("http://t.weather.sojson.com/api/weather/city/101030100",new HttpHeaders(){{
            add("搞事情","123");
        }}, Integer.class);
        System.out.println(response.getData());
    }
}