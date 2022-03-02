package com.du.rems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.du.rems.mapper")
@EnableSwagger2
public class RemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemsApplication.class, args);
    }

}
