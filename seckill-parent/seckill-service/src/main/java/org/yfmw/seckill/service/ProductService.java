package org.yfmw.seckill.service;

import org.yfmw.seckill.model.SeckillProducts;
import org.yfmw.seckill.util.bean.CommonQueryBean;

import java.util.List;

/**
 * @ClassName ProductService
 * @Description TODO
 * @Author 影之
 * @Date 12/8/2022 上午10:16
 * @Version 1.0
 */
public interface ProductService {
    SeckillProducts selectByPrimaryKey(Long id);

    int insert(SeckillProducts record);

    int updateByPrimaryKeySelective(SeckillProducts record);

    List<SeckillProducts> list4Page(SeckillProducts record, CommonQueryBean query);

    long count(SeckillProducts record);

    List<SeckillProducts> list(SeckillProducts record);
    //使用唯一索引插入
    Long uniqueInsert(SeckillProducts record);

    SeckillProducts findByProductPeriodKey(String productPeriodKey);
}
