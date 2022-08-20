package org.yfmw.seckill.util.bean;

import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * @ClassName PageReq
 * @Description TODO
 * @Author 影之
 * @Date 22/7/2022 下午4:55
 * @Version 1.0
 */
public class PageReq implements Serializable {

    private Integer page=1;
    @Range(min = 0, max = 20, message = "每页最多20条数据")
    private Integer pageSize=5;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
