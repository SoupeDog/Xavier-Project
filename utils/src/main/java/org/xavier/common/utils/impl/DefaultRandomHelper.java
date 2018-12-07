package org.xavier.common.utils.impl;

import org.xavier.common.utils.base.BaseRandomHelper;

/**
 * 描述信息：<br/>
 * 不做任何额外处理的基本 RandomHelper
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.12.22
 * @since Jdk 1.8
 */
public class DefaultRandomHelper extends BaseRandomHelper {
    @Override
    protected char hook_singleChar(char singleChar) {
        switch (singleChar) {
            // 数字0被替换成2
            case '0':
                singleChar = '2';
                break;
            // 大写字母 O 被替换成 X
            case 'O':
                singleChar = 'X';
                break;
            // 小写字母 o 被替换成 x
            case 'o':
                singleChar = 'x';
                break;
            default:
                break;
        }
        return singleChar;
    }
}
