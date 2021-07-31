package com.trukea.accountservice.api.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trukea.accountservice.dto.account.UserAccountDto;
import com.trukea.accountservice.exception.AccountServiceException;
import com.trukea.accountservice.exception.TrukeaError;
import com.trukea.accountservice.exception.UserNotFoundException;
import com.trukea.accountservice.exception.VerificationCodeMismatchException;
import com.trukea.accountservice.service.account.AccountService;

@RestController()
@RequestMapping("/account")
public class ManageUserAccountApiService {
	
	
	@Autowired
	public AccountService accountService;
	
	@PostMapping(value="/customer/new",consumes= {MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> newCustomer(@RequestBody UserAccountDto userAccountDto) throws AccountServiceException{
		long userAccountNo=0;
		
		try {
		
	userAccountNo=	accountService.registerCustomer(userAccountDto);
		}
		catch(Exception e) {
			throw new AccountServiceException("Customer Data not inserted");
		}
		
		
		
     return ResponseEntity.ok(String.valueOf(userAccountNo));		
	}
	
	
	@GetMapping(value="/customer/registration/{emailverificationcode}/{useraccountno}/verifyemail",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAccountDto> verifyEmailAddressForRegistration(@PathVariable("emailverificationcode")String emailverificationcode,@PathVariable("useraccountno")String useraccountno) throws NumberFormatException, VerificationCodeMismatchException{
		
		UserAccountDto userAccountDto=null;
		userAccountDto=accountService.verifyEmailAddressForRegistration(Long.parseLong(useraccountno),emailverificationcode);
		
		return ResponseEntity.ok(userAccountDto);
	}
	
	
	
	@GetMapping(value="/useraccount/{mobileno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAccountDto>  getUserAccountDtoByMobileno(@PathVariable("mobileno")String MobileNo) throws UserNotFoundException{
		UserAccountDto userAccountDto=accountService.getUserAccountByMobileNo(MobileNo);
		return ResponseEntity.ok(userAccountDto);
	}
	
	
	
	@GetMapping(value="/customer/registration/{otpcode}/{useraccountno}/verifymobile",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> verifyMobileNoForRegistration(@PathVariable("otpcode") String otpcode,@PathVariable("useraccountno")String useraccountno) throws NumberFormatException, VerificationCodeMismatchException{
		UserAccountDto userAccountDto=accountService.verifyMobileNoForRegistration(Long.parseLong(useraccountno), otpcode);
		return ResponseEntity.ok(String.valueOf(userAccountDto.getUserAccountNo()));
	}
	
	
	@GetMapping(value="/count/{emailAddress}/emailaddress",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> getCountOfEmailAddress(@PathVariable("emailAddress")String emailAddress){
		long count=0;
		count=accountService.countByEmailAdress(emailAddress);
		return ResponseEntity.ok(String.valueOf(count));
	}
	
	
	

	@GetMapping(value="/count/{displayName}/displayname",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> getCountOfDisplayName(@PathVariable("displayName")String displayName){
		long count=0;
		count=accountService.countByDisplayName(displayName);
		return ResponseEntity.ok(String.valueOf(count));
	}
	
	
	
	

	@GetMapping(value="/count/{mobileNo}/mobileno",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> getCountOfMobileNo(@PathVariable("mobileNo")String mobileNo){
		long count=0;
		count=accountService.countByMobileNo(mobileNo);
		return ResponseEntity.ok(String.valueOf(count));
	}

	
	@ExceptionHandler(VerificationCodeMismatchException.class)
	public ResponseEntity<List<TrukeaError>> handleVerificationCodeMismatchException(VerificationCodeMismatchException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(e.getErrors());
		
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<List<TrukeaError>> handleUserNotFoundException(UserNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(e.getErrors());
		
	}

}
