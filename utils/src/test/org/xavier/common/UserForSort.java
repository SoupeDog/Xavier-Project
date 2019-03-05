package org.xavier.common;

import org.xavier.common.utils.bo.BaseSortItem;
import org.xavier.common.utils.bo.CompareRelativeResultEnum;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/3/5
 * @since Jdk 1.8
 */
public class UserForSort implements BaseSortItem<UserForSort> {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public CompareRelativeResultEnum toCompareAnother(UserForSort currentItem, UserForSort anotherItem) {
        if (currentItem.getAge() == anotherItem.getAge()) {
            return CompareRelativeResultEnum.EQUAL;
        } else if (currentItem.getAge() > anotherItem.getAge()) {
            return CompareRelativeResultEnum.BIGGER;
        } else {
            return CompareRelativeResultEnum.SMALLER;
        }
    }

    @Override
    public String toString() {
        return age + "";
    }
}