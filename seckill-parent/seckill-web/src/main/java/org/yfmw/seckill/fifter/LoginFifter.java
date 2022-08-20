package org.yfmw.seckill.fifter;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.yfmw.seckill.model.vo.CommonWebUser;
import org.yfmw.seckill.util.ErrorMessage;
import org.yfmw.seckill.util.WebUserUtil;
import org.yfmw.seckill.util.bean.BaseResponse;
import org.yfmw.seckill.util.redis.RedisUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LoginFifter
 * @Description TODO
 * @Author 影之
 * @Date 11/8/2022 下午5:42
 * @Version 1.0
 */
@Slf4j
@WebFilter(filterName = "LoginFifter",urlPatterns = "/*")
public class LoginFifter implements Filter {

    @Autowired
    private RedisUtil redisUtil;
    //本filter配置的是拦截所有，urlPattern是配置的需要拦截的地址，其他地址不做拦截
    @Value("${auth.login.pattern}")
    private String urlPattern;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        log.info("url:=" +url+ ",pattrn:="+urlPattern);
        if (url.matches(urlPattern)) {
            if (session.getAttribute(WebUserUtil.SESSION_WEBUSER_KEY) != null) {
                filterChain.doFilter(request, response);
                return;
            } else {
                //token我们此处约定保存在http协议的header中，也可以保存在cookie中，
                // 调用我们接口的前端或客户端也会保存cookie，具体使用方式由公司确定
                String tokenValue = request.getHeader("token");
                if (StringUtils.isNotEmpty(tokenValue)) {
                    Object object = redisUtil.get(tokenValue);
                    if (object != null) {
                        CommonWebUser commonWebUser = JSONObject.parseObject(object.toString(), CommonWebUser.class);
                        session.setAttribute(WebUserUtil.SESSION_WEBUSER_KEY, commonWebUser);
                        filterChain.doFilter(request, response);
                        return;
                    } else {
                        //返回接口调用方需要登录的错误码，接口调用方开始登录
                        returnJson(response);
                        return;
                    }
                } else {
                    //返回接口调用方需要登录的错误码，接口调用方开始登录
                    returnJson(response);
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);
        return;
    }
    /**
     * 返回需要登录的约定格式的错误码，接口调用方根据错误码进行登录操作.
     */
    private void returnJson(ServletResponse response) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            BaseResponse baseResponse = new BaseResponse(ErrorMessage.USER_NEED_LOGIN.getCode(),
                    ErrorMessage.USER_NEED_LOGIN.getMessage(), null);
            writer.print(JSON.toJSONString(baseResponse));
        } catch (IOException e) {
            log.error("response error", e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
