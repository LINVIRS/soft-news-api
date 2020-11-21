package com.soft1851.utils;

import java.util.List;

/**
 * @ClassName: ads
 * @Description: TODO
 * @Author: WangLinLIN
 * @Date: 2020/11/21 15:50:19 
 * @Version: V1.0
 **/
public class PageGridResult {
    /**
     * 当前页
     */
    private int page;
    /**
     * 总页数
     */
    private long total;
    /**
     * 总记录数
     */
    private long records;
    /**
     * 每页显示的内容
     */
    private List<?> rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}