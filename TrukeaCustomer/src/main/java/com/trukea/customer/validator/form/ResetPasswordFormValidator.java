package com.trukea.customer.validator.form;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.trukea.customer.form.account.ResetPasswordForm;


@Component
public class ResetPasswordFormValidator implements Validator {

	private final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(ResetPasswordForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ResetPasswordForm form=(ResetPasswordForm)target;
		
		if(errors.hasFieldErrors("password")==false) {
			
			if(Pattern.matches(PASSWORD_REGEX, form.getPassword())==false) {
				errors.rejectValue("password", "password.notvalid");
			}
			
			if(form.getPassword().equals(form.getReTypePassword())==false) {
				errors.rejectValue("password", "password.mismatch");
			}
		}
		
	}
	

}
