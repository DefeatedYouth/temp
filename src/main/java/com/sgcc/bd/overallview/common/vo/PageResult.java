package com.sgcc.bd.overallview.common.vo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Exrickx
 * 前后端交互数据标准
 */
public class PageResult<T>  implements Serializable{

    public static final int DEFAULT_PAGE_SIZE = 20;
    private static final long serialVersionUID = 9056411043515781783L;


    /**
     * 页码
     */
    private int page;
    /**
     * 每页结果数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总数
     */
    private int total;

    private List<T> dataList;


    //---------------------------------------------------------- Constructor start

    /**
     * 构造
     */
    public PageResult() {
        this(0, DEFAULT_PAGE_SIZE);
        this.dataList=new ArrayList<>();
    }

    /**
     * 构造
     *
     * @param page     页码
     * @param pageSize 每页结果数
     */
    public PageResult(int page, int pageSize) {
        this.page = Math.max(page, 0);
        this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
        this.dataList=new ArrayList<>();
    }

    /**
     * 构造
     *
     * @param page     页码
     * @param pageSize 每页结果数
     * @param total    结果总数
     */
    public PageResult(int page, int pageSize, int total) {
        this(page, pageSize);

        this.total = total;
        this.totalPage = totalPage(total, pageSize);
        this.dataList=new ArrayList<>();
    }

    private int totalPage(int totalCount, int pageSize) {
        if (pageSize == 0) {
            return 0;
        }
        return totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize + 1);
    }
    //---------------------------------------------------------- Constructor end

    //---------------------------------------------------------- Getters and Setters start

    public List<T> getDataList(){return dataList;}
    public void setDataList(List<T> dataList){this.dataList=dataList;}
    public void addDataList(T t){dataList.add(t);}
    /**
     * @return 页码
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置页码
     *
     * @param page 页码
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return 每页结果数
     * @deprecated 请使用{@link #getPageSize()}
     */
    @Deprecated
    public int getNumPerPage() {
        return pageSize;
    }

    /**
     * 设置每页结果数
     *
     * @param pageSize 每页结果数
     * @deprecated 请使用 {@link #setPageSize(int)}
     */
    @Deprecated
    public void setNumPerPage(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return 每页结果数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页结果数
     *
     * @param pageSize 每页结果数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return 总页数
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * 设置总页数
     *
     * @param totalPage 总页数
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * @return 总数
     */
    public int getTotal() {
        return total;
    }

    /**
     * 设置总数
     *
     * @param total 总数
     */
    public void setTotal(int total) {
        this.total = total;
    }
    //---------------------------------------------------------- Getters and Setters end

    /**
     * @return 是否第一页
     */
    public boolean isFirst() {
        return this.page == 0;
    }

    /**
     * @return 是否最后一页
     */
    public boolean isLast() {
        return this.page >= this.totalPage;
    }
}
