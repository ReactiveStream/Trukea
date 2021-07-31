package com.trukea.accountservice.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="system_users")
@Data
public class SystemUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="system_user_id")
	protected long systemUserId;
	@Column(name="email_address")
	protected String emailAddress;
	@Column(name="first_nm")
	protected String firstName;
	@Column(name="last_nm")
	protected String lastName;
	@Column(name="display_nm")
	protected String displayName;
	@Column(name="mobile_no")
	protected String mobileNo;
	protected String password;
	protected String status;
	@Column(name="otp_code")
	protected String otpCode;
	@ManyToOne()
	@JoinColumn(name = "user_role_id")
	protected UserRole userRole;
	@Column(name="otp_code_generated_dt")
	protected Date otpCodeGeneratedDate;
	@Column(name="email_verification_code")
	protected String emailVerificationCode;
	@Column(name="email_verification_code_generated_dt")
	protected Date emailVerificationCodeGeneratedDate;
	@Column(name="email_verification_code_status")
	protected int emailVerificationCodeStatus;
	@Column(name="otp_code_status")
	protected int otpCodeVerificationStatus;
	@Column(name="created_by")
	protected String createdBy;
	@Column(name="created_dt")
	protected Date createdDate;
	@Column(name="last_modified_by")
	protected String lastModifiedBy;
	@Column(name="last_modified_dt")
	protected Date lastModifiedDate;
	
	

}
