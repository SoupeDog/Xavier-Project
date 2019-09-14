package org.xavier.common.logging.core;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rolling.CronTriggeringPolicy;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.config.Configuration;
import org.xavier.common.logging.config.HyggeLogSetting;

/**
 * 描述信息：<br/>
 * 日志文件变动触发器
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/9/14
 * @since Jdk 1.8
 */
public class HyggeTriggeringPolicy implements TriggeringPolicy {
    private SizeBasedTriggeringPolicy sizeBasedTriggeringPolicy;
    private CronTriggeringPolicy cronTriggeringPolicy;

    public HyggeTriggeringPolicy(HyggeLogSetting setting, Configuration logConfiguration) {
        sizeBasedTriggeringPolicy = SizeBasedTriggeringPolicy.createPolicy(setting.getMaxFileSize());
        // false 不做归档评估
        cronTriggeringPolicy = CronTriggeringPolicy.createPolicy(logConfiguration, Boolean.FALSE.toString(), setting.getCronTrigger());
    }

    @Override
    public void initialize(RollingFileManager manager) {
        sizeBasedTriggeringPolicy.initialize(manager);
        cronTriggeringPolicy.initialize(manager);
    }

    @Override
    public boolean isTriggeringEvent(LogEvent logEvent) {
        return sizeBasedTriggeringPolicy.isTriggeringEvent(logEvent) || cronTriggeringPolicy.isTriggeringEvent(logEvent);
    }
}