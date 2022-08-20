package org.yfmw.seckill.service;

import org.yfmw.seckill.model.SeckillUser;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 影之
 * @Date 11/8/2022 下午12:00
 * @Version 1.0
 */
public interface UserService {
    public SeckillUser findByPhone(String phone);
}
