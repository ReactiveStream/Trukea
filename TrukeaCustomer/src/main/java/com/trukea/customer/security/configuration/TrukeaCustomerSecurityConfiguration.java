package com.trukea.customer.security.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;


@Configuration
public class TrukeaCustomerSecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	public UserDetailsService userDetailsService;
	
	
	@Autowired 
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	
	
	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().formLogin().loginPage("/login").loginProcessingUrl("/authenticate").usernameParameter("username")
		.passwordParameter("password").defaultSuccessUrl("/trukeahome").failureHandler(authenticationFailureHandler)
		.and().authorizeRequests().antMatchers("/assets/**")
		.permitAll().antMatchers("/login").permitAll().antMatchers("/trukeahome").permitAll().antMatchers("/register").permitAll()
		.antMatchers("/customer/**","/verifyotpforregistration","/forgetpassword","/verifyotp","/resetpassword").permitAll()
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true);
	}
	
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		ExceptionMappingAuthenticationFailureHandler authFailureHandler = null;
		Properties exceptionMappings = null;

		authFailureHandler = new ExceptionMappingAuthenticationFailureHandler();
		exceptionMappings = new Properties();
		exceptionMappings.put("org.springframework.security.authentication.BadCredentialsException",
				"/login?error=bad");
		exceptionMappings.put("org.springframework.security.authentication.DisabledException",
				"/login?error=disabled");
		exceptionMappings.put("org.springframework.security.authentication.LockedException",
				"/login?error=locked");
		authFailureHandler.setExceptionMappings(exceptionMappings);

		return authFailureHandler;
	}
	

}
