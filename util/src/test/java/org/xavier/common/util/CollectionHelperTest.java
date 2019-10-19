package org.xavier.common.util;

import org.junit.Test;
import org.xavier.common.util.bo.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 19-10-19
 * @since Jdk 1.8
 */
public class CollectionHelperTest {
    @Test
    public void filterCollectionNotEmpty() {
        HashMap<String, User> map = new HashMap<>();
        ArrayList<User> list = new ArrayList<>();

        User user1 = new User();
        user1.setName("张三");
        user1.setAge(10);
        User user2 = new User();
        user2.setName("李四");
        user2.setAge(11);
        map.put("用户1", user1);
        map.put("用户2", user2);
        list.add(user1);
        list.add(user2);

        JsonHelper jsonHelper = UtilsCreator.getDefaultJsonHelperInstance(true);

        ArrayList<Integer> list1 = UtilsCreator.getDefaultCollectionHelper().filterCollectionNotEmpty(map.values(), "错误", User.class, Integer.class, (u) -> u.getAge());
        ArrayList<Integer> list2 = UtilsCreator.getDefaultCollectionHelper().filterCollectionNotEmpty(list, "错误", User.class, Integer.class, (u) -> u.getAge());

        System.out.println(jsonHelper.format(list1));
        System.out.println(jsonHelper.format(list2));
    }

}