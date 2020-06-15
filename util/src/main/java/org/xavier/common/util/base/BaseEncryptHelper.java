package org.xavier.common.util.base;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.xavier.common.enums.StringFormatMode;
import org.xavier.common.util.EncryptHelper;
import org.xavier.common.util.enums.Base64Mode;
import org.xavier.common.util.exception.UtilRuntimeException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
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
    private static final String PROVIDER_NAME = "BC";

    static {
        try {
            if (Security.getProvider(PROVIDER_NAME) == null) {
                Security.addProvider(new BouncyCastleProvider());
            }
        } catch (Exception e) {
            throw new UtilRuntimeException(550, "Fail to init BouncyCastleProvider.");
        }
    }

    /**
     * 获取 Base 64 Encoder
     */
    @Override
    public Base64.Encoder getBase64Encoder(Base64Mode type) {
        Base64.Encoder encoder = null;
        switch (type) {
            case DEFAULT:
                encoder = Base64.getEncoder();
                break;
            default:
                throw new UtilRuntimeException(550, "Unexpected EncryptType[" + type.getIndex() + " : " + type.getVal() + "].");
        }
        return encoder;
    }

    /**
     * 获取 Base 64 Decoder
     */
    @Override
    public Base64.Decoder getBase64Decoder(Base64Mode type) {
        Base64.Decoder decoder = null;
        switch (type) {
            case DEFAULT:
                decoder = Base64.getDecoder();
                break;
            default:
                throw new UtilRuntimeException(550, "Unexpected EncryptType[" + type.getIndex() + " : " + type.getVal() + "].");
        }
        return decoder;
    }

    @Override
    public String byteArrayToHex(byte[] target, StringFormatMode stringFormatMode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte item : target) {
            String temp = Integer.toHexString(0xFF & item);
            if (temp.length() < 2) {
                stringBuilder.append("0" + temp);
            } else {
                stringBuilder.append(temp);
            }
        }
        String result = stringBuilder.toString();
        switch (stringFormatMode) {
            case UPPERCASE:
                result = result.toUpperCase();
                break;
            case LOWERCASE:
                result = result.toLowerCase();
                break;
            default:
        }
        return result;
    }

    @Override
    public String md5Sign16(String target, String secretKey, StringFormatMode stringFormatMode) {
        return md5Sign32(target, secretKey, stringFormatMode).substring(8, 24);
    }

    @Override
    public String md5Sign32(String target, String secretKey, StringFormatMode stringFormatMode) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digestResultTemp = messageDigest.digest((target + secretKey).getBytes());
            String digestResult = byteArrayToHex(digestResultTemp, stringFormatMode);
            return digestResult;
        } catch (NoSuchAlgorithmException e) {
            throw new UtilRuntimeException(550, "Fail to MD5.", e);
        }
    }
}