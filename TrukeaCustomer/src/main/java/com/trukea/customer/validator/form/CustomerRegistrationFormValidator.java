package com.trukea.customer.validator.form;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.trukea.customer.form.account.CustomerRegistrationForm;
import com.trukea.customer.service.account.AccountService;

@Component
public class CustomerRegistrationFormValidator implements Validator {
	
	
	private final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	
	
	@Autowired
	public AccountService accountService;
	
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(CustomerRegistrationForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerRegistrationForm form=(CustomerRegistrationForm) target;
		long countForEmailAddress=0;
		long countForMobileNo=0;
		long countForDisplayName=0;
		
		
		if(errors.hasFieldErrors("password")==false) {
			if(Pattern.matches(PASSWORD_REGEX, form.getPassword())) {
				errors.rejectValue("password", "password.notvalid");
			}
			
		}
		
		if(errors.hasFieldErrors("reTypePassword")) {
			if(form.getPassword().equals(form.getReTypePassword())==false) {
				errors.rejectValue("reTypePassword","reTypepassword.mismatch");
			}
			}
		
		countForEmailAddress=Long.parseLong(accountService.getCountOfEmailAddress(form.getEmailAddress()).getBody());
		countForMobileNo=Long.parseLong(accountService.getCountOfMobileNo(form.getMobileNo()).getBody());
        countForDisplayName=Long.parseLong(accountService.getCountOfDisplayName(form.getDisplayName()).getBody());
        
        if(countForDisplayName>0) {
        	errors.rejectValue("displayName", "displayname.alreadyexisted");
        }
        if(countForEmailAddress>0) {
        	errors.rejectValue("emailAddress", "emailaddress.alreadyexisted");
        }
        if(countForMobileNo>0) {
        	errors.rejectValue("mobileNo", "mobileno.alreadyexisted");
        }
		
		
		
	}
	
	

}
