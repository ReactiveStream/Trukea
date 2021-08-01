package com.trukea.accountservice.service.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trukea.accountservice.dto.account.UserAccountDto;
import com.trukea.accountservice.entities.SystemUser;
import com.trukea.accountservice.entities.UserRole;
import com.trukea.accountservice.exception.AccountServiceException;
import com.trukea.accountservice.exception.TrukeaError;
import com.trukea.accountservice.exception.UserNotFoundException;
import com.trukea.accountservice.exception.VerificationCodeMismatchException;
import com.trukea.accountservice.repositories.SystemUserRepository;
import com.trukea.accountservice.repositories.UserRoleRepository;
import com.trukea.accountservice.utils.AccountServiceConstants;
import com.trukea.accountservice.utils.RandomGenerator;

@Service
public class AccountService {
	
	
	@Autowired
	public SystemUserRepository systemUserRepository;
	
	@Autowired 
	public UserRoleRepository userRoleRepository;
	
	
	@Transactional(readOnly = false)
	public long registerCustomer(UserAccountDto userAccountDto) throws AccountServiceException {
		SystemUser systemUser=null;
		UserRole userRole=null;
		SystemUser systemeUserFromRepo=null;
		
		systemUser=new SystemUser();
		systemUser.setCreatedBy("system");
		systemUser.setCreatedDate(new Date());
		systemUser.setLastModifiedBy("system");
		systemUser.setLastModifiedDate(new Date());
		systemUser.setDisplayName(userAccountDto.getDisplayName());
		systemUser.setEmailAddress(userAccountDto.getEmailAddress());
		systemUser.setEmailVerificationCode(RandomGenerator.generateEmailVerificationCode(10));
		systemUser.setEmailVerificationCodeGeneratedDate(new Date());
		systemUser.setFirstName(userAccountDto.getFirstName());
		systemUser.setLastName(userAccountDto.getLastName());
		systemUser.setMobileNo(userAccountDto.getMobileNo());
		systemUser.setOtpCode(RandomGenerator.generateOtpCode(4));
		systemUser.setOtpCodeGeneratedDate(new Date());
		systemUser.setEmailVerificationCodeStatus(0);
		systemUser.setOtpCodeVerificationStatus(0);
		systemUser.setPassword(userAccountDto.getPassword());
		systemUser.setStatus(AccountServiceConstants.STATUS_NEW);
		
		try {
		
		userRole=userRoleRepository.findUserRoleByRoleName("customer");
		systemUser.setUserRole(userRole);
		systemeUserFromRepo=systemUserRepository.save(systemUser);
		}
		catch(Exception e) {
			throw new AccountServiceException("database error");
		}
		
		return systemeUserFromRepo.getSystemUserId();
	}
	
	@Transactional(readOnly = false)
	public UserAccountDto verifyEmailAddressForRegistration(long useraccountid,String emailverificationcode) throws VerificationCodeMismatchException {
		SystemUser systemUser=null;
		UserAccountDto userAccountDto=null;
		
		systemUser=systemUserRepository.findBySystemUserIdAndEmailVerificationCode(useraccountid, emailverificationcode);
		if(systemUser==null) {
			TrukeaError error=new TrukeaError("EMVR-401","Email verification code is not matching");
			List<TrukeaError> list=new ArrayList();
			list.add(error);
			throw new VerificationCodeMismatchException(list);
			
		}
		
		systemUserRepository.updateEmailVerification(1, useraccountid);
		
		
		userAccountDto=new UserAccountDto();
		userAccountDto.setDisplayName(systemUser.getDisplayName());
		userAccountDto.setEmailAddress(systemUser.getEmailAddress());
		userAccountDto.setFirstName(systemUser.getFirstName());
		userAccountDto.setLastName(systemUser.getLastName());
		userAccountDto.setMobileNo(systemUser.getMobileNo());
		userAccountDto.setOtpCodeStatus(systemUser.getOtpCodeVerificationStatus());
		userAccountDto.setPassword(systemUser.getPassword());
		userAccountDto.setRoleName(systemUser.getUserRole().getRoleName());
		userAccountDto.setStatus(systemUser.getStatus());
		userAccountDto.setUserAccountNo(systemUser.getSystemUserId());
		
		return userAccountDto;
		
		
		
	}
	
