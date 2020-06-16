package org.xavier.common.util.enums;


import org.xavier.common.util.exception.UtilRuntimeException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述信息：<br/>
 * CPU 架构枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2020/6/15
 * @since Jdk 1.8
 */
public enum ArchInfo {
    /**
     * x86 32 位
     */
    X86_32("i386", "i686", "x86"),
    /**
     * 64 位
     */
    X86_64("amd64", "x86_64"),
    /**
     * arm 32 位
     */
    ARMv8("arm");

    private Set<String> patterns;

    ArchInfo(String... patterns) {
        this.patterns = new HashSet(Arrays.asList(patterns));
    }

    private boolean is(String id) {
        return patterns.contains(id);
    }

    public static ArchInfo getCurrent() {
        final String osArch = System.getProperty("os.arch");

        for (ArchInfo arch : ArchInfo.values()) {
            if (arch.is(osArch)) {
                return arch;
            }
        }
        throw new UtilRuntimeException(String.format("Architecture \"%s\" is not supported.", osArch));
    }
}