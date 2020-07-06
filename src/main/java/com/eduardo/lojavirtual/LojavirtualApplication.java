package com.eduardo.lojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eduardo.lojavirtual"})
public class LojavirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojavirtualApplication.class, args);
	}

}
