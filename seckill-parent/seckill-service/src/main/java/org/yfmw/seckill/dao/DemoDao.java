package org.yfmw.seckill.dao;

import java.util.List;
import org.yfmw.seckill.model.Demo;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.yfmw.seckill.util.bean.CommonQueryBean;

/**
 * 
 * Demo数据库操作接口类
 * 
 **/

@Repository
public interface DemoDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Demo  selectByPrimaryKey ( @Param("id") Long id );

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
	int insert( Demo record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Demo record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Demo> list4Page ( Demo record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	int count ( Demo record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Demo> list ( Demo record);

}