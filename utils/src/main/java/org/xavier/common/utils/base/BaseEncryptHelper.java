package org.xavier.common.utils.base;


import org.xavier.common.exception.Universal_500_X_Exception_Runtime;
import org.xavier.common.utils.EncryptHelper;
import org.xavier.common.utils.bo.encrypt.Base64Mode;

import java.util.Base64;

/**
 * 描述信息：<br/>
 * 加密工具主基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.04.10
 * @since Jdk 1.8
 */
public class BaseEncryptHelper implements EncryptHelper {
    /**
     * 获取 Base 64 Encoder
     */
    public Base64.Encoder getBase64Encoder(Base64Mode type) {
        Base64.Encoder encoder = null;
        switch (type) {
            case DEFAULT:
                encoder = Base64.getEncoder();
                break;
            default:
                throw new Universal_500_X_Exception_Runtime(555F, "Unexpected EncryptType[" + type.getIndex() + " : " + type.getVal() + "].");
        }
        return encoder;
    }

    /**
     * 获取 Base 64 Decoder
     */
    public Base64.Decoder getBase64Decoder(Base64Mode type) {
        Base64.Decoder decoder = null;
        switch (type) {
            case DEFAULT:
                decoder = Base64.getDecoder();
                break;
            default:
                throw new Universal_500_X_Exception_Runtime(555F, "Unexpected EncryptType[" + type.getIndex() + " : " + type.getVal() + "].");
        }
        return decoder;
    }
}
