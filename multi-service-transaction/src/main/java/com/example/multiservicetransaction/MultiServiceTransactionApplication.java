package com.example.multiservicetransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.multiservicetransaction.mapper")
@SpringBootApplication
public class MultiServiceTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiServiceTransactionApplication.class, args);
    }

}
