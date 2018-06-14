package org.xavier.common.utils.base;

import org.xavier.common.exception.Universal_400_X_Exception_Runtime;
import org.xavier.common.enums.StringCategory;
import org.xavier.common.utils.RandomHelper;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 描述信息：<br/>
 * 随机工具类主基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2017.12.22
 * @since Jdk 1.8
 */
public abstract class BaseRandomHelper implements RandomHelper {

    /**
     * 每次生成单个随机字符时触发,返回的 char 会影响最后生成字符
     *
     * @param singleChar 当前生成的单个字符
     */
    protected abstract char hook_singleChar(char singleChar);

    @Override
    public String getRandomString(Integer size, StringCategory... stringCategory) {
        if (size < 1) {
            throw new Universal_400_X_Exception_Runtime("[size] should more than 0 .");
        }
        StringCategory[] stringCategories = stringCategory.clone();
        StringBuilder stringBuilder = new StringBuilder();
        int currentStringCategorieIndex = 0;
        StringCategory currentStringCategorie;
        char randomTemp;
        for (int i = 0; i < size; i++) {
            currentStringCategorieIndex = ThreadLocalRandom.current().nextInt(stringCategories.length);
            currentStringCategorie = stringCategories[currentStringCategorieIndex];
            randomTemp = (char) ThreadLocalRandom.current().nextInt(currentStringCategorie.getAsciiStartPoint(), currentStringCategorie.getAsciiStartPoint() + currentStringCategorie.getTotalSize());
            randomTemp = hook_singleChar(randomTemp);
            stringBuilder.append(randomTemp);
        }
        return stringBuilder.toString();
    }

    @Override
    public String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
