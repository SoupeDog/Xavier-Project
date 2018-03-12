package org.xavier.web.domain;

import org.xavier.web.domain.bucket.Bucket;

import java.util.HashMap;

/**
 * 描述信息：<br/>
 * 桶容器
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.09
 * @since Jdk 1.8
 */
public class BucketContainer {
    /**
     * 桶容器名
     */
    private String name;
    /**
     * 桶池
     */
    private final HashMap<String, Bucket> bucketMap = new HashMap();

    public BucketContainer() {
    }

    public void addBucket(String key, Bucket bucket) {
        bucketMap.put(key, bucket);
    }

    public <T extends Bucket> T getBucket(String key, Class<T> tClass) {
        Bucket target = bucketMap.get(key);
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

    public HashMap<String, Bucket> getBucketMap() {
        return bucketMap;
    }
}
