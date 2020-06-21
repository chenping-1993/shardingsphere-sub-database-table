package com.cp.shardingspheresubdatabasetable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cp.shardingspheresubdatabasetable.mapper")
public class ShardingsphereSubDatabaseTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereSubDatabaseTableApplication.class, args);
    }

}
