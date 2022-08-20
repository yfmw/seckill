package org.yfmw.seckill.dao;

import java.util.List;
import org.yfmw.seckill.model.SeckillUser;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.yfmw.seckill.util.bean.CommonQueryBean;

/**
 * 
 * SeckillUser数据库操作接口类
 * 
 **/

@Repository
public interface SeckillUserDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	SeckillUser  selectByPrimaryKey ( @Param("id") Long id );

	/**
	 * 查询当前用户是否存在
	 */
	SeckillUser  selectByPhone( @Param("phone") String phone );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( SeckillUser record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( SeckillUser record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<SeckillUser> list4Page ( SeckillUser record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	int count ( SeckillUser record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<SeckillUser> list ( SeckillUser record);

}