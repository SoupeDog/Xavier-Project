package org.xavier.common.util.http.helper;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.xavier.common.util.UtilsCreator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/10/6
 * @since Jdk 1.8
 */
public class HttpHelperTest {
    private HttpHelper httpHelpper;

    @Before
    public void init() {
        httpHelpper = new BaseHttpHelper() {
            @Override
            public void initObjectMapper() {
                mapper = new ObjectMapper();
                //反序列化出现多余属性时,选择忽略不抛出异常
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                // 开启允许数字以 0 开头
                mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
            }

            @Override
            public void initRestTemplate() {
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
                // 解决解析中文乱码问题
                List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
                int needReplaceIndex;
                boolean needRemove = false;
                for (needReplaceIndex = 0; needReplaceIndex < converters.size(); needReplaceIndex++) {
                    if (converters.get(needReplaceIndex) instanceof StringHttpMessageConverter) {
                        needRemove = true;
                        break;
                    }
                }
                if (needRemove) {
                    converters.remove(needReplaceIndex);
                    if (needReplaceIndex < converters.size()) {
                        converters.add(needReplaceIndex, new StringHttpMessageConverter(Charset.forName("utf-8")));
                    } else if (needReplaceIndex > -1) {
                        converters.add(needReplaceIndex - 1, new StringHttpMessageConverter(Charset.forName("utf-8")));
                    } else {
                        converters.add(new StringHttpMessageConverter(Charset.forName("utf-8")));
                    }
                    restTemplate.setMessageConverters(converters);
                }
            }
        };
    }

    @Test
    public void get() {
        HttpHelperResponse<Integer> response = httpHelpper.get("http://t.weather.sojson.com/api/weather/city/101030100", new HttpHeaders() {{
            add("搞事情", "123");
        }}, Integer.class);
        System.out.println(response.getData());
    }

    @Test
    public void post() {
        HttpHelperResponse<String> response = httpHelpper.post("http://127.0.0.1:8080/extra/token/validate", new HashMap() {{
            put("uId", "U00000001");
            put("token", "0000");
            put("scopeByte", 0);
        }}, String.class);
        System.out.println(UtilsCreator.getDefaultJsonHelperInstance(true).format(response.getData()));
    }
}