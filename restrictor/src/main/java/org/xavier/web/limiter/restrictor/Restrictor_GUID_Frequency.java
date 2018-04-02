package org.xavier.web.limiter.restrictor;

import org.xavier.web.limiter.water.Water_GUID_Frequency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述信息：<br/>
 * 请求次数限流器
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.09
 * @since Jdk 1.8
 */
public class Restrictor_GUID_Frequency extends Restrictor<Water_GUID_Frequency> {

    /**
     * 限流器刷新间隔 单位(毫秒)
     */
    private Long refreshInterval;

    /**
     * 最后刷新时间时间戳
     */
    private long lastRefreshTs;
    /**
     * 单位间隔内最大访问次数
     */
    private int maxLimit;

    public Long getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(Long refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    public long getLastRefreshTs() {
        return lastRefreshTs;
    }

    public void setLastRefreshTs(long lastRefreshTs) {
        this.lastRefreshTs = lastRefreshTs;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean is_Full(Water_GUID_Frequency water) {
        long currentTs = System.currentTimeMillis();
        if (currentTs - lastRefreshTs > refreshInterval) {
            refreshBucket();
            lastRefreshTs = System.currentTimeMillis();
        }
        ConcurrentHashMap<String, AtomicInteger> counterMap = getCounterMap(water);
        if (counterMap.containsKey(water.getAppId())) {
            AtomicInteger counter = counterMap.get(water.getAppId());
            if (counter.get() < 1) {
                throw new RuntimeException("[appId]: " + water.getAppId() + " has too many requests.");
            }
        } else {
            counterMap.put(water.getAppId(), new AtomicInteger(maxLimit));
        }
        return true;
    }

    @Override
    public void contain(Water_GUID_Frequency water) {
        ConcurrentHashMap<String, AtomicInteger> counterMap = getCounterMap(water);
        AtomicInteger counter = counterMap.get(water.getAppId());
        counter.decrementAndGet();
    }

    public void refreshBucket() {
        for (AtomicInteger temp : counterMap_Get.values()) {
            temp.set(maxLimit);
        }
        for (AtomicInteger temp : counterMap_Post.values()) {
            temp.set(maxLimit);
        }
        for (AtomicInteger temp : counterMap_Put.values()) {
            temp.set(maxLimit);
        }
        for (AtomicInteger temp : counterMap_Delete.values()) {
            temp.set(maxLimit);
        }
    }
}
