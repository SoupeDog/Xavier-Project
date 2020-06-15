package org.xavier.common.util;

import org.xavier.common.util.bo.User;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 20-3-23
 * @since Jdk 1.8
 */
public class SortHelperTest {
    public static void main(String[] args) {

        String a = "ab";
        String b = "a" + "b";
        String c = new String("ab");
        System.out.println(a == b);
        System.out.println(c == b);


//        SortHelper sortHelper = new SortHelper() {
//            @Override
//            public <T> SortOrder analysisSortOrder(Collection<T> collection, Comparator<T> comparator) {
//                return null;
//            }
//
//            @Override
//            public <T> SortOrder analysisSortOrder(Map<?, T> map, Comparator<T> comparator, int checkCount) {
//                return null;
//            }
//        };
//
//        HashMap<User, Integer> map = new HashMap<>();
//
//        sortHelper.analysisSortOrder(map, (o1, o2) -> 0, 1);
    }

}