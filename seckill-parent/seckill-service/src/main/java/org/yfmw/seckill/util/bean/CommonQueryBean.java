package org.yfmw.seckill.util.bean;

/**
 * @ClassName CommonQueryBean 通用分页查询条件Bean
 * @Description TODO
 * @Author 影之
 * @Date 22/7/2022 下午4:50
 * @Version 1.0
 */

public class CommonQueryBean {
    private Integer pageSize; //每页数据条数
    private Integer start;//起始位置
    private String sort;//排序规则
    private String order;//分组规则


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


}
