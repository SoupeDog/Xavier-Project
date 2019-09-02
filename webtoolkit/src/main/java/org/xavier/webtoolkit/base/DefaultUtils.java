package org.xavier.webtoolkit.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xavier.common.logging.HyggeLogger;
import org.xavier.common.util.JsonHelper;
import org.xavier.common.util.PropertiesHelper;
import org.xavier.common.util.TimeHelper;

/**
 * 描述信息：<br/>
 * 默认工具类
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/9/2
 * @since Jdk 1.8
 */
@Component
public class DefaultUtils {
    @Autowired
    protected HyggeLogger logger;
    @Autowired
    protected JsonHelper jsonHelper;
    @Autowired
    protected JsonHelper jsonHelperIndent;
    @Autowired
    protected PropertiesHelper propertiesHelper;
    @Autowired
    protected TimeHelper timeHelper;
}
