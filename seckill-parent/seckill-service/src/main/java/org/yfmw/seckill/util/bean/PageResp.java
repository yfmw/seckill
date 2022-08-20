package org.yfmw.seckill.util.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageResp
 * @Description TODO
 * @Author 影之
 * @Date 22/7/2022 下午4:56
 * @Version 1.0
 */
public class PageResp<T> implements Serializable {
    private List<T> list;
    private Integer totalNum;
    private Integer totalPage;
    private Integer pageNum;
    private Integer pageSize;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageResp{" +
                "list=" + list +
                ", totalNum=" + totalNum +
                ", totalPage=" + totalPage +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}