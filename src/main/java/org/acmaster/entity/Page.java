package org.acmaster.entity;

/**
 * 分页
 * @author 王海涵
 */
public class Page {

    private int current = 1;
    private int size = 10;
    private int totalPage = 1;

    private int limitStart = 0;

    public Page() {
    }

    public Page(int current) {
        this.current = current;
        setLimit();
    }

    public Page(int current, int size) {
        this.current = current;
        this.size = size;

        setLimit();
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;

        setLimit();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;

        setLimit();
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart = limitStart;
    }


    public void setLimit() {
        limitStart = (current - 1) * size;
    }

    @Override
    public String toString() {
        return "Page{" +
                "current=" + current +
                ", size=" + size +
                ", totalPage=" + totalPage +
                ", limitStart=" + limitStart +
                '}';
    }
}

