package org.yfmw.seckill.model;

import java.util.Date;


/**
 * 
 * 用户表
 * 
 **/
public class SeckillUser{

  private Long id;
  private String name;
  private String phone;//用户手机号
  private Date createTime;//创建时间
  private Integer isDeleted;  //是否删除：0否 1是




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


  public void setPhone(String phone) { 
    this.phone = phone;
  }


  public String getPhone() { 
    return this.phone;
  }


  public void setCreateTime(Date createTime) { 
    this.createTime = createTime;
  }


  public Date getCreateTime() { 
    return this.createTime;
  }


  public void setIsDeleted(Integer isDeleted) { 
    this.isDeleted = isDeleted;
  }


  public Integer getIsDeleted() { 
    return this.isDeleted;
  }

  @Override
  public String toString() {
    return "SeckillUser{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", createTime=" + createTime +
            ", isDeleted=" + isDeleted +
            '}';
  }
}
