package org.xavier.common.util.bo;

import org.xavier.common.util.exception.UtilRuntimeException;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/8/29
 * @since Jdk 1.8
 */
public class SnowFlakeFactory {
    /**
     * 可自定义部分
     */
    private static final int CUSTOM_LENGTH = 63;
    /*
     * 样例模板
     * 64 位 63=(part1 + part2 + seqPart + tsPart)
     * 0 - part1 - part2 - seqPart - tsPart
     * */

    /**
     * 起始时间戳
     */
    private long startTs;

    /**
     * 会出现重复的最早时间
     */
    private long endTs;

    /**
     * 左起第一部分 位数
     */
    private int part1Length;

    /**
     * 左起第二部分 位数
     */
    private int part2Length;

    /**
     * 自增序列部分 位数
     */
    private int indexPartLength;

    /**
     * 自增序列部分 位数
     */
    private int tsPartLength;

    /**
     * 左起第一部分 最大值
     */
    private long part1MaxVal;
    /**
     * 左起第二部分 最大值
     */
    private long part2MaxVal;
    /**
     * 自增序列部分 最大值
     */
    private long indexPartMaxVal;

    /**
     * 左起第一部分 按位或 目标
     */
    private long part1OrTarget;
    /**
     * 左起第二部分 按位或 目标
     */
    private long part2OrTarget;
    /**
     * 左起稳定部分 按位或 目标
     */
    private long stablePartOrTarget;

    /**
     * 自增计数器
     */
    private long index = 0;

    /**
     * 上一个时间戳
     */
    private long lastTs = -1L;

    public SnowFlakeFactory(Long startTs, Number part1Length, Number part2Length, Number indexPartLength) {
        if ((part1Length.intValue() + part2Length.intValue() + indexPartLength.intValue()) >= CUSTOM_LENGTH) {
            throw new UtilRuntimeException(550, "Unexpected init properties of SnowFlakeFactory.");
        }
        this.startTs = startTs;
        this.part1Length = part1Length.intValue();
        this.part2Length = part2Length.intValue();
        this.indexPartLength = indexPartLength.intValue();
        this.tsPartLength = CUSTOM_LENGTH - this.part1Length - this.part2Length - this.indexPartLength;
        this.endTs = startTs + (-1L ^ (-1L << this.tsPartLength));
        this.part1MaxVal = -1L ^ (-1L << this.part1Length);
        this.part2MaxVal = -1L ^ (-1L << this.part2Length);
        this.indexPartMaxVal = -1L ^ (-1L << this.indexPartLength);
    }

    public void init(Number part1Val, Number part2Val) {
        if (part1Val.intValue() > this.part1MaxVal) {
            throw new UtilRuntimeException(550, "Unexpected part1Val,it should less than" + this.part1MaxVal + ".");
        }
        this.part1OrTarget = part1Val.longValue() << (tsPartLength + indexPartLength + part2Length);
        if (part2Val.intValue() > this.part2MaxVal) {
            throw new UtilRuntimeException(550, "Unexpected part2Val,it should less than" + this.part2MaxVal + ".");
        }
        this.part2OrTarget = part1Val.longValue() << (tsPartLength + indexPartLength);
        this.stablePartOrTarget = part1OrTarget | part2OrTarget;
    }

    public synchronized long createKey() {
        long currentTs = System.currentTimeMillis();
        if (currentTs >= endTs) {
            throw new UtilRuntimeException(550, "Unexpected currentTs[" + currentTs + "].([endTs]:" + endTs + ")");
        }
        long result;
        if (currentTs == lastTs) {
            if (index >= indexPartMaxVal) {
                index = 0;
                currentTs = blockToGetNextTs(currentTs);
            }
            result = calculateKey(currentTs - startTs);
            lastTs = currentTs;
        } else {
            if (currentTs > lastTs) {
                index = 0;
                result = calculateKey(currentTs - startTs);
                lastTs = currentTs;
            } else {
                // 时间发生回滚
                throw new UtilRuntimeException(550, "Unexpected currentTs[" + currentTs + "].([lastTs]:" + lastTs + ")");
            }
        }
        return result;
    }

    /**
     * 自旋阻塞到下一个时间戳
     *
     * @param currentTs 当前时间戳
     * @return 下一个时间戳
     */
    private synchronized long blockToGetNextTs(long currentTs) {
        long result = System.currentTimeMillis();
        while (result <= currentTs) {
            result = System.currentTimeMillis();
        }
        return result;
    }

    /**
     * 运算出一个 key
     */
    private synchronized long calculateKey(long tsPart) {
        long result = stablePartOrTarget
                | index << tsPartLength
                | tsPart;
        index += 1;
        return result;
    }
}