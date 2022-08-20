package org.yfmw.seckill.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yfmw.seckill.dao.SeckillOrderDao;
import org.yfmw.seckill.dao.SeckillProductsDao;
import org.yfmw.seckill.dao.SeckillUserDao;
import org.yfmw.seckill.model.SeckillOrder;
import org.yfmw.seckill.model.SeckillProducts;
import org.yfmw.seckill.model.vo.SeckillReq;
import org.yfmw.seckill.service.SeckillService;
import org.yfmw.seckill.util.ErrorMessage;
import org.yfmw.seckill.util.bean.BaseResponse;

import java.util.Date;

/**
 * @ClassName SeckillServiceImpl
 * @Description TODO
 * @Author 影之
 * @Date 17/8/2022 下午6:36
 * @Version 1.0
 */
@Slf4j
@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillOrderDao seckillOrderDao;
    @Autowired
    private SeckillUserDao seckillUserDao;
    @Autowired
    private SeckillProductsDao seckillProductsDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse toOrder(SeckillReq seckillReq) {
        log.info("传入数据，用户id[{}],商品id为[{}]", seckillReq.getUserId(), seckillReq.getProductId());
        log.info("===[开始生成订单]===");
        log.info("===[开始逻辑判断]===");
        BaseResponse baseResponse = validateParam(seckillReq.getProductId(), seckillReq.getUserId());
        if (baseResponse.getCode() != 0) {
            return baseResponse;
        }
        log.info("===[逻辑判断通过]===");


        Long productId = seckillReq.getProductId();
        SeckillProducts product = seckillProductsDao.selectByPrimaryKey(productId);

        // 扣减库存
        log.info("===[开始扣减库存]===");
        product.setSaled(product.getSaled() + 1);
        seckillProductsDao.updateByPrimaryKeySelective(product);
        log.info("===[扣减库存成功]===");
        //生成订单
        log.info("===[开始生成订单]===");
        SeckillOrder order = new SeckillOrder();
        order.setProductId(seckillReq.getProductId());
        order.setUserId(seckillReq.getUserId());
        order.setProductName(product.getName());
        Date date = new Date();
        order.setCreateTime(date);
        log.info(order.toString());
        seckillOrderDao.insert(order);
        log.info("===[订单生成完毕]===");
        return BaseResponse.OK(Boolean.TRUE);
    }

    private BaseResponse validateParam(Long productId, Long userId) {
        SeckillProducts products = seckillProductsDao.selectByPrimaryKey(productId);
        if (products == null) {
            log.error("产品不存在");
            return BaseResponse.error(ErrorMessage.SYS_ERROR);
        }
        if (products.getStartBuyTime(true).getTime() > System.currentTimeMillis()) {
            log.error("===[秒杀还未开始！]===");
            return BaseResponse.error(ErrorMessage.SECKILL_NOT_START);
        }
        if (products.getSaled() >= products.getCount()) {
            log.error("===[库存不足！]===");
            return BaseResponse.error(ErrorMessage.STOCK_NOT_ENOUGH);
        }
        return BaseResponse.OK;
    }
}
