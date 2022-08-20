package org.yfmw.seckill.service;


import org.yfmw.seckill.security.AdminUser;
import org.yfmw.seckill.security.Token;

public interface AdminTokenService {
    AdminUser getLoginUser(String token);
    Token saveToken(AdminUser loginUser);
    void deleteToken(String token);
    void refresh(AdminUser loginUser);

}