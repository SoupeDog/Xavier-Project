package org.xavier.web.limiter;

import org.xavier.web.limiter.restrictor.Restrictor;

import java.util.HashMap;

/**
 * 描述信息：<br/>
 * 限流器 容器
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.09
 * @since Jdk 1.8
 */
public class RestrictorContainer {
    /**
     * 桶容器名
     */
    private String name;
    /**
     * 桶池
     */
    private final HashMap<String, Restrictor> bucketMap = new HashMap();

    public RestrictorContainer() {
    }

    public void addBucket(String key, Restrictor restrictor) {
        bucketMap.put(key, restrictor);
    }

    public <T extends Restrictor> T getBucket(String key, Class<T> tClass) {
        Restrictor target = bucketMap.get(key);
        if (target == null) {
            return null;
        }
        return (T) target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Restrictor> getBucketMap() {
        return bucketMap;
    }
}
