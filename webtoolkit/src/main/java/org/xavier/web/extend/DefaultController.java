package org.xavier.web.extend;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.xavier.common.exception.base.RequestException_Runtime;

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
@Controller
public class DefaultController extends DefaultUtils {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> serviceErrorHandler(Throwable e) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        builder.contentType(mediaType);
        logger.error(e.getMessage(), e);
        return builder.body(new ErrorResult(500F, e.getMessage()));
    }

    @ExceptionHandler(RequestException_Runtime.class)
    public ResponseEntity<?> RequestException_RuntimeHandler(RequestException_Runtime e) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.BAD_REQUEST);
        builder.contentType(mediaType);
        logger.warn(e.getMessage());
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

    public ResponseEntity<?> fail(HttpStatus status, Float errorCode, String msg) {
        MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(status);
        builder.contentType(mediaType);
        return builder.body(new ErrorResult(errorCode, msg));
    }
}