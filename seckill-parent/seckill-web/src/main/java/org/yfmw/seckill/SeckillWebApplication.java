package org.yfmw.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SeckillWebApplication
 * @Description TODO
 * @Author 影之
 * @Date 18/8/2022 下午6:07
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("org.yfmw.seckill.dao")
public class SeckillWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillWebApplication.class, args);
    }
}
