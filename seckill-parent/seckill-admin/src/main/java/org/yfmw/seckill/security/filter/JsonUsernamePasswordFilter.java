package org.yfmw.seckill.security.filter;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.yfmw.seckill.security.exception.BaseAuthenticationException;
import org.yfmw.seckill.util.ErrorMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

//json登录跳转逻辑
public class JsonUsernamePasswordFilter extends UsernamePasswordAuthenticationFilter {

    private boolean postOnly = true;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        //attempt Authentication when Content-Type is json
        if (request.getContentType().startsWith(MediaType.APPLICATION_JSON_VALUE)) {
            //use jackson to deserialize json
            UsernamePasswordAuthenticationToken authRequest;
            try (InputStream is = request.getInputStream()) {
                String body = IoUtil.read(is, CharsetUtil.CHARSET_UTF_8);
                JSONObject jsonObject = JSON.parseObject(body);
                String username = jsonObject.getJSONObject("data").getString("username");
                String password = jsonObject.getJSONObject("data").getString("password");

                // 校验IP地域 start
//                String requestsIp = IPUtil.getIpAddress(request);
//                if (IpCheckUtil.checkIp(ipTableService.getList(), username, requestsIp) == false) {
//                    ErrorMessage error = ErrorMessage.UN_USERNAME_STATUS;
//                    error.setMessage("登录账号ip区域不允许, 您的IP："+requestsIp);
//                    throw BaseAuthenticationException.error(error);
//                }
                // 校验IP地域 end

                authRequest = new UsernamePasswordAuthenticationToken(username, password);
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            } catch (IOException e) {
                e.printStackTrace();
                throw BaseAuthenticationException.error(ErrorMessage.LOGIN_ERROR);

            }
        } else {
            throw BaseAuthenticationException.error(ErrorMessage.NO_JSON);
        }

    }


}