	@Transactional(readOnly = false)
	public UserAccountDto verifyMobileNoForRegistration(long useraccountid,String otpcode) throws VerificationCodeMismatchException {
		SystemUser systemUser=null;
		UserAccountDto userAccountDto=null;
			systemUser=	systemUserRepository.findBySystemUserIdAndOtpCode(useraccountid, otpcode);
			if(systemUser==null) {
				TrukeaError error=new TrukeaError("MNVR-401","OTP code is not matching");
				List<TrukeaError> list=new ArrayList();
				list.add(error);
				throw new VerificationCodeMismatchException(list);
				
			}
			if(systemUser!=null) {
				systemUserRepository.updateMobileVerification(1, useraccountid,"A");
			}
			userAccountDto=new UserAccountDto();
			userAccountDto.setDisplayName(systemUser.getDisplayName());
			userAccountDto.setEmailAddress(systemUser.getEmailAddress());
			userAccountDto.setFirstName(systemUser.getFirstName());
			userAccountDto.setLastName(systemUser.getLastName());
			userAccountDto.setMobileNo(systemUser.getMobileNo());
			userAccountDto.setOtpCodeStatus(systemUser.getOtpCodeVerificationStatus());
			userAccountDto.setPassword(systemUser.getPassword());
			userAccountDto.setRoleName(systemUser.getUserRole().getRoleName());
			userAccountDto.setStatus(systemUser.getStatus());
			userAccountDto.setUserAccountNo(systemUser.getSystemUserId());
			
			return userAccountDto;
		
			
	}
	
	@Transactional(readOnly = true)
	public UserAccountDto getUserAccountByMobileNo(String mobileno) throws UserNotFoundException {
		SystemUser systemUser=null;
		UserAccountDto userAccountDto=null;
		
		
			systemUser=systemUserRepository.findByMobileNo(mobileno);
			if(systemUser==null) {
				TrukeaError error=new TrukeaError("MN-401","Account with this mobileno not found");
				List<TrukeaError> list=new ArrayList();
				list.add(error);
				throw new UserNotFoundException(list);
				
			}
			
		
		if(systemUser!=null) {
			
			userAccountDto=new UserAccountDto();
			userAccountDto.setDisplayName(systemUser.getDisplayName());
			userAccountDto.setEmailAddress(systemUser.getEmailAddress());
			userAccountDto.setFirstName(systemUser.getFirstName());
			userAccountDto.setLastName(systemUser.getLastName());
			userAccountDto.setMobileNo(systemUser.getMobileNo());
			userAccountDto.setOtpCodeStatus(systemUser.getOtpCodeVerificationStatus());
			userAccountDto.setPassword(systemUser.getPassword());
			userAccountDto.setRoleName(systemUser.getUserRole().getRoleName());
			userAccountDto.setStatus(systemUser.getStatus());
			userAccountDto.setUserAccountNo(systemUser.getSystemUserId());
			
		}
		
		return userAccountDto;
		
		
	}
	
