package org.xavier.web.domain.storage.center;

import org.xavier.web.domain.api.Path;
import org.xavier.web.domain.partition.Partition;
import org.xavier.web.domain.storage.record.DataItem;

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
    D getDataItem(P partition, U path);
}
