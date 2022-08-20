package org.yfmw.seckill.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserResp
 * @Description TODO
 * @Author 影之
 * @Date 11/8/2022 上午11:46
 * @Version 1.0
 */
@Data
public class UserResp implements Serializable{
    @Data
    public static class BaseUserResp implements Serializable {
        private String token;
    }
}
