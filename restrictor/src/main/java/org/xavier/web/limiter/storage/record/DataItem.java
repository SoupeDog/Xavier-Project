package org.xavier.web.limiter.storage.record;

import org.xavier.web.limiter.water.Water;

/**
 * 描述信息：<br/>
 * 记录数据项 基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public abstract class DataItem<W extends Water> {
    /**
     * 执行一次业务操作数据更新
     */
    public abstract Boolean run(W water);
    /**
     * @return 是否准许访问业务执行
     */
    public abstract Boolean isApproved(W water);
}
