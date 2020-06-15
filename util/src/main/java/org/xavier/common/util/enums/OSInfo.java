package org.xavier.common.util.enums;

import org.xavier.common.util.exception.UtilRuntimeException;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 描述信息：<br/>
 * 操作系统枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2020/6/15
 * @since Jdk 1.8
 */
public enum OSInfo {
    /**
     * Mac OS X 系
     */
    OSInfoX("^[Mm]ac OSInfo X$"),
    /**
     * Linux 系
     */
    LINUX("^[Ll]inux$"),
    /**
     * Windows 系
     */
    WINDOWS("^[Ww]indows.*");

    private final Set<Pattern> patterns;

   OSInfo(String... patterns) {
        this.patterns = new HashSet();
        for (String pattern : patterns) {
            this.patterns.add(Pattern.compile(pattern));
        }
    }

    private boolean is(String id) {
        for (Pattern pattern : patterns) {
            if (pattern.matcher(id).matches()) {
                return true;
            }
        }
        return false;
    }

    public static OSInfo getCurrent() {
        String osName = System.getProperty("os.name");
        for (OSInfo os : OSInfo.values()) {
            if (os.is(osName)) {
                return os;
            }
        }
        throw new UtilRuntimeException(String.format("Operating system \"%s\" is not supported.", osName));
    }
}