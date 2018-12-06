package com.aaa.rent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * className:SpringBootMainApplication
 * discription:
 * author:luRuiHua
 * createTime:2018-11-21 15:15
 */
@SpringBootApplication
@MapperScan("com.aaa.rent.dao")
public class SpringBootMainApplication {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainApplication.class);

    }
}
