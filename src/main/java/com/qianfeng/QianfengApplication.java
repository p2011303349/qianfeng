package com.qianfeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qianfeng.dao")
public class QianfengApplication {

	public static void main(String[] args) {
		SpringApplication.run(QianfengApplication.class, args);
	}

}
