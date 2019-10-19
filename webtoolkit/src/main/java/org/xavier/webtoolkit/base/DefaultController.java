package org.xavier.webtoolkit.base;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.xavier.common.exception.base.RequestRuntimeException;
import org.xavier.webtoolkit.domain.ErrorResult;

import java.nio.charset.Charset;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/9/2
 * @since Jdk 1.8
 */
@Component
public class DefaultController extends DefaultUtils {

    /**
     * 成功请求钩子函数
     *
     * @param object 成功返回值
     * @return 处理后的成功返回值
     */
    protected Object successHook(Object object, ResponseEntity.BodyBuilder builder) {
        return object;
    }

    /**
     * 失败请求钩子函数
     *
     * @param errorResult 错误信息
     * @return 处理后的失败返回值
     */
    protected Object failHook(ErrorResult errorResult, ResponseEntity.BodyBuilder builder) {
        return errorResult;
    }

    @ExceptionHandler(RequestRuntimeException.class)
    public ResponseEntity<?> RequestRuntimeExceptionHandler(RequestRuntimeException e) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.BAD_REQUEST);
        builder.contentType(mediaType);
        logger.warn(e.getMessage());
        return builder.body(failHook(new ErrorResult(e.getStateCode(), e.getMessage()), builder));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> serviceErrorHandler(Throwable e) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        builder.contentType(mediaType);
        logger.error(e.getMessage(), e);
        return builder.body(failHook(new ErrorResult(500, e.getMessage()), builder));
    }

    public ResponseEntity<?> success() {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
        builder.contentType(mediaType);
        return builder.body(successHook(null, builder));
    }

    public ResponseEntity<?> success(Object entity) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);
        builder.contentType(mediaType);
        return builder.body(successHook(entity, builder));
    }

    public ResponseEntity<?> fail(HttpStatus status, Number errorCode, String msg) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(status);
        builder.contentType(mediaType);
        return builder.body(failHook(new ErrorResult(errorCode, msg), builder));
    }
}