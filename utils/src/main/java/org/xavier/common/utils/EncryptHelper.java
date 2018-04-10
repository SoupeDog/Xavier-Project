package org.xavier.common.utils;

import org.xavier.common.utils.bo.encrypt.Base64Mode;

import java.util.Base64;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.04.10
 * @since Jdk 1.8
 */
public interface EncryptHelper {

    /**
     * 获取 Base64 加密工具
     *
     * @param type Base64 类型
     */
    Base64.Encoder getBase64Encoder(Base64Mode type);

    /**
     * 获取 Base64 解密工具
     *
     * @param type Base64 类型
     */
    Base64.Decoder getBase64Decoder(Base64Mode type);
}
