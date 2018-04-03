package org.xavier.web.limiter.strategy;


import org.xavier.web.limiter.api.ApiInfo;
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
public class Strategy<P extends Partition, A extends ApiInfo> {
    protected A path;

    protected P partition;


    public Strategy() {
    }

    public Strategy(A path, P partition) {
        this.path = path;
        this.partition = partition;
    }

    public A getPath() {
        return path;
    }

    public void setPath(A path) {
        this.path = path;
    }

    public P getPartition() {
        return partition;
    }

    public void setPartition(P partition) {
        this.partition = partition;
    }
}
