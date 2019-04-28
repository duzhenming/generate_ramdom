package com.random.generate_random;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.random.generate_random.dao")
@SpringBootApplication
public class GenerateRamdomApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateRamdomApplication.class, args);
    }

}
