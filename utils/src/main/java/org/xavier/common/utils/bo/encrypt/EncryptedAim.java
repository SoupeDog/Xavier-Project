package org.xavier.common.utils.bo.encrypt;

import javax.crypto.Cipher;

/**
 * 描述信息：<br/>
 * 编码目标
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.04.10
 * @since Jdk 1.8
 */
public enum EncryptedAim {
    ENCODE(Cipher.ENCRYPT_MODE,"加密过程"),
    DECODE(Cipher.DECRYPT_MODE,"解密过程");

    private Integer value;
    private String description;

    EncryptedAim(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
