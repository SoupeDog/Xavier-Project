package org.xavier.web.logger;


/**
 * 描述信息：<br/>
 * XavierLogger 接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.02.01
 * @since Jdk 1.8
 */
public interface XavierLogger {
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

    void assertFail_Debug(String target, String expected, String actual);

    void assertFail_Debug_WithParameter(String target, String expected, String actual, Object parameter);

    void assertFail_Info(String target, String expected, String actual);

    void assertFail_Info_WithParameter(String target, String expected, String actual, Object parameter);

    void assertFail_Warn(String target, String expected, String actual);

    void assertFail_Warn_WithParameter(String target, String expected, String actual, Object parameter);

    void assertFail_Error(String target, String expected, String actual);

    void assertFail_Error_WithParameter(String target, String expected, String actual, Object parameter);
}
