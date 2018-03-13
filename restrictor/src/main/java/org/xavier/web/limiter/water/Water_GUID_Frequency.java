package org.xavier.web.limiter.water;

/**
 * 描述信息：<br/>
 * 唯一标识 请求次数流量信息
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.09
 * @since Jdk 1.8
 */
public class Water_GUID_Frequency extends Water {

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
