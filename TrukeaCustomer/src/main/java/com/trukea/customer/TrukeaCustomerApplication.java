package com.trukea.customer;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

public class TrukeaCustomerApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(TrukeaCustomerApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/trukeahome").setViewName("Trukea-Home");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/register").setViewName("register");
	}

	
	
	

}
