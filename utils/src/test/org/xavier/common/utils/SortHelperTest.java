package org.xavier.common.utils;

import org.junit.Assert;
import org.junit.Test;
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
public class SortHelperTest {
    @Test
    public void 排序校验工具是否有效() {
        ArrayList<UserForSort> list = new ArrayList();
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
        for (int i = 0; i < 100; i++) {
            list.add(new UserForSort() {{
                setAge(ThreadLocalRandom.current().nextInt(0, 100));
            }});
        }
        System.out.println(list);

        Assert.assertEquals("校验工具检测", SortedTypeEnum.ASC,UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list2));
        Assert.assertEquals("校验工具检测", SortedTypeEnum.DESC,UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list3));
        Assert.assertEquals("校验工具检测", SortedTypeEnum.DEFAULT,UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list4));
        Assert.assertEquals("校验工具检测", SortedTypeEnum.DEFAULT,UtilsCreator.getInstance_DefaultListHelper().checkSorttedType(list5));
    }
}