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
    /**
     * 唯一标识
     */
    private String GUID;

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }
}
