package com.cg.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Login API", version = "2.0", description = "Registration Login System"))
public class LoginModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginModuleApplication.class, args);
	}

}
