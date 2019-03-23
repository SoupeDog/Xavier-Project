package org.xavier.common.utils;


/**
 * 描述信息：<br/>
 * 序列化相关错误
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/23
 * @since Jdk 1.8
 */
public class SerializeRuntimeException extends RuntimeException {
    public SerializeRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
