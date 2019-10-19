package org.xavier.common.util;

import org.junit.Test;
import org.xavier.common.util.bo.User;

import java.util.ArrayList;
import java.util.HashMap;

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
        User user3 = new User();
        user3.setName("李四");
        user3.setAge(11);
        map.put("用户1", user1);
        map.put("用户2", user2);
        map.put("用户3", user3);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        JsonHelper jsonHelper = UtilsCreator.getDefaultJsonHelperInstance(true);

        ArrayList<Integer> list1 = UtilsCreator.getDefaultCollectionHelper().filterCollectionNotEmptyAsArrayList(true, map.values(), "错误", User.class, Integer.class, (u) -> u.getAge());
        ArrayList<Integer> list2 = UtilsCreator.getDefaultCollectionHelper().filterCollectionNotEmptyAsArrayList(true, list, "错误", User.class, Integer.class, (u) -> u.getAge());
        HashMap<String, Integer> map1 = UtilsCreator.getDefaultCollectionHelper().filterCollectionNotEmptyAsHashMap(map.values(), "错误", User.class, String.class, Integer.class, (u) -> u.getName(), (u) -> u.getAge());
        HashMap<String, Integer> map2 = UtilsCreator.getDefaultCollectionHelper().filterCollectionNotEmptyAsHashMap(list, "错误", User.class, String.class, Integer.class, (u) -> u.getName(), (u) -> u.getAge());

        System.out.println(jsonHelper.format(list1));
        System.out.println(jsonHelper.format(list2));
        System.out.println(jsonHelper.format(map1));
        System.out.println(jsonHelper.format(map2));
    }

}