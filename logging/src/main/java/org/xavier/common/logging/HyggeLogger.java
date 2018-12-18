package org.xavier.common.logging;


/**
 * 描述信息：<br/>
 * HyggeLogger 接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.02.01
 * @since Jdk 1.8
 */
public interface HyggeLogger {
    String DEFAULT_LOGGER_NAME = "HyggeLogger";

    void always(String message);

    void always(String message, Throwable e);

    void error(String message);

    void error(String message, Throwable e);

    void warn(String message);

    void warn(String message, Throwable e);

    void info(String message);

    void info(String message, Throwable e);

    void debug(String message);

    void debug(String message, Throwable e);
}
