package org.xavier.common.logging;

import org.xavier.common.utils.UtilsCreator;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.26
 * @since Jdk 1.8
 */
public class HyggeLoggerMsgBuilder {

    public static String assertFail(String tagName, String expected, Object actual, Object parameter) {
        StringBuilder stringBuilder = new StringBuilder();
        if (actual == null) {
            stringBuilder.append("AssertFail [").append(tagName).append("] Expected:").append(expected).append(" | Actual:NULL");
            if (parameter != null) {
                stringBuilder.append(" | Parameter:").append(UtilsCreator.getInstance_DefaultJsonHelper(false).format(parameter));
            }
        } else {
            stringBuilder.append("AssertFail [").append(tagName).append("] Expected:").append(expected).append(" | Actual:").append(UtilsCreator.getInstance_DefaultJsonHelper(false).format(actual));
            if (parameter != null) {
                stringBuilder.append(" | Parameter:").append(UtilsCreator.getInstance_DefaultJsonHelper(false).format(parameter));
            }
        }
        return stringBuilder.toString();
    }
}
