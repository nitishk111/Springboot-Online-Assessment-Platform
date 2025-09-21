package com.nitish.Admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Admin API", version = "2.0", description = "Admin System"))
public class AdminModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminModuleApplication.class, args);
	}
	
	@Bean
	RestTemplate getRestTemplate() {
		RestTemplate restTemplate=new RestTemplate();
		return restTemplate;
	}

}
