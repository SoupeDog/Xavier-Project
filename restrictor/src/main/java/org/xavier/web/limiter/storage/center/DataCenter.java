package org.xavier.web.limiter.storage.center;

import org.xavier.web.limiter.partition.Partition;
import org.xavier.web.limiter.api.Path;
import org.xavier.web.limiter.storage.record.DataItem;

/**
 * 描述信息：<br/>
 * 数据中心接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public interface DataCenter<D extends DataItem, P extends Partition, U extends Path> {
    /**
     * 查询目标 DataItem
     */
    D getDataItem(P partition, U path);
}
