package org.xavier.common.util.impl;


import org.xavier.common.util.base.BaseEncryptHelper;
import org.xavier.common.util.bo.Base64Mode;
import org.xavier.common.util.bo.EncryptedAim;
import org.xavier.common.util.bo.WorkModeAes;
import org.xavier.common.util.exception.UtilRuntimeException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 描述信息：<br/>
 * AES 的加解密工具
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.04.10
 * @since Jdk 1.8
 */
public class EncryptHelperAes extends BaseEncryptHelper {

    private static final String CHARSET = "utf-8";

    private Cipher initCipher(EncryptedAim encryptedAim, WorkModeAes workModeAes, IvParameterSpec iv, byte[] key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchProviderException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        // 指定加密的算法、工作模式和填充方式
        Cipher cipher = Cipher.getInstance(workModeAes.getVal(), "BC");
        switch (workModeAes) {
            case AES_ECB_NOPADDING:
                cipher.init(encryptedAim.getValue(), secretKeySpec);
                break;
            case AES_ECB_PKCS5_PADDING:
                cipher.init(encryptedAim.getValue(), secretKeySpec);
                break;
            case AES_ECB_PKCS7_PADDING:
                cipher.init(encryptedAim.getValue(), secretKeySpec);
                break;
            case AES_CBC_NOPADDING:
                cipher.init(encryptedAim.getValue(), secretKeySpec, iv);
                break;
            case AES_CBC_PKCS5_PADDING:
                cipher.init(encryptedAim.getValue(), secretKeySpec, iv);
                break;
            case AES_CBC_PKCS7_PADDING:
                cipher.init(encryptedAim.getValue(), secretKeySpec, iv);
                break;
            case AES_CBC_ZERO_PADDING:
                cipher.init(encryptedAim.getValue(), secretKeySpec, iv);
                break;
            default:
                throw new UtilRuntimeException(550, "Unexpected AES_workMode");
        }
        return cipher;
    }

    private byte[] customerPadding(byte[] target, int blockSize, WorkModeAes workModeAes) {
        byte[] result = null;
        switch (workModeAes) {
            case AES_CBC_ZERO_PADDING:
                int remainder = target.length % blockSize;
                if (remainder != 0) {
                    result = new byte[target.length + (blockSize - (remainder))];
                } else {
                    result = target;
                }
                System.arraycopy(target, 0, result, 0, target.length);
                return result;
            default:
                return target;
        }
    }

    private byte[] customerDePadding(byte[] target, WorkModeAes workModeAes) {
        switch (workModeAes) {
            default:
                return target;
        }
    }

    public String encodeBase64(String target, String key, String ivTemp, WorkModeAes workModeAes) {
        String result;
        try {
            byte[] targetTemp = target.getBytes(CHARSET);
            byte[] keyTemp = key.getBytes(CHARSET);
            IvParameterSpec iv = new IvParameterSpec(ivTemp.getBytes(CHARSET));
            Cipher cipher = initCipher(EncryptedAim.ENCODE, workModeAes, iv, keyTemp);
            targetTemp = customerPadding(targetTemp, cipher.getBlockSize(), workModeAes);
            byte[] resultTemp = cipher.doFinal(targetTemp);
            result = getBase64Encoder(Base64Mode.DEFAULT).encodeToString(resultTemp);
            return result;
        } catch (UnsupportedEncodingException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (NoSuchAlgorithmException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (InvalidKeyException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (NoSuchPaddingException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (BadPaddingException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (IllegalBlockSizeException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (NoSuchProviderException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        }
    }

    public String decodeBase64(String target, String key, String ivTemp, WorkModeAes workModeAes) {
        String result;
        try {
            byte[] targetTemp = target.getBytes(CHARSET);
            byte[] keyTemp = key.getBytes(CHARSET);
            targetTemp = getBase64Decoder(Base64Mode.DEFAULT).decode(targetTemp);
            targetTemp = customerDePadding(targetTemp, workModeAes);
            IvParameterSpec iv = new IvParameterSpec(ivTemp.getBytes(CHARSET));
            Cipher cipher = initCipher(EncryptedAim.DECODE, workModeAes, iv, keyTemp);
            byte[] resultTemp = cipher.doFinal(targetTemp);
            result = new String(resultTemp);
            return result;
        } catch (UnsupportedEncodingException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (NoSuchAlgorithmException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (InvalidKeyException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (NoSuchPaddingException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (BadPaddingException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (IllegalBlockSizeException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        } catch (NoSuchProviderException e) {
            throw new UtilRuntimeException(550, "Method[EncryptHelperAes.encodeBase64()]", e);
        }
    }
}