package org.xavier.web.limiter.restrictor;

import org.xavier.web.limiter.water.Water;

/**
 * 描述信息：<br/>
 * 桶 描述流量容纳能力
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.09
 * @since Jdk 1.8
 */
public abstract class Restrictor<T extends Water> {
    /**
     * 检测流量容器是否满载(满载时抛出异常)
     *
     * @param water 单个流量信息
     */
    public abstract boolean is_Full(T water);

    /**
     * 承载该流量
     */
    public abstract void contain(T water);
}
