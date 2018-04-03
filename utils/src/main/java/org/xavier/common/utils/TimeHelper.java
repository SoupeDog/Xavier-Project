package org.xavier.common.utils;

import java.time.ZonedDateTime;

/**
 * 描述信息：<br/>
 * 时间操作工具类 接口
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/4/2
 * @since Jdk 1.8
 */
public interface TimeHelper {

    /**
     * 获取当前时间距离 x 个自然天后的 00:00:00 000 剩余毫秒数
     *
     * @param x 经过多少个自然日
     * @return 当前时间距离 x 个自然天后的 00:00:00 000 剩余毫秒数
     */
    Long getDeadlineRemain(Integer x);

    /**
     * 获取当前瞬时距离目标时间的剩余毫秒数
     *
     * @param aimDateTime 目标时间
     * @return 当前时间距离 目标时间的剩余毫秒数
     */
    Long getDeadlineRemain(ZonedDateTime aimDateTime);


}
