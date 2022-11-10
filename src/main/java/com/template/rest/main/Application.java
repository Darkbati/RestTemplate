package com.template.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.template.rest")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
