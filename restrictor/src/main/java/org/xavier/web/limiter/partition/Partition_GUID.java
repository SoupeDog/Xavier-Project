package org.xavier.web.limiter.partition;

/**
 * 描述信息：<br/>
 * 唯一标识 隔断对象
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.12
 * @since Jdk 1.8
 */
public class Partition_GUID extends Partition{
    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
