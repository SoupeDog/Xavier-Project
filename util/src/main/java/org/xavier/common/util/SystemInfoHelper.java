package org.xavier.common.util;

import org.xavier.common.util.enums.ArchInfo;
import org.xavier.common.util.enums.OSInfo;

/**
 * 描述信息：<br/>
 * 系统信息工具
 *
 * @author Xavier
 * @version 1.0
 * @date 2020/6/15
 * @since Jdk 1.8
 */
public interface SystemInfoHelper {
    /**
     * 当前操作系统架构
     */
    ArchInfo ARCH = ArchInfo.getCurrent();
    /**
     * 当前操作系统类型
     */
    OSInfo OS = OSInfo.getCurrent();
}