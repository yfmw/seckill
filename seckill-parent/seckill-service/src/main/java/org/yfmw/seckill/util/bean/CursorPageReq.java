package org.yfmw.seckill.util.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName CursorPageReq
 * @Description TODO
 * @Author 影之
 * @Date 23/7/2022 下午4:26
 * @Version 1.0
 */
@Data
public class CursorPageReq implements Serializable {
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;

    private Long cursor;


}
