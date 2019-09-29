package com.dthealth.interaction.repository;

import java.util.List;

public class QueryResult<T> {
    private long total;
    private List<T> rows;

    public QueryResult() {
    }

    public QueryResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
