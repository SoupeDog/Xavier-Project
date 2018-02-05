package org.xavier.web.extend;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.xavier.common.exception.base.RequestException_Runtime;
import org.xavier.web.logger.LogTypeEnums;
import org.xavier.web.logger.RequestLogItem;

import java.nio.charset.Charset;

/**
 * 描述信息：<br/>
 * Controller 基础功能
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/1/14
 * @since Jdk 1.8
 */
@RestController
public class DefaultController extends DefaultUtils {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> serviceErrorHandler(Throwable e) {
        e.printStackTrace();
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        builder.contentType(mediaType);
        return builder.body(new ErrorResult(500F, e.getMessage()));
    }

    @ExceptionHandler(RequestException_Runtime.class)
    public ResponseEntity<?> RequestException_RuntimeHandler(RequestException_Runtime e) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.BAD_REQUEST);
        builder.contentType(mediaType);
        return builder.body(new ErrorResult(e.getStateCode(), e.getMessage()));
    }


    public ResponseEntity<?> success() {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
        builder.contentType(mediaType);
        return builder.body(null);
    }

    public ResponseEntity<?> success(Object entity) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
        builder.contentType(mediaType);
        return builder.body(entity);
    }

    public ResponseEntity<?> fail(HttpMethod httpMethod, String path, Object requestObject, HttpStatus status, Float errorCode, String msg) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(status);
        builder.contentType(mediaType);
        RequestLogItem requestLogItem = new RequestLogItem(jsonHelper_Log, propertiesHelper);
        requestLogItem.setHttpMethod(httpMethod);
        requestLogItem.setPath(path);
        requestLogItem.setRequestObject(requestObject);
        requestLogItem.setErrorCode(errorCode);
        requestLogItem.setMsg(msg);
        errorLog(LogTypeEnums.WARN_UNEXPECTED_REQUEST, requestLogItem);
        return builder.body(new ErrorResult(errorCode, msg));
    }

    public void alwaysLog(HttpMethod httpMethod, String path, Object requestObject) {
        if (requestObject == null) {
            logger.always(httpMethod.name() + " | Path: " + path + " | RequestOBJ: " + jsonHelper_Log.format(requestObject));
        } else {
            logger.always(httpMethod.name() + " | Path: " + path);
        }
    }

    public void errorLog(LogTypeEnums logType, RequestLogItem requestLogItem) {
        switch (logType) {
            case WARN_UNEXPECTED_REQUEST:
                logger.warn(requestLogItem.createLogString(logType));
                break;
            case ERROR_UNEXPECTED_SERVICEERROR:
                logger.error(requestLogItem.createLogString(logType));
                break;
            default:
                //TODO 未知异常捕获
                break;
        }
    }

    public void errorLog(LogTypeEnums logType, RequestLogItem requestLogItem, Throwable e) {
        switch (logType) {
            case WARN_UNEXPECTED_REQUEST:
                logger.warn(requestLogItem.createLogString(logType), e);
                break;
            case ERROR_UNEXPECTED_SERVICEERROR:
                logger.error(requestLogItem.createLogString(logType), e);
                break;
            default:
                //TODO 未知异常捕获
                break;
        }
    }
}
