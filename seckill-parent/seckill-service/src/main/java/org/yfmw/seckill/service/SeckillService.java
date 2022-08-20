package org.yfmw.seckill.service;

import org.yfmw.seckill.model.vo.SeckillReq;
import org.yfmw.seckill.util.bean.BaseResponse;

/**
 * @ClassName SeckillService
 * @Description TODO
 * @Author 影之
 * @Date 17/8/2022 下午5:57
 * @Version 1.0
 */
public interface SeckillService {
    BaseResponse toOrder(SeckillReq seckillReq);
}
