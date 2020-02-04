package com.example.security.pojo.resultPojo;
import java.util.List;
/**
 * 分页返回结果类
 */
public class PageResult<T> {

    private Long total;//总记录数

    private List<T> rows;//所有查询记录数据

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
