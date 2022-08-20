package org.yfmw.seckill.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


//获取用户
public class AdminUserUtil {

    /**
     * 获取当前用户
     *
     * @return
     */
    public static AdminUser getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }

            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                return (AdminUser) authentication.getPrincipal();
            }
        }
        return null;
    }

}
