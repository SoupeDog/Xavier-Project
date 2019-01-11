package org.xavier.common.utils;


import org.xavier.common.utils.bo.BaseSortItem;

import java.util.ArrayList;
import java.util.Random;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019.01.11
 * @since Jdk 1.8
 */
public class SortHelperTest {
    static class MySortItem extends BaseSortItem<Integer> {
        @Override
        public int getCount() {
            return getTargetObj();
        }

        @Override
        public String toString() {
            return getTargetObj().toString();
        }
    }

    public static ArrayList<BaseSortItem> createList(Integer max, Integer size) {
        Random random = new Random();
        ArrayList<BaseSortItem> result = new ArrayList();
        for (int i = 0; i < size; i++) {
            MySortItem temp = new MySortItem();
            temp.setTargetObj(random.nextInt(max));
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<BaseSortItem> tartget = createList(1001, 100);
        System.out.println(tartget);
        System.out.println("--------------------排序前-----------------------");
        JsonHelper jsonHelper = UtilsCreator.getInstance_DefaultJsonHelper(true);
//        System.out.println(jsonHelper.format(createList(10, 100)));
        SortHelper sortHelper = UtilsCreator.getInstance_DefaultSortHelper();
//        System.out.println(sortHelper.getIndexOfTopK(tartget, 3));
        sortHelper.quickSort(tartget, false);
        System.out.println(tartget);
    }
}