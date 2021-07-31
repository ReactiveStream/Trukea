package com.trukea.customer.feign.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trukea.customer.accountservice.exception.decoder.AccountServiceExceptionDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignAccountServiceClientConfiguration {
	
	
	@Bean
	public ErrorDecoder errorDecoder() {
		return new AccountServiceExceptionDecoder();
	}

}
