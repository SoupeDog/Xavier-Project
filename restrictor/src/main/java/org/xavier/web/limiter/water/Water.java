package org.xavier.web.limiter.water;

import org.xavier.web.limiter.api.ApiInfo;
import org.xavier.web.limiter.partition.Partition;

/**
 * 描述信息：<br/>
 * 单个流量信息
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.09
 * @since Jdk 1.8
 */
public class Water<P extends Partition,U extends ApiInfo> {
    protected U path;


    protected P partition;

    public Water() {
    }

    public Water(U path, P partition) {
        this.path = path;
        this.partition = partition;
    }

    public U getPath() {
        return path;
    }

    public void setPath(U path) {
        this.path = path;
    }

    public P getPartition() {
        return partition;
    }

    public void setPartition(P partition) {
        this.partition = partition;
    }
}
