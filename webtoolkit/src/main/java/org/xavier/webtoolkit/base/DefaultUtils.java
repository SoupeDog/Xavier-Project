package org.xavier.webtoolkit.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xavier.common.logging.core.HyggeLogger;
import org.xavier.common.util.*;

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
    @Autowired
    protected SqlHelper sqlHelper;
    @Autowired
    protected CollectionHelper collectionHelper;
}