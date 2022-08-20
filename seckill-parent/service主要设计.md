# 登录模块

登录模块模拟验证码登录主要分为两部分

## 第一部分：发送验证码

前提条件：必须输入手机号且该手机号已经注册,即BaseRequset<UserReq.BaseUserInfo> req

后台处理：

使用getPhoneSmsCode 映射

1. 先判断手机号是否注册
2. 生成验证码并将该验证码

```java
@PostMapping("/getPhoneSmsCode ")
Public BaseRepsonse getPhoneSmsCode(BaseRequset<UserReq.BaseUserInfo> req）{
    Stirng
}
```


第一版 秒杀模块
```java


```
