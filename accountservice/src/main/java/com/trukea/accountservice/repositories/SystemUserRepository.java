package com.trukea.accountservice.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.trukea.accountservice.entities.SystemUser;

public interface SystemUserRepository extends JpaRepository<SystemUser,Long> {
	
	long countByEmailAddress(String emailAddress);
	long countByMobileNo(String mobileNo);
	long countByDisplayName(String displayName);
	
	SystemUser findByEmailAddressAndStatus(String emailaddress,String status);
	
	SystemUser findByEmailAddress(String emailaddress);
	
	
	
	@Query("update SystemUser su set su.emailVerificationCode=?1,su.emailVerificationCodeGeneratedDate=?3 where su.emailAddress=?2")
	@Modifying
	int updateEmailVerificationCodeToResetPassword(String emailverificationcode,String emailaddress,Date date);
	
	
	@Query("update SystemUser su set su.otpCode=?1,su.otpCodeGeneratedDate=?3 where su.mobileNo=?2")
	@Modifying
	int updateOtpCodeToResetPassword(String otpcode,String mobileno,Date date);
	
	@Query("update SystemUser su set su.password=?1 where su.systemUserId=?2")
	@Modifying
	int  updateResetPassword(String password,long useraccountno);
	
	
	SystemUser findByMobileNo(String mobileno);
	
	SystemUser findBySystemUserIdAndEmailVerificationCode(long systemuserid,String emailverificationcode);
	
	SystemUser findBySystemUserIdAndOtpCode(long systemuserid,String otpcode);
	@Query("update SystemUser su set su.emailVerificationCodeStatus=?1 where su.systemUserId=?2")
	@Modifying
   int updateEmailVerification(int status,long useraccountid);
	
	@Query("update SystemUser su set su.otpCodeVerificationStatus=?1,su.status=?3 where systemUserId=?2")
	@Modifying
	   int updateMobileVerification(int otpstatus,long useraccountid,String status);
	
		
	
	

}
