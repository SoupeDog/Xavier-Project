package org.xavier.common.utils.base;

import org.xavier.common.exception.base.ServiceException_Runtime;
import org.xavier.common.utils.TimeHelper;

import java.time.*;

/**
 * 描述信息：<br/>
 * 基于 TimeHelper 的 时间工具主基类
 *
 * @author Xavier
 * @version 1.0
 * @date 2018/4/2
 * @since Jdk 1.8
 */
public class BaseTimeHelper implements TimeHelper {
    /**
     * 默认该工具环境为 东八区
     */
    private static ZoneId CHINA = ZoneId.of("Asia/Shanghai");
    /**
     * 一分钟有多少秒
     */
    public static final Integer MINUTE_SECOND = 60;
    /**
     * 一天有多少秒
     */
    public static final Integer DAY_SECOND = 86400;

    public static void main(String[] args) {
        BaseTimeHelper baseTimeHelper = new BaseTimeHelper();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 2, 21, 0, 0, 0, 0, CHINA);
        System.out.println(baseTimeHelper.getDeadlineRemain(1));
    }

    @Override
    public Long getDeadlineRemain(Integer x) {
        ZonedDateTime currentDateTime = ZonedDateTime.now(CHINA);
        ZonedDateTime aimDateTime = ZonedDateTime.of(currentDateTime.getYear(), currentDateTime.getMonth().getValue(), currentDateTime.getDayOfMonth() + x, 0, 0, 0, 0, CHINA);
        if (!aimDateTime.isAfter(currentDateTime)) {
            throw new ServiceException_Runtime("已过期");
        }
        return aimDateTime.toInstant().toEpochMilli() - currentDateTime.toInstant().toEpochMilli();
    }

    @Override
    public Integer getDeadlineRemain(ZonedDateTime dommsday) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime dommsdayDateTime = LocalDateTime.ofInstant(dommsday.toInstant(), ZoneId.systemDefault());
        Period period = Period.between(currentDateTime.toLocalDate(), dommsdayDateTime.toLocalDate());
        return period.getYears();
    }

    public static ZoneId getZoneId() {
        return CHINA;
    }

    public static void setZoneId(ZoneId zoneId) {
        CHINA = zoneId;
    }
}
