package org.yfmw.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("org.yfmw.seckill.dao")
public class SeckillAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillAdminApplication.class, args);
    }
}
