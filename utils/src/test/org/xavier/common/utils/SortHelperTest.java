package org.xavier.common.utils;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.xavier.common.UserForSort;
import org.xavier.common.utils.bo.SortedTypeEnum;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/5
 * @since Jdk 1.8
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortHelperTest {
    private Integer 目标数量 = 10000;
    private Integer 随机取值范围上边界 = 10000;
    private Integer 随机取值范围下边界 = 0;

    @Test
    public void A_排序校验工具是否有效() {
        ArrayList<UserForSort> list2 = new ArrayList() {{
            add(new UserForSort() {{
                setAge(0);
            }});
            add(new UserForSort() {{
                setAge(1);
            }});
            add(new UserForSort() {{
                setAge(2);
            }});
        }};
        ArrayList<UserForSort> list3 = new ArrayList() {{
            add(new UserForSort() {{
                setAge(100);
            }});
            add(new UserForSort() {{
                setAge(99);
            }});
            add(new UserForSort() {{
                setAge(1);
            }});
        }};
        ArrayList<UserForSort> list4 = new ArrayList() {{
            add(new UserForSort() {{
                setAge(0);
            }});
            add(new UserForSort() {{
                setAge(0);
            }});
            add(new UserForSort() {{
                setAge(0);
            }});
        }};
        ArrayList<UserForSort> list5 = new ArrayList() {{
            add(new UserForSort() {{
                setAge(0);
            }});
            add(new UserForSort() {{
                setAge(2);
            }});
            add(new UserForSort() {{
                setAge(1);
            }});
        }};
        Assert.assertEquals("校验工具检测", SortedTypeEnum.ASC, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list2));
        Assert.assertEquals("校验工具检测", SortedTypeEnum.DESC, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list3));
        Assert.assertEquals("校验工具检测", SortedTypeEnum.DEFAULT, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list4));
        Assert.assertEquals("校验工具检测", SortedTypeEnum.DEFAULT, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list5));
    }


    @Test
    public void B_选择排序测试升序() {
        ArrayList<UserForSort> list = new ArrayList(目标数量);
        for (int i = 0; i < 目标数量; i++) {
            list.add(new UserForSort() {{
                setAge(ThreadLocalRandom.current().nextInt(随机取值范围下边界, 随机取值范围上边界));
            }});
        }
        Long startTs = System.currentTimeMillis();
        UtilsCreator.getInstance_DefaultSortHelper().selectSort(list, 0, list.size(), false);
        Long endTs = System.currentTimeMillis();
        System.out.println("选择排序（升序） 数量级：" + 目标数量 + " 取值范围 ：[" + 随机取值范围下边界 + "," + 随机取值范围上边界 + ") 耗时" + (endTs - startTs) + " ms");
        Assert.assertEquals("选择排序测试升序", SortedTypeEnum.ASC, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list));
        System.out.println(list);
    }

    @Test
    public void B_选择排序测试绛序() {
        ArrayList<UserForSort> list = new ArrayList(目标数量);
        for (int i = 0; i < 目标数量; i++) {
            list.add(new UserForSort() {{
                setAge(ThreadLocalRandom.current().nextInt(随机取值范围下边界, 随机取值范围上边界));
            }});
        }
        Long startTs = System.currentTimeMillis();
        UtilsCreator.getInstance_DefaultSortHelper().selectSort(list, 0, list.size(), true);
        Long endTs = System.currentTimeMillis();
        System.out.println("选择排序（绛序） 数量级：" + 目标数量 + " 取值范围 ：[" + 随机取值范围下边界 + "," + 随机取值范围上边界 + ") 耗时" + (endTs - startTs) + " ms");
        Assert.assertEquals("选择排序测试绛序", SortedTypeEnum.DESC, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list));
        System.out.println(list);
    }

    @Test
    public void C_插入测试升序() {
        ArrayList<UserForSort> list = new ArrayList(目标数量);
        for (int i = 0; i < 目标数量; i++) {
            list.add(new UserForSort() {{
                setAge(ThreadLocalRandom.current().nextInt(随机取值范围下边界, 随机取值范围上边界));
            }});
        }
        Long startTs = System.currentTimeMillis();
        UtilsCreator.getInstance_DefaultSortHelper().insertionSort(list, 0, list.size(), false);
        Long endTs = System.currentTimeMillis();
        System.out.println("插入排序（升序） 数量级：" + 目标数量 + " 取值范围 ：[" + 随机取值范围下边界 + "," + 随机取值范围上边界 + ") 耗时" + (endTs - startTs) + " ms");
        Assert.assertEquals("选择排序测试升序", SortedTypeEnum.ASC, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list));
        System.out.println(list);
    }

    @Test
    public void C_插入排序测试绛序() {
        ArrayList<UserForSort> list = new ArrayList(目标数量);
        for (int i = 0; i < 目标数量; i++) {
            list.add(new UserForSort() {{
                setAge(ThreadLocalRandom.current().nextInt(随机取值范围下边界, 随机取值范围上边界));
            }});
        }
        Long startTs = System.currentTimeMillis();
        UtilsCreator.getInstance_DefaultSortHelper().insertionSort(list, 0, list.size(), true);
        Long endTs = System.currentTimeMillis();
        System.out.println("插入排序（绛序） 数量级：" + 目标数量 + " 取值范围 ：[" + 随机取值范围下边界 + "," + 随机取值范围上边界 + ") 耗时" + (endTs - startTs) + " ms");
        Assert.assertEquals("选择排序测试绛序", SortedTypeEnum.DESC, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list));
        System.out.println(list);
    }

    @Test
    public void D_快速测试升序() {
        ArrayList<UserForSort> list = new ArrayList(目标数量);
        for (int i = 0; i < 目标数量; i++) {
            list.add(new UserForSort() {{
                setAge(ThreadLocalRandom.current().nextInt(随机取值范围下边界, 随机取值范围上边界));
            }});
        }
        Long startTs = System.currentTimeMillis();
        UtilsCreator.getInstance_DefaultSortHelper().quickSort_3Ways(list, 0, list.size(), false);
        Long endTs = System.currentTimeMillis();
        System.out.println("快速排序（升序） 数量级：" + 目标数量 + " 取值范围 ：[" + 随机取值范围下边界 + "," + 随机取值范围上边界 + ") 耗时" + (endTs - startTs) + " ms");
        Assert.assertEquals("选择排序测试升序", SortedTypeEnum.ASC, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list));
        System.out.println(list);
    }

    @Test
    public void D_快速排序测试绛序() {
        ArrayList<UserForSort> list = new ArrayList(目标数量);
        for (int i = 0; i < 目标数量; i++) {
            list.add(new UserForSort() {{
                setAge(ThreadLocalRandom.current().nextInt(随机取值范围下边界, 随机取值范围上边界));
            }});
        }
        Long startTs = System.currentTimeMillis();
        UtilsCreator.getInstance_DefaultSortHelper().quickSort_3Ways(list, 0, list.size(), true);
        Long endTs = System.currentTimeMillis();
        System.out.println("快速排序（绛序） 数量级：" + 目标数量 + " 取值范围 ：[" + 随机取值范围下边界 + "," + 随机取值范围上边界 + ") 耗时" + (endTs - startTs) + " ms");
        Assert.assertEquals("选择排序测试绛序", SortedTypeEnum.DESC, UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list));
        System.out.println(list);
    }


}