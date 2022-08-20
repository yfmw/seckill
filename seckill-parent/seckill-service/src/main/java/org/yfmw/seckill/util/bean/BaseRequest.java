package org.yfmw.seckill.util.bean;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ClassName BaseRequest
 * @Description TODO
 * @Author 影之
 * @Date 11/8/2022 上午11:18
 * @Version 1.0
 */
@Data
public class BaseRequest<T> implements Serializable {
    @NotBlank(message = "设备类型不能为空")
    private String deviceType;
    @NotBlank(message = "设备No参数不能为空")
    private String deviceNo;
    @NotBlank(message = "当前版本参数不能为空")
    private String version;
    @NotBlank(message = "渠道ID不能为空")
    private String channelId;
    @Valid
    private T data;

    public BaseRequest() {
    }


}