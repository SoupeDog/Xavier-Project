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

    /**
     * 必然输出
     *
     * @param message 日志字符串
     */
    void always(String message);

    /**
     * 必然输出
     *
     * @param message 日志字符串
     * @param e       异常信息
     */
    void always(String message, Throwable e);

    /**
     * trace 及以下输出
     *
     * @param message 日志字符串
     */
    void trace(String message);

    /**
     * trace 及以下输出
     *
     * @param message 日志字符串
     * @param e       异常信息
     */
    void trace(String message, Throwable e);

    /**
     * debug 及以下输出
     *
     * @param message 日志字符串
     */
    void debug(String message);

    /**
     * debug 及以下输出
     *
     * @param message 日志字符串
     * @param e       异常信息
     */
    void debug(String message, Throwable e);

    /**
     * info 及以下输出
     *
     * @param message 日志字符串
     */
    void info(String message);

    /**
     * info 及以下输出
     *
     * @param message 日志字符串
     * @param e       异常信息
     */
    void info(String message, Throwable e);

    /**
     * warn 及以下输出
     *
     * @param message 日志字符串
     */
    void warn(String message);

    /**
     * warn 及以下输出
     *
     * @param message 日志字符串
     * @param e       异常信息
     */
    void warn(String message, Throwable e);

    /**
     * error 及以下输出
     *
     * @param message 日志字符串
     */
    void error(String message);

    /**
     * error 及以下输出
     *
     * @param message 日志字符串
     * @param e       异常信息
     */
    void error(String message, Throwable e);
}