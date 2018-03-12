package org.xavier.web.domain.water;

/**
 * 描述信息：<br/>
 * AppId 请求次数流量信息
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.03.09
 * @since Jdk 1.8
 */
public class Water_AppId_Frequency extends Water {

    /**
     * 应用唯一标识
     */
    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
