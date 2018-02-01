package org.xavier.web.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.02.01
 * @since Jdk 1.8
 */
public class XavierLoggerImpl implements XavierLogger {
    private Logger logger;

    public XavierLoggerImpl() {
    }

    public XavierLoggerImpl(Logger log4j) {
        this.logger = log4j;
    }

    @Override
    public void always(String message) {
        logger.log(Level.forName("ALWAYS", 0), message);
    }

    @Override
    public void always(String message, Throwable e) {
        logger.log(Level.forName("ALWAYS", 0), message, e);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Throwable e) {
        logger.error(message, e);
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
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(String message, Throwable e) {
        logger.info(message, e);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(String message, Throwable e) {
        logger.debug(message, e);
    }
}
