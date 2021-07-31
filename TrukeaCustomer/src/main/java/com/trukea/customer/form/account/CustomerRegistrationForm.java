package com.trukea.customer.form.account;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRegistrationForm {
	     
	
	     @Email
	     @NotBlank
         private String emailAddress;
	     @NotBlank
         private String firstName;
	     @NotBlank
         private String lastName;
	     @NotBlank
         private String password;
	     @NotBlank
         private String reTypePassword;
	     @NotBlank
	     @Length(min = 10, max = 10)
         private String mobileNo;
	     @NotBlank
	     @Length(min = 8, max = 12)
         private String displayName;
	     @NotNull
         private Integer termsAndConditions;
	

}
