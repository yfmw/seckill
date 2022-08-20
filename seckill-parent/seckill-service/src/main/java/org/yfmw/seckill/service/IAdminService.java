package org.yfmw.seckill.service;

import org.yfmw.seckill.model.SeckillAdmin;

import java.util.List;

public interface IAdminService {

    List<SeckillAdmin> listAdmin();


    SeckillAdmin findByUsername(String username);
}
