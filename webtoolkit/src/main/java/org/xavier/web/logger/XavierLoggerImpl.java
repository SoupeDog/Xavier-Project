package org.xavier.web.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.xavier.common.utils.JsonHelper;

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

    private static JsonHelper jsonHelper;

    public XavierLoggerImpl() {
    }

    public XavierLoggerImpl(Logger log4j, JsonHelper jsonHelper) {
        this.logger = log4j;
        this.jsonHelper = jsonHelper;
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

    @Override
    public void assertFail_Debug(String target, String expected, String actual) {
        debug("AssertFail [" + target + "] expected:" + expected + " | actual:" + actual);
    }

    @Override
    public void assertFail_Debug_WithParameter(String target, String expected, String actual, Object parameter) {
        debug("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual + " | Parameter:" + jsonHelper.format(parameter));
    }

    @Override
    public void assertFail_Info(String target, String expected, String actual) {
        info("AssertFail [" + target + "] expected:" + expected + " | actual:" + actual);
    }

    @Override
    public void assertFail_Info_WithParameter(String target, String expected, String actual, Object parameter) {
        info("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual + " | Parameter:" + jsonHelper.format(parameter));
    }

    @Override
    public void assertFail_Warn(String target, String expected, String actual) {
        warn("AssertFail [" + target + "] expected:" + expected + " | actual:" + actual);
    }

    @Override
    public void assertFail_Warn_WithParameter(String target, String expected, String actual, Object parameter) {
        warn("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual + " | Parameter:" + jsonHelper.format(parameter));
    }

    @Override
    public void assertFail_Error(String target, String expected, String actual) {
        error("AssertFail [" + target + "] expected:" + expected + " | actual:" + actual);
    }

    @Override
    public void assertFail_Error_WithParameter(String target, String expected, String actual, Object parameter) {
        error("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual + " | Parameter:" + jsonHelper.format(parameter));
    }
}
