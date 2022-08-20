package org.yfmw.seckill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yfmw.seckill.model.vo.CommonWebUser;
import org.yfmw.seckill.model.vo.SeckillReq;
import org.yfmw.seckill.service.SeckillService;
import org.yfmw.seckill.util.ErrorMessage;
import org.yfmw.seckill.util.WebUserUtil;
import org.yfmw.seckill.util.bean.BaseRequest;
import org.yfmw.seckill.util.bean.BaseResponse;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @ClassName SeckillController
 * @Description TODO
 * @Author 影之
 * @Date 17/8/2022 下午5:55
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/seckill")
@Slf4j
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    /**
     * 秒杀下单（简易下单逻辑）
     */
    @RequestMapping(value = "/simple/order")
    public synchronized BaseResponse sOrder(@Valid @RequestBody BaseRequest<SeckillReq> request) {
        CommonWebUser user = WebUserUtil.getLoginUser();
        log.info(user.toString());
        if (Objects.isNull(user)) {
            return BaseResponse.error(ErrorMessage.LOGIN_ERROR);
        }
        SeckillReq seckillReq = request.getData();
        seckillReq.setUserId(user.getId());
        return seckillService.toOrder(seckillReq);

    }
}
