package org.xavier.web.limiter.reset.record;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.13
 * @since Jdk 1.8
 */
public class ResetInfo_TS extends ResetInfo {
    /**
     * 最后一次重置毫秒级时间戳
     */
    private long latestResetTs;

    public long getLatestResetTs() {
        return latestResetTs;
    }

    public void setLatestResetTs(long latestResetTs) {
        this.latestResetTs = latestResetTs;
    }
}
