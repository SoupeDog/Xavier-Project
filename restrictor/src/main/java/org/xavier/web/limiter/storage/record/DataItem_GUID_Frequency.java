package org.xavier.web.limiter.storage.record;

import org.xavier.web.limiter.water.Water_GUID_Frequency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述信息：<br/>
 * 限流框架 唯一标识 数据项
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public class DataItem_GUID_Frequency extends DataItem<Water_GUID_Frequency> {
    /**
     * 剩余许可次数
     */
    private final AtomicInteger remainder = new AtomicInteger();

    @Override
    public Boolean run(Water_GUID_Frequency water) {
        remainder.decrementAndGet();
        return true;
    }

    @Override
    public Boolean isApproved(Water_GUID_Frequency water) {
        return null;
    }
}
