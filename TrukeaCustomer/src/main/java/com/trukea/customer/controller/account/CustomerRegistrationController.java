package com.trukea.customer.controller.account;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trukea.customer.dto.account.UserAccountDto;
import com.trukea.customer.exception.TrukeaCustomerException;
import com.trukea.customer.exception.VerificationCodeMismatchException;
import com.trukea.customer.form.account.CustomerRegistrationForm;
import com.trukea.customer.form.account.ForgetPasswordForm;
import com.trukea.customer.form.account.ResetPasswordForm;
import com.trukea.customer.form.account.VerifyOtpForm;
import com.trukea.customer.service.account.AccountService;
import com.trukea.customer.validator.form.CustomerRegistrationFormValidator;
import com.trukea.customer.validator.form.ForgetPasswordFormValidator;
import com.trukea.customer.validator.form.ResetPasswordFormValidator;

@Controller
public class CustomerRegistrationController {
	
	public static final String REGISTRATION_PAGE_NAME="register";
	public static final String CUSTOMER_REGISTRATION_FORM_NAME="customerRegistrationForm";
	public static final String REGISTRATION_SUCCESSFUL_PAGE="registration-success";
	public static final String EMAILVERIFICATION_SUCCESS_PAGE="registration-email-verification";
	public static final String VERIFY_OTP_FOR_REGISTRATION_PAGE="verifyotpforregistration";
	public static final String VERIFY_OTP_FOR_RESET_PASSWORD="verifyotpforresetpassword";
	public static final String ACTIVATED_ACCOUNT_PAGE="accountactivated";
	public static final String FORGET_PASSWORD_PAGE="forgetpassword";
	public static final String EMAIL_VERIFICATION_FOR_RESET_PASSWORD="resetpassword-email-verification";
	public static final String RESET_PASSWORD_PAGE="resetpassword";
	public static final String RESET_PASWORD_SUCCESS_PAGE="resetpasswordsuccess";
	public static final String GLOBAL_ERROR_PAGE="error";
	
	
	@Autowired
	public CustomerRegistrationFormValidator customerRegistrationFormValidator;
	
	
	@Autowired
	public ForgetPasswordFormValidator forgetPasswordValidator;
	
	
	@Autowired 
	public ResetPasswordFormValidator resetPasswordFormValidator;
	
	
	@Autowired
	public AccountService accountService;
	
	@GetMapping("/register")
	public String getRegistrationPage(Model model) {
		CustomerRegistrationForm customerRegistrationForm=new CustomerRegistrationForm();
		model.addAttribute(CUSTOMER_REGISTRATION_FORM_NAME, customerRegistrationForm);
		
		return REGISTRATION_PAGE_NAME;
		
	}
	
