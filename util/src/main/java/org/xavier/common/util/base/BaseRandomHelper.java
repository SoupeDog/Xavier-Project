package org.xavier.common.util.base;

import org.xavier.common.enums.StringCategory;
import org.xavier.common.exception.PropertiesRuntimeException;
import org.xavier.common.util.RandomHelper;
import org.xavier.common.util.bo.SnowFlakeFactory;

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
     * @param singleChar 当前生成的单个随机字符
     * @return 处理后的随机字符
     */
    protected abstract char hookSingleChar(char singleChar);

    @Override
    public int getRandomInteger(Number minValue, Number maxValue) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(minValue.intValue(), maxValue.intValue() + 1);
    }

    @Override
    public String getRandomString(Integer size, StringCategory... stringCategory) {
        if (size < 1) {
            throw new PropertiesRuntimeException("[size] should more than 0 .");
        }
        StringCategory[] stringCategories = stringCategory.clone();
        StringBuilder stringBuilder = new StringBuilder();
        int currentStringCategoryIndex;
        StringCategory currentStringCategory;
        char randomTemp;
        for (int i = 0; i < size; i++) {
            currentStringCategoryIndex = ThreadLocalRandom.current().nextInt(stringCategories.length);
            currentStringCategory = stringCategories[currentStringCategoryIndex];
            randomTemp = (char) ThreadLocalRandom.current().nextInt(currentStringCategory.getAsciiStartPoint(), currentStringCategory.getAsciiStartPoint() + currentStringCategory.getTotalSize());
            randomTemp = hookSingleChar(randomTemp);
            stringBuilder.append(randomTemp);
        }
        return stringBuilder.toString();
    }

    @Override
    public String getUniversallyUniqueIdentifier() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public SnowFlakeFactory getDefaultSnowFlakeFactory() {
        return new SnowFlakeFactory(803966400000L, 2, 2, 12);
    }
}