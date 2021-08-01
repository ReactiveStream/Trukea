package com.trukea.customer.service.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.trukea.customer.dto.account.UserAccountDto;
import com.trukea.customer.feign.configuration.FeignAccountServiceClientConfiguration;

@FeignClient( name="accountservice",url="${accountservice.url}/account",configuration = FeignAccountServiceClientConfiguration.class )
public interface AccountService {
	
	
	@PostMapping(value="/customer/new",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String registerCustomer(UserAccountDto userAccountDto);
	
	
	@GetMapping(value="/count/{emailAddress}/emailaddress",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> getCountOfEmailAddress(@PathVariable("emailAddress")String emailAddress);
	
	@GetMapping(value="/count/{displayName}/displayname",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> getCountOfDisplayName(@PathVariable("displayName")String displayName);
	
	
	@GetMapping(value="/count/{mobileNo}/mobileno",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> getCountOfMobileNo(@PathVariable("mobileNo")String mobileNo);
	
	
	@GetMapping(value="/customer/registration/{emailverificationcode}/{useraccountno}/verifyemail",produces=MediaType.APPLICATION_JSON_VALUE)
	public UserAccountDto verifyEmailAddressforRegistration(@PathVariable("emailverificationcode")String emailverificationcode,@PathVariable("useraccountno")String useraccountno);
		
	@GetMapping(value="/customer/registration/{otpcode}/{useraccountno}/verifymobile",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> verifyMobileNoForRegistration(@PathVariable("otpcode") String otpcode,@PathVariable("useraccountno")String useraccountno);

	
	
	@GetMapping(value="/useraccount/{mobileno}/mobile",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAccountDto>  getUserAccountDtoByMobileno(@PathVariable("mobileno")String MobileNo);
	
	
    @GetMapping(value="/useraccount/{emailaddress}/email",produces=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> checkUserByEmailAddress(@PathVariable("emailaddress")String emailaddress);
    
    
    @PostMapping(value="/forgetpassword/{emailaddress}/verify",produces=MediaType.TEXT_PLAIN_VALUE,consumes=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity sendEmailToResetPasssword(@PathVariable("emailaddress")String emailaddress);
    
    @PostMapping(value="/forgetpassword/{mobileno}/verifymobile",produces=MediaType.TEXT_PLAIN_VALUE,consumes=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity sendOtpToResetPasssword(@PathVariable("mobileno")String mobileno);
    
    @GetMapping(value="/forgetpassword/{emailverificationcode}/email/{useraccountno}/verify",produces=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> verifyEmailToResetPassword(@PathVariable("emailverificationcode")String emailverificationcode,@PathVariable("useraccountno")String useraccountno);
    
    
    @GetMapping(value="/forgetpassword/{otp}/mobile/{useraccountno}/verify",produces=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> verifyOtpToResetPassword(@PathVariable("otp")String otp,@PathVariable("useraccountno")String useraccountno);
 
    
    @PutMapping(value="/resetpassword",produces=MediaType.TEXT_PLAIN_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> resetPassword(@RequestBody UserAccountDto useraccountdto);
    
    
    @GetMapping(value="/getuser/{emailaddress}/useraccount",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAccountDto> getUserAccountDtoByEmailAddress(@PathVariable("emailaddress")String emailaddress);
}