	@PostMapping("/register")
	public String registerCustomer(@ModelAttribute("customerRegistrationForm") @Valid CustomerRegistrationForm form,BindingResult errors,Model model) throws TrukeaCustomerException {
		UserAccountDto userAccountDto=null;
		if(errors.hasErrors()) {
			return REGISTRATION_PAGE_NAME;
		}
		
		  if(customerRegistrationFormValidator.supports(CustomerRegistrationForm.class)
		  ){ customerRegistrationFormValidator.validate(form, errors); }
		 
		  
		  userAccountDto=new UserAccountDto();
		  userAccountDto.setDisplayName(form.getDisplayName());
		  userAccountDto.setEmailAddress(form.getEmailAddress());
		  userAccountDto.setFirstName(form.getFirstName());
		  userAccountDto.setLastName(form.getLastName());
		  userAccountDto.setPassword(form.getPassword());
		  userAccountDto.setMobileNo(form.getMobileNo());
		  
		  try {
		  
            accountService.registerCustomer(userAccountDto);
		  }
		  
		  catch(Exception e) {
			  throw new TrukeaCustomerException("unable to register the customer");
		  }
		
		String message="Email verification link has been sent to "+form.getEmailAddress().substring(0, 4)+"xxxx"+form.getEmailAddress().substring(form.getEmailAddress().indexOf("@"), form.getEmailAddress().length())+".please verify to activate your account";
		
		model.addAttribute("message", message);
		
		
		return REGISTRATION_SUCCESSFUL_PAGE;
	}

	
	
@GetMapping("/customer/registration/{emailverificationcode}/{useraccountno}/verify")	
public String verifyEmailAddress(@PathVariable("emailverificationcode") String emailverificationcode,@PathVariable("useraccountno")String useraccountno,Model model) {
	UserAccountDto userAccountDto=null;
	
	userAccountDto=accountService.verifyEmailAddressforRegistration(emailverificationcode, useraccountno);
	
	String message="EmailVerification is Successful.An Otp is sent to your MobileNo:XXXXXX"+userAccountDto.getMobileNo().substring(6,10);
	model.addAttribute("message", message);
	VerifyOtpForm form=new VerifyOtpForm();
	form.setUserAccountNo(userAccountDto.getUserAccountNo());
	model.addAttribute("verifyOtpForm", form);
	
	return VERIFY_OTP_FOR_REGISTRATION_PAGE;
	
	
}


@PostMapping("/verifyotpforregistration")
public String getVerifyOtpPage(@ModelAttribute("verifyOtpForm")VerifyOtpForm form,BindingResult errors,Model model) {
	if(errors.hasErrors()) {
		return VERIFY_OTP_FOR_REGISTRATION_PAGE;
	}
	
	accountService.verifyMobileNoForRegistration(form.getOtpCode(),String.valueOf(form.getUserAccountNo()));
	
	
	
	
	return ACTIVATED_ACCOUNT_PAGE;
	
}



@GetMapping("/forgetpassword")
public String getForgetPasswordPage(Model model) {
	ForgetPasswordForm form=new ForgetPasswordForm();
	model.addAttribute("forgetPasswordForm",form);
	return FORGET_PASSWORD_PAGE;
}


/**
 * @param form
 * @param errors
 * @param model
 * @return
 */
/**
 * @param form
 * @param errors
 * @param model
 * @return
 */
@PostMapping("/forgetpassword")
public String forgetPassword(@ModelAttribute("forgetPasswordForm")@Valid ForgetPasswordForm form,BindingResult errors,Model model) {
	
	String otpcode=null;
	if(errors.hasErrors()) {
		System.out.println("binding");
		return FORGET_PASSWORD_PAGE;
	}
	if(forgetPasswordValidator.supports(ForgetPasswordForm.class)){
		
		forgetPasswordValidator.validate(form, errors);
		System.out.println("validator");
	}
	
	if(form.getEmailAddress()!=null&&form.getEmailAddress().trim().length()!=0) {
		String useraccountno=accountService.checkUserByEmailAddress(form.getEmailAddress()).getBody();
		if(useraccountno!=null) {
			 accountService.sendEmailToResetPasssword(form.getEmailAddress()).getBody();

		
		 
		
		return  EMAIL_VERIFICATION_FOR_RESET_PASSWORD;
		}
		else {
			return GLOBAL_ERROR_PAGE;
			
		}
		
	}
	
	if(form.getMobileNo()!=null) {
	UserAccountDto userAccountDto=	accountService.getUserAccountDtoByMobileno(form.getMobileNo()).getBody();
	if(userAccountDto!=null) {
		
	accountService.sendOtpToResetPasssword(form.getMobileNo());
	
	VerifyOtpForm verifyotpform=new VerifyOtpForm();
	verifyotpform.setUserAccountNo(userAccountDto.getUserAccountNo());
	model.addAttribute("verifyOtpForm", verifyotpform);
	return VERIFY_OTP_FOR_RESET_PASSWORD;
	}	
	}
	
	return GLOBAL_ERROR_PAGE;
	
}
	

@GetMapping("/customer/{emailverificationcode}/resetpassword/{useraccountno}/email")
public String emailVerificationToResetPassword(@PathVariable("emailverificationcode")String emailverificationcode,@PathVariable("useraccountno")String useraccountno,Model model) {
String userAccountno=	 accountService.verifyEmailToResetPassword(emailverificationcode, useraccountno).getBody();
if(userAccountno!=null) {
	ResetPasswordForm form=new ResetPasswordForm();
	form.setUserAccountNo(Long.parseLong(userAccountno));
	
	model.addAttribute("ResetPasswordForm", form);
	return RESET_PASSWORD_PAGE;
	
	
}
return GLOBAL_ERROR_PAGE;


}


@PostMapping("/verifyotp/resetpassword")
public String verifyOtpAndShowResetPasswordPage(@ModelAttribute("verifyOtpForm")VerifyOtpForm form,Model model,BindingResult errors) {
	
	if(errors.hasErrors()) {
		return VERIFY_OTP_FOR_RESET_PASSWORD;
	}
	
	String userAccountno=accountService.verifyOtpToResetPassword(form.getOtpCode(), String.valueOf(form.getUserAccountNo())).getBody();
	if(userAccountno!=null) {
		ResetPasswordForm rform=new ResetPasswordForm();
		rform.setUserAccountNo(Long.parseLong(userAccountno));
		
		
		model.addAttribute("resetPasswordForm", rform);
		return RESET_PASSWORD_PAGE;
		
	}
	
	return GLOBAL_ERROR_PAGE;
	
}



@PostMapping("/resetpassword")
public String resetPassword(@ModelAttribute("resetPasswordForm")@Valid ResetPasswordForm form,BindingResult errors,Model model) {
	UserAccountDto useraccountdto=null;
	
	if(errors.hasErrors()) {
		return RESET_PASSWORD_PAGE;
	}
if(	resetPasswordFormValidator.supports(ResetPasswordForm.class))
		{
	resetPasswordFormValidator.validate(form, errors);
}
useraccountdto=new UserAccountDto();
System.out.println("reset"+form.getUserAccountNo());
useraccountdto.setUserAccountNo(form.getUserAccountNo());
useraccountdto.setPassword(form.getPassword());

String userAccountno=accountService.resetPassword(useraccountdto).getBody();

if(userAccountno!=null) {
	return RESET_PASWORD_SUCCESS_PAGE;
}
	
	return GLOBAL_ERROR_PAGE;
	
	
}

@ExceptionHandler(VerificationCodeMismatchException.class)
public String handleverificationCodeMismatchException() {
	return  GLOBAL_ERROR_PAGE;
}
	
	
	
	
	
	
	
	
	
}
