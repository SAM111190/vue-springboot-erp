package com.example.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan(value = "com.example.erp.mapper")
public class erpApplication {

	public static void main(String[] args) {
		SpringApplication.run(erpApplication.class, args);
	}

}
