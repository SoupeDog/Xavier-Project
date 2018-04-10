package org.xavier.common.utils.impl;

import org.xavier.common.exception.Universal_500_X_Exception;
import org.xavier.common.exception.Universal_500_X_Exception_Runtime;
import org.xavier.common.utils.base.BaseEncryptHelper;
import org.xavier.common.utils.bo.encrypt.Base64Mode;
import org.xavier.common.utils.bo.encrypt.EncryptedAim;
import org.xavier.common.utils.bo.encrypt.WorkMode_AES;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * 描述信息：<br/>
 * AES 的加解密工具
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.04.10
 * @since Jdk 1.8
 */
public class EncryptHelper_AES extends BaseEncryptHelper {

    private static final String CHARSET = "utf-8";

    private Cipher initCipher(EncryptedAim encryptedAim, WorkMode_AES workMode_aes, IvParameterSpec iv, byte[] key_byte) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, Universal_500_X_Exception, NoSuchProviderException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key_byte, "AES");
        Cipher cipher = Cipher.getInstance(workMode_aes.getVal(), "BC");  // 指定加密的算法、工作模式和填充方式
        switch (workMode_aes) {
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
                throw new Universal_500_X_Exception(555F, "Unexpected AES_workMode");
        }
        return cipher;
    }

    private byte[] customerPadding(byte[] target, int blockSize, WorkMode_AES workMode_aes) {
        byte[] result = null;
        switch (workMode_aes) {
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

    private byte[] customerDePadding(byte[] target, WorkMode_AES workMode_aes) {
        switch (workMode_aes) {
            default:
                return target;
        }
    }

    public String encode_Base64(String target, String key, String ivTemp, WorkMode_AES workMode_aes) {
        String result;
        try {
            byte[] targetTemp = target.getBytes(CHARSET);
            byte[] keyTemp = key.getBytes(CHARSET);
            IvParameterSpec iv = new IvParameterSpec(ivTemp.getBytes(CHARSET));
            Cipher cipher = initCipher(EncryptedAim.ENCODE, workMode_aes, iv, keyTemp);
            targetTemp = customerPadding(targetTemp, cipher.getBlockSize(), workMode_aes);
            byte[] resultTemp = cipher.doFinal(targetTemp);
            result = getBase64Encoder(Base64Mode.DEFAULT).encodeToString(resultTemp);
            return result;
        } catch (UnsupportedEncodingException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (NoSuchAlgorithmException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (InvalidKeyException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (NoSuchPaddingException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (Universal_500_X_Exception e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (BadPaddingException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (IllegalBlockSizeException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (NoSuchProviderException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        }
    }

    public String decode_Base64(String target, String key, String ivTemp, WorkMode_AES workMode_aes) throws Universal_500_X_Exception {
        String result;
        try {
            byte[] targetTemp = target.getBytes(CHARSET);
            byte[] keyTemp = key.getBytes(CHARSET);
            targetTemp = getBase64Decoder(Base64Mode.DEFAULT).decode(targetTemp);
            targetTemp = customerDePadding(targetTemp, workMode_aes);
            IvParameterSpec iv = new IvParameterSpec(ivTemp.getBytes(CHARSET));
            Cipher cipher = initCipher(EncryptedAim.DECODE, workMode_aes, iv, keyTemp);
            byte[] resultTemp = cipher.doFinal(targetTemp);
            result = new String(resultTemp);
            return result;
        } catch (UnsupportedEncodingException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (NoSuchAlgorithmException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (InvalidKeyException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (NoSuchPaddingException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (Universal_500_X_Exception e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (BadPaddingException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (IllegalBlockSizeException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        } catch (NoSuchProviderException e) {
            throw new Universal_500_X_Exception_Runtime(555F, "Method[EncryptHelper_AES.encode_Base64()]", e);
        }
    }
}
