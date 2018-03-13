package org.xavier.web.limiter.storage.center;

import org.xavier.web.limiter.api.Path_Default;
import org.xavier.web.limiter.partition.Partition_GUID;
import org.xavier.web.limiter.storage.record.DataItem_GUID_Frequency;

/**
 * 描述信息：<br/>
 * 限流框架 唯一标识 数据中心
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public class DataCenter_GUID implements DataCenter<DataItem_GUID_Frequency,Partition_GUID,Path_Default> {
    @Override
    public DataItem_GUID_Frequency getDataItem(Partition_GUID partition, Path_Default path) {
        return null;
    }
}
