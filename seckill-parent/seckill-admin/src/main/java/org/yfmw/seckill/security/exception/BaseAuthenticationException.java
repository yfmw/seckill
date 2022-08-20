package org.yfmw.seckill.security.exception;



import lombok.Getter;
import org.springframework.security.core.AuthenticationException;
import org.yfmw.seckill.util.ErrorMessage;
import org.yfmw.seckill.util.bean.BaseResponse;


//错误处理类
@Getter
public class BaseAuthenticationException extends AuthenticationException {
    private Integer code;

    public BaseAuthenticationException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public static BaseAuthenticationException error(ErrorMessage message) {
        return new BaseAuthenticationException(message.getCode(), message.getMessage());
    }
    public BaseResponse resp() {
        return BaseResponse.error(code, getMessage());
    }
}
