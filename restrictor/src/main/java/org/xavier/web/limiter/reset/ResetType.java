package org.xavier.web.limiter.reset;

import org.xavier.web.limiter.reset.record.ResetInfo;

/**
 * 描述信息：<br/>
 * 刷新类型基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.13
 * @since Jdk 1.8
 */
public abstract class ResetType<R extends ResetInfo> {
    protected R resetInfo;

    public R getResetInfo() {
        return resetInfo;
    }

    public void setResetInfo(R resetInfo) {
        this.resetInfo = resetInfo;
    }
}
