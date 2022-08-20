package org.yfmw.seckill.model;

import cn.hutool.core.date.DateUtil;

import java.util.Date;


/**
 * 
 * 管理员姓名表
 * 
 **/
public class SeckillAdmin{
  public static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

  /****/

  private Long id;


  /**登录名**/

  private String loginName;


  /**密码**/

  private String password;


  /**展示管理员名称**/

  private String name;


  /**ip范围，空不限制**/

  private String ipRange;


  /**创建时间**/

  private Date createTime;




  public void setId(Long id) { 
    this.id = id;
  }


  public Long getId() { 
    return this.id;
  }


  public void setLoginName(String loginName) { 
    this.loginName = loginName;
  }


  public String getLoginName() { 
    return this.loginName;
  }


  public void setPassword(String password) { 
    this.password = password;
  }


  public String getPassword() { 
    return this.password;
  }


  public void setName(String name) { 
    this.name = name;
  }


  public String getName() { 
    return this.name;
  }


  public void setIpRange(String ipRange) { 
    this.ipRange = ipRange;
  }


  public String getIpRange() { 
    return this.ipRange;
  }


  public void setCreateTime(Date createTime) { 
    this.createTime = createTime;
  }


  public Date getCreateTime(boolean a) {
      return this.createTime;
  }
  public String getCreateTime() {
    if (this.createTime != null ){
      return DateUtil.format(this.createTime,DATE_TO_STRING_DETAIAL_PATTERN);
    }else{
      return null;
    }
  }

  @Override
  public String toString() {
    return "SeckillAdmin{" +
            "id=" + id +
            ", loginName='" + loginName + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", ipRange='" + ipRange + '\'' +
            ", createTime=" + createTime +
            '}';
  }
}
