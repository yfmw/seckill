package org.yfmw.seckill.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.yfmw.seckill.dao.SeckillProductsDao;
import org.yfmw.seckill.model.SeckillProducts;
import org.yfmw.seckill.service.ProductService;
import org.yfmw.seckill.util.bean.CommonQueryBean;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author 影之
 * @Date 12/8/2022 上午10:20
 * @Version 1.0
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    SeckillProductsDao seckillProductsDao;
    @Override
    public SeckillProducts selectByPrimaryKey(Long id) {
        log.info("===={}",id);
        return seckillProductsDao.selectByPrimaryKey(id);
    }

    @Override
    public int insert(SeckillProducts record) {
        log.info("===={}",record);
        return seckillProductsDao.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SeckillProducts record) {
        return seckillProductsDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SeckillProducts> list4Page(SeckillProducts record, CommonQueryBean query) {
        return seckillProductsDao.list4Page(record, query);
    }

    @Override
    public long count(SeckillProducts record) {
        return seckillProductsDao.count(record);
    }

    @Override
    public List<SeckillProducts> list(SeckillProducts record) {
        return seckillProductsDao.list(record);
    }

    @Override
    public Long uniqueInsert(SeckillProducts record) {
        try {
            record.setCreateTime(new Date());
            record.setIsDeleted(0);
            record.setStatus(SeckillProducts.STATUS_IS_OFFLINE);
            SeckillProducts seckillProducts = findByProductPeriodKey(record.getProductPeriodKey());
            if (seckillProducts != null) {
                return seckillProducts.getId();
            } else {
                seckillProductsDao.insert(record);
            }
        }catch (Exception ex){
            if (ex.getMessage().contains("Duplicate entry")){
                SeckillProducts existItem = findByProductPeriodKey(record.getProductPeriodKey());
                return existItem.getId();
            }else {
                log.error(ex.getMessage(),ex);
                throw new RuntimeException(ex.getMessage());
            }


        }
        return null;
    }

    @Override
    public SeckillProducts findByProductPeriodKey(String productPeriodKey) {
        Assert.isTrue(!StringUtils.isEmpty(productPeriodKey),"字符串不能为空");
        SeckillProducts item = new SeckillProducts();
        item.setProductPeriodKey(productPeriodKey);
        List<SeckillProducts> list = seckillProductsDao.list(item);
        if (CollectionUtils.isEmpty(list)) return null;
        else{
            return list.get(0);
        }
    }
}
