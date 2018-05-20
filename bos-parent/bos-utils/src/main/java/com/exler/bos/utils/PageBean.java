package com.exler.bos.utils;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Auther: Exler
 * @Date: 2018/5/19 21:03
 * @Description: 封装分页属性
 */
public class PageBean {
    private int currentPage;   // 当前页码
    private int pageSize;   // 每页显示记录数
    private int total;  // 总记录数
    private List rows;  // 当前页所需要展示的数据集合
    private DetachedCriteria dc;    // 查询条件

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public DetachedCriteria getDc() {
        return dc;
    }

    public void setDc(DetachedCriteria dc) {
        this.dc = dc;
    }
}
