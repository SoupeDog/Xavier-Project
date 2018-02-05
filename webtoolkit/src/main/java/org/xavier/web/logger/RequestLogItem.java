package org.xavier.web.logger;

import org.springframework.http.HttpMethod;
import org.xavier.common.exception.base.RequestException_Runtime;
import org.xavier.common.utils.JsonHelper;
import org.xavier.common.utils.PropertiesHelper;
import org.xavier.common.utils.UtilsCreator;

/**
 * 描述信息：<br/>
 * 日志记录项
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.02.02
 * @since Jdk 1.8
 */
public class RequestLogItem {
    private HttpMethod httpMethod;
    private String path;
    private Object requestObject;
    private Float errorCode;
    private String msg;


    public JsonHelper jsonHelper;
    public PropertiesHelper propertiesHelper;

    public RequestLogItem() {
        jsonHelper = UtilsCreator.getInstance_DefaultJsonHelper();
        propertiesHelper = UtilsCreator.getInstance_DefaultPropertiesHelper();
    }

    public RequestLogItem(JsonHelper jsonHelper, PropertiesHelper propertiesHelper) {
        this.jsonHelper = jsonHelper;
        this.propertiesHelper = propertiesHelper;
    }

    public RequestLogItem(HttpMethod httpMethod, String path, Object requestObject, Float errorCode, String msg, JsonHelper jsonHelper, PropertiesHelper propertiesHelper) {
        this.httpMethod = httpMethod;
        this.path = path;
        this.requestObject = requestObject;
        this.errorCode = errorCode;
        this.msg = msg;
        this.jsonHelper = jsonHelper;
        this.propertiesHelper = propertiesHelper;
    }

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

    public Object getRequestObject() {
        return requestObject;
    }

    public void setRequestObject(Object requestObject) {
        this.requestObject = requestObject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Float getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Float errorCode) {
        this.errorCode = errorCode;
    }

    public String createLogString(LogTypeEnums logType) {
        String result = null;
        switch (logType) {
            case ALWAYS_REQUEST:
                if (requestObject == null) {
                    result = httpMethod.name() + " | Path: " + path;
                } else {
                    result = httpMethod.name() + " | Path: " + path + " | RequestOBJ: " + jsonHelper.format(requestObject);
                }
                break;
            case WARN_UNEXPECTED_REQUEST:
                if (requestObject == null) {
                    result = httpMethod.name() + " | Path: " + path + " | errorCode :" + errorCode + " | Msg :" + msg;
                } else {
                    result = httpMethod.name() + " | Path: " + path + " | RequestOBJ: " + jsonHelper.format(requestObject) + " | errorCode :" + errorCode + " | Msg :" + msg;
                }
                break;
            default:
                //TODO 未知异常捕获
                break;
        }
        return result;
    }


}
