package org.xavier.web.logger;

/**
 * 描述信息：<br/>
 * 日志类型枚举
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.02.05
 * @since Jdk 1.8
 */
public enum LogTypeEnums {
    ALWAYS_REQUEST("请求记录日志"),
    WARN_UNEXPECTED_REQUEST("请求失败记录日志"),
    ERROR_UNEXPECTED_SERVICEERROR("未知服务器异常");

    LogTypeEnums(String description) {
        this.description = description;
    }

    private String description;
}
