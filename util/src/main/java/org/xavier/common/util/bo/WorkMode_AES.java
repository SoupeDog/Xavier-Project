package org.xavier.common.util.bo;

/**
 * 描述信息：<br/>
 * AES 工作模式
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.04.10
 * @since Jdk 1.8
 */
public enum WorkMode_AES {
    AES_ECB_NOPADDING(11, "AES/ECB/NoPadding"),
    AES_ECB_PKCS5_PADDING(12, "AES/ECB/PKCS5Padding"),
    AES_ECB_PKCS7_PADDING(13, "AES/ECB/PKCS7Padding"),
    AES_CBC_NOPADDING(21, "AES/CBC/NoPadding"),
    AES_CBC_PKCS5_PADDING(22, "AES/CBC/PKCS5Padding"),
    AES_CBC_PKCS7_PADDING(23, "AES/CBC/PKCS7Padding"),
    AES_CBC_ZERO_PADDING(24, "AES/CBC/NoPadding");//不填充以便自主实现填充

    private final Integer index;
    private final String val;

    WorkMode_AES(Integer index, String val) {
        this.index = index;
        this.val = val;
    }

    public Integer getIndex() {
        return index;
    }

    public String getVal() {
        return val;
    }
}
