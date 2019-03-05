package org.xavier.common.utils.impl;

import org.xavier.common.utils.SortHelper;
import org.xavier.common.utils.UtilsCreator;
import org.xavier.common.utils.bo.BaseSortItem;

import java.util.ArrayList;
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
    public void selectSort(List<? extends BaseSortItem> target, int startPoint, int endPoint, Boolean isDESC) {
        UtilsCreator.getInstance_DefaultPropertiesHelper().intRange(startPoint, 0, target.size() - 1, "左边界");
        UtilsCreator.getInstance_DefaultPropertiesHelper().intRange(endPoint, startPoint + 1, target.size(), "右边界");
        int leftCursor = startPoint;
        int rightCursor = endPoint;
        if(isDESC==null||!isDESC){
            int minIndex;
            for (int i = leftCursor; i < rightCursor; i++) {
                minIndex = getIndexOfMin(target, i, rightCursor);
                if (i != minIndex) {
                    Collections.swap(target, i, minIndex);
                }
            }
        }else {
            int maxIndex;
            for (int i = leftCursor; i < rightCursor; i++) {
                maxIndex = getIndexOfMax(target, i, rightCursor);
                if (i != maxIndex) {
                    Collections.swap(target, i, maxIndex);
                }
            }
        }
    }

    private int getIndexOfMin(List<? extends BaseSortItem> target, int leftCursor, int rightCursor) {
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

    private int getIndexOfMax(List<? extends BaseSortItem> target, int leftCursor, int rightCursor) {
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
}