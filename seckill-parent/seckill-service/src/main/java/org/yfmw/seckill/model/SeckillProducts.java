package org.yfmw.seckill.model;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * 
 * 商品表
 * 
 **/
public class SeckillProducts{


  public static final Integer STATUS_IS_ONLINE = 1;
  public static final Integer IS_DEALED = 1;
  public static final Integer STATUS_IS_OFFLINE = 2;
  public static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";
  /**主键**/

  private Long id;


  /**商品名称**/

  private String name;

  @Override
  public String toString() {
    return "SeckillProducts{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", count=" + count +
            ", saled=" + saled +
            ", createTime=" + createTime +
            ", isDeleted=" + isDeleted +
            ", startBuyTime=" + startBuyTime +
            ", updatedTime=" + updatedTime +
            ", productDesc='" + productDesc + '\'' +
            ", status=" + status +
            ", memo='" + memo + '\'' +
            ", productPeriodKey='" + productPeriodKey + '\'' +
            '}';
  }

  /**商品总库存数量**/

  private Integer count;


  /**已售数量**/

  private Integer saled;


  /**创建时间**/
//  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date createTime;


  /**是否删除：0否 1是**/

  private Integer isDeleted;


  /**商品开始销售时间**/

  private Date startBuyTime;


  /**更新时间**/

  private Date updatedTime;


  /**商品简介**/

  private String productDesc;


  /**商品状态**/

  private Integer status;


  /**备注信息**/

  private String memo;


  /**唯一标识key**/

  private String productPeriodKey;




  public void setId(Long id) { 
    this.id = id;
  }


  public Long getId() { 
    return this.id;
  }


  public void setName(String name) { 
    this.name = name;
  }


  public String getName() { 
    return this.name;
  }


  public void setCount(Integer count) { 
    this.count = count;
  }


  public Integer getCount() { 
    return this.count;
  }


  public void setSaled(Integer saled) { 
    this.saled = saled;
  }


  public Integer getSaled() { 
    return this.saled;
  }


  public void setCreateTime(Date createTime) { 
    this.createTime = createTime;
  }


  public String getCreateTime() {
    if (this.createTime != null ){
      return DateUtil.format(this.createTime,DATE_TO_STRING_DETAIAL_PATTERN);
    }else{
      return null;
    }
  }


  public void setIsDeleted(Integer isDeleted) { 
    this.isDeleted = isDeleted;
  }


  public Integer getIsDeleted() { 
    return this.isDeleted;
  }


  public void setStartBuyTime(Date startBuyTime) { 
    this.startBuyTime = startBuyTime;
  }


  public Date getStartBuyTime(boolean a) {
    return this.startBuyTime;
  }
  public String getStartBuyTime() {
    if (this.startBuyTime != null ){
      return DateUtil.format(this.startBuyTime,DATE_TO_STRING_DETAIAL_PATTERN);
    }else{
      return null;
    }
  }


  public void setUpdatedTime(Date updatedTime) { 
    this.updatedTime = updatedTime;
  }


  public String getUpdatedTime() {
    if (this.updatedTime != null ){
      return DateUtil.format(this.updatedTime,DATE_TO_STRING_DETAIAL_PATTERN);
    }else{
      return null;
    }
  }


  public void setProductDesc(String productDesc) { 
    this.productDesc = productDesc;
  }


  public String getProductDesc() { 
    return this.productDesc;
  }


  public void setStatus(Integer status) { 
    this.status = status;
  }


  public Integer getStatus() { 
    return this.status;
  }


  public void setMemo(String memo) { 
    this.memo = memo;
  }


  public String getMemo() { 
    return this.memo;
  }


  public void setProductPeriodKey(String productPeriodKey) { 
    this.productPeriodKey = productPeriodKey;
  }


  public String getProductPeriodKey() { 
    return this.productPeriodKey;
  }

}
