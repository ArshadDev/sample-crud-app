package com.kib.bank.samplecrudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SampleCrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleCrudAppApplication.class, args);
	}

}
