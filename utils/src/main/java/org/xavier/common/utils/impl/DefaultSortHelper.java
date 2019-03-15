package org.xavier.common.utils.impl;

import org.xavier.common.utils.SortHelper;
import org.xavier.common.utils.UtilsCreator;
import org.xavier.common.utils.bo.BaseSortItem;
import org.xavier.common.utils.bo.CompareRelativeResultEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.BaseStream;

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
        } else {
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

    @Override
    public <T extends BaseSortItem> void mergeSort(List<T> target, int startPoint, int endPoint, Boolean isDESC) {
        if (startPoint >= endPoint) {
            return;
        }
        int midPoint = startPoint - (endPoint - startPoint) / 2;
        mergeSort(target, startPoint, midPoint, isDESC);
        mergeSort(target, midPoint + 1, endPoint, isDESC);
        doMerge(target, startPoint, midPoint, endPoint, isDESC);
    }

    private <T extends BaseSortItem> void doMerge(List<T> target, int startPoint, int midPoint, int endPoint, Boolean isDESC) {
        List<T> tempList = new ArrayList((endPoint - startPoint + 1));
        for (int i = startPoint; i <= endPoint; i++) {
            tempList.add(target.get(i));
        }
        if (isDESC) {
            // 临时 List 左端索引
            int tempListCursorLeft = startPoint;
            // 临时 List 右端索引
            int tempListCursorRight = midPoint + 1;
            // 临时 List 左右索引指向的对象
            T tempItemLeft, tempItemRight;
            for (int k = startPoint; k <= endPoint; k++) {
                // 归并的左半部分已经使用完
                if (tempListCursorLeft > midPoint) {
                    tempItemRight = tempList.get(tempListCursorRight - startPoint);
                    target.set(k, tempItemRight);
                    tempListCursorRight++;
                    // 归并的由半部分已经使用完
                } else if (tempListCursorRight > endPoint) {
                    tempItemLeft = tempList.get(tempListCursorLeft - startPoint);
                    target.set(k, tempItemLeft);
                    tempListCursorLeft++;
                    // 归并的左右两端均存在待排序元素
                } else {
                    tempItemLeft = tempList.get(tempListCursorLeft - startPoint);
                    tempItemRight = tempList.get(tempListCursorRight - startPoint);
                    if (CompareRelativeResultEnum.SMALLER.equals(tempItemLeft.toCompareAnother(tempItemLeft, tempItemRight))) {
                        target.set(k, tempItemRight);
                        tempListCursorRight++;
                    } else {
                        target.set(k, tempItemLeft);
                        tempListCursorLeft++;
                    }
                }
            }
        } else {
            // 临时 List 左端索引
            int tempListCursorLeft = startPoint;
            // 临时 List 右端索引
            int tempListCursorRight = midPoint + 1;
            // 临时 List 左右索引指向的对象
            T tempItemLeft, tempItemRight;
            for (int k = startPoint; k <= endPoint; k++) {
                // 归并的左半部分已经使用完
                if (tempListCursorLeft > midPoint) {
                    tempItemRight = tempList.get(tempListCursorRight - startPoint);
                    target.set(k, tempItemRight);
                    tempListCursorRight++;
                    // 归并的由半部分已经使用完
                } else if (tempListCursorRight > endPoint) {
                    tempItemLeft = tempList.get(tempListCursorLeft - startPoint);
                    target.set(k, tempItemLeft);
                    tempListCursorLeft++;
                    // 归并的左右两端均存在待排序元素
                } else {
                    tempItemLeft = tempList.get(tempListCursorLeft - startPoint);
                    tempItemRight = tempList.get(tempListCursorRight - startPoint);
                    if (CompareRelativeResultEnum.BIGGER.equals(tempItemLeft.toCompareAnother(tempItemLeft, tempItemRight))) {
                        target.set(k, tempItemRight);
                        tempListCursorRight++;
                    } else {
                        target.set(k, tempItemLeft);
                        tempListCursorLeft++;
                    }
                }
            }
        }
    }

    public <T extends BaseSortItem> void quickSort_3Ways(List<T> target, int startPoint, int endPoint, Boolean isDESC) {
        if (startPoint >= endPoint) {
            return;
        }
        // 产生随机扰动，减少近乎有序的目标使算法性能下降
        Collections.swap(target, startPoint, ThreadLocalRandom.current().nextInt(startPoint, endPoint));
        // 基准值
        T temp = target.get(startPoint);
        int leftCursor = startPoint;
        int midCursor = startPoint + 1;
        int rightCursor = endPoint;

        if (isDESC) {
            while (midCursor < rightCursor) {
                switch (temp.toCompareAnother(temp, target.get(midCursor))) {
                    case SMALLER:
                        Collections.swap(target, leftCursor + 1, midCursor);
                        leftCursor++;
                        midCursor++;
                        break;
                    case BIGGER:
                        Collections.swap(target, midCursor, rightCursor - 1);
                        rightCursor--;
                        break;
                    case EQUAL:
                        midCursor++;
                        break;
                }
            }
        } else {
            while (midCursor < rightCursor) {
                switch (temp.toCompareAnother(temp, target.get(midCursor))) {
                    case SMALLER:
                        Collections.swap(target, midCursor, rightCursor - 1);
                        rightCursor--;
                        break;
                    case BIGGER:
                        Collections.swap(target, leftCursor + 1, midCursor);
                        leftCursor++;
                        midCursor++;
                        break;
                    case EQUAL:
                        midCursor++;
                        break;
                }
            }
        }
        Collections.swap(target, startPoint, leftCursor);
        quickSort_3Ways(target, startPoint, leftCursor, isDESC);
        quickSort_3Ways(target, rightCursor, endPoint, isDESC);
    }

    @Override
    public <T extends BaseSortItem> void topK(List<T> target, int startPoint, int endPoint, int k, Boolean isDESC) {
        if (startPoint == endPoint) {
            return;
        }
        int index = partitionOfTopK(target, startPoint, endPoint, isDESC);
        if (index - k - startPoint >= 0) {
            topK(target, startPoint, index, k, isDESC); //求前半部分第k大
        } else {
            topK(target, index + 1, endPoint, k - (index - startPoint) - 1, isDESC); //求前半部分第k-(index - startPoint)大
        }
    }

    private <T extends BaseSortItem> int partitionOfTopK(List<T> target, int startPoint, int endPoint, Boolean isDESC) {
        // 产生随机扰动，减少近乎有序的目标使算法性能下降
        Collections.swap(target, startPoint, ThreadLocalRandom.current().nextInt(startPoint, endPoint));
        // 基准值
        T temp = target.get(startPoint);
        int rightCursor = endPoint;
        int leftCursor = startPoint;
        int midCursor = startPoint + 1;

        if (isDESC) {
            while (midCursor < rightCursor) {
                switch (temp.toCompareAnother(temp, target.get(midCursor))) {
                    case SMALLER:
                        Collections.swap(target, leftCursor + 1, midCursor);
                        leftCursor++;
                        midCursor++;
                        break;
                    case BIGGER:
                        Collections.swap(target, midCursor, rightCursor - 1);
                        rightCursor--;
                        break;
                    case EQUAL:
                        midCursor++;
                }
            }
        } else {
            while (midCursor < rightCursor) {
                switch (temp.toCompareAnother(temp, target.get(midCursor))) {
                    case SMALLER:
                        Collections.swap(target, midCursor, rightCursor - 1);
                        rightCursor--;
                        break;
                    case BIGGER:
                        Collections.swap(target, leftCursor + 1, midCursor);
                        leftCursor++;
                        midCursor++;
                        break;
                    case EQUAL:
                        midCursor++;
                }
            }
        }
        Collections.swap(target, startPoint, leftCursor);
        return rightCursor - 1;
    }
}