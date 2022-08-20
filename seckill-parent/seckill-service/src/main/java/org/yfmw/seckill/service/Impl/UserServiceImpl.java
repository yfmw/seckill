package org.yfmw.seckill.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.yfmw.seckill.dao.SeckillUserDao;
import org.yfmw.seckill.model.SeckillUser;
import org.yfmw.seckill.service.UserService;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 影之
 * @Date 11/8/2022 下午4:26
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public SeckillUserDao seckillUserDao;
    @Override
    public SeckillUser findByPhone(String phone) {
        Assert.notNull(phone, "电话号码为空");
        return seckillUserDao.selectByPhone(phone);
    }
}
