package org.yfmw.seckill.controller;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yfmw.seckill.model.SeckillUser;
import org.yfmw.seckill.model.vo.CommonWebUser;
import org.yfmw.seckill.model.vo.UserReq;
import org.yfmw.seckill.model.vo.UserResp;
import org.yfmw.seckill.service.UserService;
import org.yfmw.seckill.util.ErrorMessage;

import org.yfmw.seckill.util.bean.BaseRequest;
import org.yfmw.seckill.util.bean.BaseResponse;
import org.yfmw.seckill.util.redis.RedisUtil;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @ClassName loginCintroller
 * @Description TODO
 * @Author 影之
 * @Date 11/8/2022 上午11:16
 * @Version 1.0
 */
@RestController
@Slf4j
public class LoginController {
    private final String USER_PHONE_CODE_BEFORE = "u:p:c:b:";
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 发送登录验证码
     * @param req
     * @return
     */
    @PostMapping("/getPhoneSmsCode")
    public BaseResponse getPhoneSmsCode(@Valid @RequestBody BaseRequest<UserReq.BaseUserInfo> req) {

        //先接收手机号
        String phone = req.getData().getPhone();
        //查询用户
        SeckillUser seckillUser = userService.findByPhone(phone);
        //判断用户是否在存在
        if (seckillUser != null) {
            //接下来是调用第三方http接口发送短信验证码，通过验证码存储在redis中，方便后续判断，此处不展示http接口调用了
            //模拟短信验证码,所以我们以123456表示默认验证码
            String randomCode = "123456";
            redisUtil.set(USER_PHONE_CODE_BEFORE + phone, randomCode,60*30);
            return BaseResponse.ok(true);
        } else return BaseResponse.ok(false);
    }

    @PostMapping("/userPhoneLogin")
    public BaseResponse userPhoneLogin(@Valid @RequestBody BaseRequest<UserReq.LoginUserInfo> req) throws Exception{
        //将数据
        UserReq.LoginUserInfo loginInfo = req.getData();
        log.info("====[传入数据，手机号{}，验证码{}]===",loginInfo.getPhone(),loginInfo.getSmsCode());
        //到redis里面去找我们存的验证码
        Object existObj = redisUtil.get(USER_PHONE_CODE_BEFORE + loginInfo.getPhone());
        //判断验证码
        if (existObj == null || !existObj.toString().equals(loginInfo.getSmsCode())) {
            //返回错误码
            return BaseResponse.error(ErrorMessage.SMSCODE_ERROR);
        } else {
            //验证码使用一次便失效
            redisUtil.del(USER_PHONE_CODE_BEFORE + loginInfo.getPhone());

            //获取用户信息
            SeckillUser seckillUser = userService.findByPhone(loginInfo.getPhone());
            log.info(seckillUser.toString());
            CommonWebUser commonWebUser = new CommonWebUser();
//
            commonWebUser.setId(seckillUser.getId());
            commonWebUser.setPhone(seckillUser.getPhone());
            commonWebUser.setName(seckillUser.getName());
            log.info(commonWebUser.toString());
            //存入token
            String token = UUID.randomUUID().toString().replaceAll("-","");
            //设置token超时时间为1个月，实际根据需求确定
            redisUtil.set(token, JSON.toJSONString(commonWebUser), 60*60*24*30);

            //返回数据
            UserResp.BaseUserResp resp = new UserResp.BaseUserResp();
            resp.setToken(token);
            return BaseResponse.ok(resp);
        }
    }

}
