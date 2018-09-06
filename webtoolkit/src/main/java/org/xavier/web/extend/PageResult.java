package org.xavier.web.extend;

import java.util.ArrayList;

/**
 * 描述信息：<br/>
 * 分页查询结果集
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.09.06
 * @since Jdk 1.8
 */
public class PageResult<T> {
    /**
     * 查询结果集
     */
    private ArrayList<T> resultSet;
    /**
     * 总结果集条数
     */
    private Integer totalCount;

    public ArrayList<T> getResultSet() {
        return resultSet;
    }

    public void setResultSet(ArrayList<T> resultSet) {
        this.resultSet = resultSet;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
