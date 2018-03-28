package org.xavier.web.limiter.strategy;


import org.xavier.web.limiter.api.Path;
import org.xavier.web.limiter.partition.Partition;

/**
 * 描述信息：<br/>
 * 限流策略基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public class Strategy<P extends Partition, U extends Path> {
    protected U path;

    protected P partition;

    protected R resetInfo;

    public Strategy() {
    }

    public Strategy(U path, P partition) {
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
