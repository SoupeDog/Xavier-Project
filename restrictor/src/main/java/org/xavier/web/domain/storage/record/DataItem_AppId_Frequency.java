package org.xavier.web.domain.storage.record;

import org.xavier.web.domain.water.Water_AppId_Frequency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述信息：<br/>
 * 限流框架 appId 数据项
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public class DataItem_AppId_Frequency extends DataItem<Water_AppId_Frequency> {
    /**
     * 剩余许可次数
     */
    private final AtomicInteger remainder = new AtomicInteger();

    @Override
    public Boolean run(Water_AppId_Frequency water) {
        remainder.decrementAndGet();
        return true;
    }

    @Override
    public Boolean isApproved(Water_AppId_Frequency water) {
        return null;
    }
}
