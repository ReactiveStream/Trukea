package com.trukea.customer.dto.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserAccountDto {
	
	protected long  userAccountNo;
	protected  String firstName;
	protected String lastName;
	protected String displayName;
	protected String password;
	protected String emailAddress;
	protected String mobileNo;
	protected String roleName;
	protected int emailVerificationStatus;
	protected int otpCodeStatus;
	protected String status;
	

}
