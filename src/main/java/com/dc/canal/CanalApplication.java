package com.dc.canal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CanalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class, args);
    }

}
