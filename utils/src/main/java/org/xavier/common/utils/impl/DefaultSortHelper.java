package org.xavier.common.utils.impl;

import org.xavier.common.utils.SortHelper;
import org.xavier.common.utils.UtilsCreator;
import org.xavier.common.utils.bo.BaseSortItem;
import org.xavier.common.utils.bo.CompareRelativeResultEnum;

import java.util.Collections;
import java.util.List;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.11.30
 * @since Jdk 1.8
 */
public class DefaultSortHelper implements SortHelper {
    @Override
    public <T extends BaseSortItem> void selectSort(List<T> target, int startPoint, int endPoint, Boolean isDESC) {
        UtilsCreator.getInstance_DefaultPropertiesHelper().intRange(startPoint, 0, target.size(), "左边界");
        UtilsCreator.getInstance_DefaultPropertiesHelper().intRange(endPoint, startPoint + 1, target.size(), "右边界");
        int leftCursor = startPoint;
        int rightCursor = endPoint;
        if (isDESC == null || !isDESC) {
            int minIndex;
            for (int i = leftCursor; i < rightCursor; i++) {
                minIndex = getIndexOfMin(target, i, rightCursor);
                if (i != minIndex) {
                    Collections.swap(target, i, minIndex);
                }
            }
        } else {
            int maxIndex;
            for (int i = leftCursor; i < rightCursor; i++) {
                maxIndex = getIndexOfMax(target, i, rightCursor);
                if (i != maxIndex) {
                    Collections.swap(target, i, maxIndex);
                }
            }
        }
    }

    private <T extends BaseSortItem> int getIndexOfMin(List<T> target, int leftCursor, int rightCursor) {
        int result = leftCursor;
        BaseSortItem resultObj = target.get(result);
        for (int i = leftCursor; i < rightCursor; i++) {
            switch (resultObj.toCompareAnother(resultObj, target.get(i))) {
                case BIGGER:
                    result = i;
                    resultObj = target.get(i);
                    break;
            }
        }
        return result;
    }

    private <T extends BaseSortItem> int getIndexOfMax(List<T> target, int leftCursor, int rightCursor) {
        int result = leftCursor;
        BaseSortItem resultObj = target.get(result);
        for (int i = leftCursor; i < rightCursor; i++) {
            switch (resultObj.toCompareAnother(resultObj, target.get(i))) {
                case SMALLER:
                    resultObj = target.get(i);
                    result = i;
                    break;
            }
        }
        return result;
    }


    @Override
    public <T extends BaseSortItem> void insertionSort(List<T> target, int startPoint, int endPoint, Boolean isDESC) {
        UtilsCreator.getInstance_DefaultPropertiesHelper().intRange(startPoint, 0, target.size(), "左边界");
        UtilsCreator.getInstance_DefaultPropertiesHelper().intRange(endPoint, startPoint + 1, target.size(), "右边界");
        T currentItem;
        if (isDESC == null || !isDESC) {
            for (int i = startPoint + 1; i < endPoint; i++) {
                currentItem = target.get(i);
                int j;
                for (j = i; j > 0 && CompareRelativeResultEnum.SMALLER.equals(currentItem.toCompareAnother(currentItem, target.get(j - 1))); j--) {
                    target.set(j, target.get(j - 1));
                }
                target.set(j, currentItem);
            }
        }else {
            for (int i = startPoint + 1; i < endPoint; i++) {
                currentItem = target.get(i);
                int j;
                for (j = i; j > 0 && CompareRelativeResultEnum.BIGGER.equals(currentItem.toCompareAnother(currentItem, target.get(j - 1))); j--) {
                    target.set(j, target.get(j - 1));
                }
                target.set(j, currentItem);
            }
        }
    }
}