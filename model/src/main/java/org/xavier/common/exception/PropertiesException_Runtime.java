package org.xavier.common.exception;

import org.xavier.common.exception.base.RequestException_Runtime;

/**
 * 描述信息：<br/>
 * 参数异常
 *
 * @author Xavier
 * @version 1.0
 * @date 2017/9/30
 * @since Jdk 1.8
 */
public class PropertiesException_Runtime extends RequestException_Runtime {
    public PropertiesException_Runtime() {
        super();
    }

    public PropertiesException_Runtime(String msg) {
        super(msg);
    }

    public PropertiesException_Runtime(String msg, Throwable cause) {
        super(400d, msg, cause);
    }
}
