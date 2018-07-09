package org.xavier.web.annotation;

import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.07.06
 * @since Jdk 1.8
 */
public class DefaultControllerLog extends ControllerLog {
    @Override
    public void initRequest(String[] paths, String[] ignoreProperties, String[] propertiesNames, Object[] propertiesValue) {
        this.path = paths[0];
        LinkedHashMap<String, Object> requestPropertiesTemp = new LinkedHashMap();
        for (int i = 0; i < propertiesValue.length; i++) {
            String key = propertiesNames[i];
            if (isExists(key, ignoreProperties)) {
                continue;
            }
            requestPropertiesTemp.put(key, propertiesValue[i]);
        }
        if (requestPropertiesTemp.size() > 0) {
            this.requestProperties = requestPropertiesTemp;
        }
    }

    public Boolean isExists(String key, String[] target) {
        for (String temp : target) {
            if (key.equals(temp)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void initResponse(Object responseOBJ) {
        ResponseEntity<?> responseEntity = (ResponseEntity<?>) responseOBJ;
        this.httpStatus = responseEntity.getStatusCode().value();
        this.responseProperties = responseEntity.getBody();
    }
}