package org.xavier.common.util;

import org.xavier.common.enums.StringFormatMode;
import org.xavier.common.util.enums.Base64Mode;
import org.xavier.common.util.exception.UtilRuntimeException;

import java.util.Base64;

/**
 * 描述信息：<br/>
 * 签名、加密工具接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/8/24
 * @since Jdk 1.8
 */
public interface EncryptHelper {
    String DEFAULT_PATH = "org.xavier.common.util.impl.EncryptHelperAes";

    /**
     * 返回一个默认工具（这个方法会影响到 org.xavier.common.util.UtilsCreator 的静态实例）
     *
     * @return 默认工具
     */
    static EncryptHelper createHelper() {
        try {
            Class defaultClass = EncryptHelper.class.getClassLoader().loadClass(DEFAULT_PATH);
            Object resultTemp = defaultClass.newInstance();
            if (!(resultTemp instanceof EncryptHelper)) {
                throw new UtilRuntimeException(String.format("Class(%s) should implement EncryptHelper.", DEFAULT_PATH));
            }
            return (EncryptHelper) resultTemp;
        } catch (ClassNotFoundException e) {
            throw new UtilRuntimeException(String.format("Class(%s) was not found.", DEFAULT_PATH));
        } catch (IllegalAccessException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        } catch (InstantiationException e) {
            throw new UtilRuntimeException(String.format("Fail to create instance of Class(%s).", DEFAULT_PATH));
        }
    }

    /**
     * 获取 Base64 处理工具
     *
     * @param type Base64 类型
     * @return 返回 Base64 工具
     */
    Base64.Encoder getBase64Encoder(Base64Mode type);

    /**
     * 获取 Base64 解析处理工具
     *
     * @param type Base64 类型
     * @return 返回 Base64 解析工具
     */
    Base64.Decoder getBase64Decoder(Base64Mode type);

    /**
     * 将字节数组转化为 Hex 编码
     *
     * @param target           目标字节数组
     * @param stringFormatMode 返回的字符串类型
     * @return Hex 编码的目标字节数组
     */
    String byteArrayToHex(byte[] target, StringFormatMode stringFormatMode);


    /**
     * 根据秘钥将目标进行 MD5 签名并输出 16 位 Hex 编码
     *
     * @param target           签名对象
     * @param secretKey        秘钥
     * @param stringFormatMode 输出模式
     * @return 签名后的值
     */
    String md5Sign16(String target, String secretKey, StringFormatMode stringFormatMode);

    /**
     * 根据秘钥将目标进行 MD5 签名并输出 32 位 Hex 编码
     *
     * @param target           签名对象
     * @param secretKey        秘钥
     * @param stringFormatMode 输出模式
     * @return 签名后的值
     */
    String md5Sign32(String target, String secretKey, StringFormatMode stringFormatMode);
}