	@Transactional(readOnly = true)
	public UserAccountDto getUserAccountByEmail(String emailaddress) throws UserNotFoundException {
		SystemUser systemUser=null;
		UserAccountDto userAccountDto=null;
		
		
			systemUser=systemUserRepository.findByEmailAddressAndStatus(emailaddress, "A");
			if(systemUser==null) {
				TrukeaError error=new TrukeaError("EM-401","Account with this email address no found");
				List<TrukeaError> list=new ArrayList();
				list.add(error);
				throw new UserNotFoundException(list);
				
			}
			
		
		if(systemUser!=null) {
			userAccountDto=new UserAccountDto();
			userAccountDto.setDisplayName(systemUser.getDisplayName());
			userAccountDto.setEmailAddress(systemUser.getEmailAddress());
			userAccountDto.setFirstName(systemUser.getFirstName());
			userAccountDto.setLastName(systemUser.getLastName());
			userAccountDto.setMobileNo(systemUser.getMobileNo());
			userAccountDto.setOtpCodeStatus(systemUser.getOtpCodeVerificationStatus());
			userAccountDto.setPassword(systemUser.getPassword());
			userAccountDto.setRoleName(systemUser.getUserRole().getRoleName());
			userAccountDto.setStatus(systemUser.getStatus());
			userAccountDto.setUserAccountNo(systemUser.getSystemUserId());
			
		}
		
		return userAccountDto;
		
		
	}
	
	
	@Transactional(readOnly = false)
	public void sendEmailVerificationForResetPassword(String emailaddress) throws AccountServiceException {
		int count=systemUserRepository.updateEmailVerificationCodeToResetPassword(RandomGenerator.generateEmailVerificationCode(10), emailaddress,new Date());
		if(count==0) {
			throw new AccountServiceException("unknownException");
		}
		
		
		
	}
	
	
	@Transactional(readOnly = false)
	public void sendOtpCodeToResetPassword(String mobileno) throws AccountServiceException {
	int count=	systemUserRepository.updateOtpCodeToResetPassword(RandomGenerator.generateOtpCode(4), mobileno,new Date());
	if(count==0) {
		throw new AccountServiceException("unknownexception");
	}
	
	
	
	
	

		
	}
	

	@Transactional(readOnly = true)
	public String emailVerificationForResetPassword(String emailverificationcode,Long useraccountno) throws VerificationCodeMismatchException {
		SystemUser systemUser=null;
		systemUser=systemUserRepository.findBySystemUserIdAndEmailVerificationCode(useraccountno, emailverificationcode);
		
		if(systemUser==null) {
			if(systemUser==null) {
				TrukeaError error=new TrukeaError("EMVR-401","Email verification code is not matching");
				List<TrukeaError> list=new ArrayList();
				list.add(error);
				throw new VerificationCodeMismatchException(list);
				
			}
			
			
		

		}
		
		return String.valueOf(useraccountno);
	}
	@Transactional(readOnly = true)
	public String otpVerificationForResetPassword(String otpcode,Long useraccountno) throws VerificationCodeMismatchException {
		SystemUser systemUser=null;
		systemUser=systemUserRepository.findBySystemUserIdAndOtpCode(useraccountno, otpcode);
		
		if(systemUser==null) {
			if(systemUser==null) {
				TrukeaError error=new TrukeaError("MVR-401","Otp  code is not matching");
				List<TrukeaError> list=new ArrayList();
				list.add(error);
				throw new VerificationCodeMismatchException(list);
				
			}
			
			
		

		}
		
		return String.valueOf(useraccountno);
	}
	
	@Transactional(readOnly = false)
	public String resetPassword(UserAccountDto useraccountdto) throws AccountServiceException {
		int count=0;
		
	count=	systemUserRepository.updateResetPassword(useraccountdto.getPassword(), useraccountdto.getUserAccountNo());
	if(count==0) {
		throw new AccountServiceException("unknownexception");
	}
	return String.valueOf(useraccountdto.getUserAccountNo());
	}
	
	
	@Transactional(readOnly = true)
	public long countByEmailAdress(String emailAddress) {
		return systemUserRepository.countByEmailAddress(emailAddress);
	}
	@Transactional(readOnly = true)
	public long countByDisplayName(String displayName) {
		return systemUserRepository.countByDisplayName(displayName);
	}
	@Transactional(readOnly = true)
	public long countByMobileNo(String mobileNo) {
		return systemUserRepository.countByMobileNo(mobileNo);
	}

}
