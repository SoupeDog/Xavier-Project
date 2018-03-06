package org.xavier.web.extend;

import org.springframework.stereotype.Service;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/1/14
 * @since Jdk 1.8
 */
@Service
public class DefaultService extends DefaultUtils {
    /**
     * 逆序常量字符串
     */
    protected static final String DESC = "DESC";
    /**
     * 正序序常量字符串
     */
    protected static final String ASC = "ASC";
    /**
     * 最后修改时间戳常量字符
     */
    protected static final String LASTUPDATETS = "lastUpdateTs";
    /**
     * 创建时间戳常量字符
     */
    protected static final String REGISTERTS = "registerTs";
}
