package org.xavier.web.domain.strategy;


/**
 * 描述信息：<br/>
 * 根据 appId 限制次数策略
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public class FrequencyStrategy_AppId extends Strategy {
    /**
     * 策略刷新间隔 单位(毫秒)
     */
    private Long refreshInterval;


}
