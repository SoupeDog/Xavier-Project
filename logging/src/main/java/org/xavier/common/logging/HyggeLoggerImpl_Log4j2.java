package org.xavier.common.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.xavier.common.utils.JsonHelper;
import org.xavier.common.utils.UtilsCreator;

/**
 * 描述信息：<br/>
 * log4j2 的 HyggeLogger 实现
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.02.01
 * @since Jdk 1.8
 */
public class HyggeLoggerImpl_Log4j2 implements HyggeLogger {
    private Logger logger;

    private static final JsonHelper jsonHelper = UtilsCreator.getInstance_DefaultJsonHelper(false);

    public HyggeLoggerImpl_Log4j2() {
    }

    public HyggeLoggerImpl_Log4j2(Logger log4j) {
        this.logger = log4j;
    }

    public Logger getLogger() {
        return logger;
    }

    public JsonHelper getJsonHelper() {
        return jsonHelper;
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

//    @Override
//    public void assertFail_Debug(String target, String expected, Object actual) {
//        if (actual == null) {
//            debug("AssertFail [" + target + "] Expected:" + expected + " | Actual:NULL");
//        }
//        debug("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual);
//    }
//
//    @Override
//    public void assertFail_Debug_WithParameter(String target, String expected, Object actual, Object parameter) {
//        if (actual == null) {
//            debug("AssertFail [" + target + "] Expected:" + expected + " | Actual:NULL" + " | Parameter:" + jsonHelper.format(parameter));
//        }
//        debug("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual + " | Parameter:" + jsonHelper.format(parameter));
//    }
//
//    @Override
//    public void assertFail_Info(String target, String expected, Object actual) {
//        if (actual == null) {
//            info("AssertFail [" + target + "] Expected:" + expected + " | Actual:NULL");
//        }
//        info("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual);
//    }
//
//    @Override
//    public void assertFail_Info_WithParameter(String target, String expected, Object actual, Object parameter) {
//        if (actual == null) {
//            info("AssertFail [" + target + "] Expected:" + expected + " | Actual:NULL" + " | Parameter:" + jsonHelper.format(parameter));
//        }
//        info("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual + " | Parameter:" + jsonHelper.format(parameter));
//    }
//
//    @Override
//    public void assertFail_Warn(String target, String expected, Object actual) {
//        if (actual == null) {
//            warn("AssertFail [" + target + "] Expected:" + expected + " | Actual:NULL");
//        }
//        warn("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual);
//    }
//
//    @Override
//    public void assertFail_Warn_WithParameter(String target, String expected, Object actual, Object parameter) {
//        if (actual == null) {
//            warn("AssertFail [" + target + "] Expected:" + expected + " | Actual:NULL" + " | Parameter:" + jsonHelper.format(parameter));
//        }
//        warn("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual + " | Parameter:" + jsonHelper.format(parameter));
//    }
//
//    @Override
//    public void assertFail_Error(String target, String expected, Object actual) {
//        if (actual == null) {
//            error("AssertFail [" + target + "] Expected:" + expected + " | Actual:NULL");
//        }
//        error("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual);
//    }
//
//    @Override
//    public void assertFail_Error_WithParameter(String target, String expected, Object actual, Object parameter) {
//        if (actual == null) {
//            error("AssertFail [" + target + "] Expected:" + expected + " | Actual:NULL" + " | Parameter:" + jsonHelper.format(parameter));
//        }
//        error("AssertFail [" + target + "] Expected:" + expected + " | Actual:" + actual + " | Parameter:" + jsonHelper.format(parameter));
//    }
}
