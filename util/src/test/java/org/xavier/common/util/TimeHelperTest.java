package org.xavier.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 19-10-19
 * @since Jdk 1.8
 */
public class TimeHelperTest {

    public static void unsafe() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 2, TimeUnit.SECONDS, arrayBlockingQueue);
        String[] dateArray = new String[]{
                "2019-08-26 0:00:01",
                "2019-08-26 0:00:02",
                "2019-08-26 0:00:03",
                "2019-08-26 0:00:04",
                "2019-08-26 0:00:05"
        };
        for (String str : dateArray) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(simpleDateFormat.parse(str).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void safe() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneOffset zoneOffset = ZoneOffset.of("+8");
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 2, TimeUnit.SECONDS, arrayBlockingQueue);
        String[] dateArray = new String[]{
                "2019-08-26 12:00:01",
                "2019-08-26 12:00:02",
                "2019-08-26 12:00:03",
                "2019-08-26 12:00:04",
                "2019-08-26 12:00:05"
        };
        for (String str : dateArray) {
            threadPoolExecutor.execute(() -> {
                LocalDateTime targetLocalTime = LocalDateTime.parse(str, dateTimeFormatter);
                System.out.println(targetLocalTime.toInstant(zoneOffset).toEpochMilli());
            });
        }
    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);

//        DateTimeFormatter yyyyMMddHHmmssSSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
//        System.out.println(LocalDateTime.parse("20190821000000000", yyyyMMddHHmmssSSS));
        System.out.println(UtilsCreator.getDefaultTimeHelperInstance().parse("20190826234550123", TimeHelper.TimeFormatEnum.yyyyMMddHHmmssSSS));
//        Test.unsafe();
//        Test.safe();
    }
}