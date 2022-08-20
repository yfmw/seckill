package org.yfmw.seckill.util.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName CursorPageResp
 * @Description TODO
 * @Author 影之
 * @Date 23/7/2022 下午4:31
 * @Version 1.0
 */
@Data
public class CursorPageResp <T> implements Serializable {
    private Long cursor;
    private List<T> list;
}
