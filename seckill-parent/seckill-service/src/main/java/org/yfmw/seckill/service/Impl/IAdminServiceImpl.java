package org.yfmw.seckill.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.yfmw.seckill.dao.SeckillAdminDao;
import org.yfmw.seckill.model.SeckillAdmin;
import org.yfmw.seckill.service.IAdminService;

import java.util.List;

/**
 * @ClassName IAdminServiceImpl
 * @Description TODO
 * @Author 影之
 * @Date 12/8/2022 下午4:02
 * @Version 1.0
 */
@Service
public class IAdminServiceImpl implements IAdminService {

    @Autowired
    SeckillAdminDao seckillAdminDao;

    @Override
    public List<SeckillAdmin> listAdmin() {
        return seckillAdminDao.findAll();
    }

    @Override
    public SeckillAdmin findByUsername(String username) {
        Assert.notNull(username);

        SeckillAdmin item = new SeckillAdmin();
        item.setLoginName(username);
        List<SeckillAdmin> list = seckillAdminDao.list(item);
        if (!CollectionUtils.isEmpty(list)) {
            Assert.isTrue(list.size() == 1,"不唯一");
            return list.get(0);
        }
        return null;
    }
}
