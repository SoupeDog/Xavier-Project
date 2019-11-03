package org.xavier.webtoolkit.domain;

import java.util.ArrayList;

/**
 * 描述信息：<br/>
 * 分页对象
 *
 * @author Xavier
 * @version 1.0
 * @date 19-11-3
 * @since Jdk 1.8
 */
public class PageResult<T> {
    private Integer totalCount;
    private ArrayList<T> resultSet;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<T> getResultSet() {
        return resultSet;
    }

    public void setResultSet(ArrayList<T> resultSet) {
        this.resultSet = resultSet;
    }
}