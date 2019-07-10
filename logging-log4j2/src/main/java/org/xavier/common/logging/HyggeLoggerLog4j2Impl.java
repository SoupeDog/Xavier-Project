package org.xavier.common.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

/**
 * 描述信息：<br/>
 * log4j2 的 HyggeLogger 实现
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.02.01
 * @since Jdk 1.8
 */
public class HyggeLoggerLog4j2Impl implements HyggeLogger {
    private Logger logger;

    private static final Level ALWAYS_LEVEL = Level.forName("ALWAYS", 0);

    public HyggeLoggerLog4j2Impl(Logger log4j) {
        this.logger = log4j;
    }

    @Override
    public void always(String message) {
        logger.log(ALWAYS_LEVEL, message);
    }

    @Override
    public void always(String message, Throwable e) {
        logger.log(ALWAYS_LEVEL, message, e);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(String message, Throwable e) {
        logger.debug(message, e);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(String message, Throwable e) {
        logger.info(message, e);
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void warn(String message, Throwable e) {
        logger.warn(message, e);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Throwable e) {
        logger.error(message, e);
    }
}