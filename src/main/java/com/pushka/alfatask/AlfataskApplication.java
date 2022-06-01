package com.pushka.alfatask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlfataskApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlfataskApplication.class, args);
	}

}
