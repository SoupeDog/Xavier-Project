package org.xavier.web.limiter.storage.center;

import org.springframework.http.HttpMethod;
import org.xavier.web.limiter.api.Path_Default;
import org.xavier.web.limiter.partition.Partition_GUID;
import org.xavier.web.limiter.storage.record.DataItem_GUID_Frequency;
import org.xavier.web.limiter.strategy.Strategy_GUID_Frequency;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述信息：<br/>
 * 限流框架 唯一标识 数据中心
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public class DataCenter_GUID implements DataCenter<Strategy_GUID_Frequency, DataItem_GUID_Frequency, Partition_GUID, Path_Default> {

    /**
     * 流量计数器池<appId,计数器>
     */
    private final ConcurrentHashMap<Partition_GUID, DataItem_GUID_Frequency> counterMap_Get = new ConcurrentHashMap();
    private final ConcurrentHashMap<Partition_GUID, DataItem_GUID_Frequency> counterMap_Put = new ConcurrentHashMap();
    private final ConcurrentHashMap<Partition_GUID, DataItem_GUID_Frequency> counterMap_Delete = new ConcurrentHashMap();
    private final ConcurrentHashMap<Partition_GUID, DataItem_GUID_Frequency> counterMap_Post = new ConcurrentHashMap();

    public ConcurrentHashMap<Partition_GUID, DataItem_GUID_Frequency> getCounterMap(HttpMethod httpMethod) {
        switch (httpMethod) {
            case GET:
                return counterMap_Get;
            case DELETE:
                return counterMap_Delete;
            case PUT:
                return counterMap_Put;
            case POST:
                return counterMap_Post;
            default:
                throw new RuntimeException("Unexpected HttpMethod: " + httpMethod);
        }
    }


    @Override
    public DataItem_GUID_Frequency getDataItem(Partition_GUID partition, Path_Default path) {


        return null;
    }

    @Override
    public Strategy_GUID_Frequency getStrategy(Partition_GUID partition, Path_Default path) {
        return null;
    }
}
