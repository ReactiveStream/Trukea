package com.trukea.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.trukea.accountservice.entities.SystemUser;

public interface SystemUserRepository extends JpaRepository<SystemUser,Long> {
	
	long countByEmailAddress(String emailAddress);
	long countByMobileNo(String mobileNo);
	long countByDisplayName(String displayName);
	
	
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
