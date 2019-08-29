package org.xavier.common.util.bo;

import org.junit.Test;
import org.xavier.common.util.UtilsCreator;

import java.util.TreeSet;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/8/30
 * @since Jdk 1.8
 */
public class SnowFlakeFactoryTest {
    @Test
    public void test() {
        SnowFlakeFactory snowflakeFactory = UtilsCreator.getDefaultRandomHelperInstance().getDefaultSnowFlakeFactory();
        snowflakeFactory.init(1, 1);
        TreeSet<Long> set = new TreeSet();
        long v = 0;
        long startTs = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            v = snowflakeFactory.createKey();
            set.add(v);
//            System.out.println(v);
        }
        System.out.println(set.size());
        System.out.println("耗时: " + (System.currentTimeMillis() - startTs) + " ms");
    }
}