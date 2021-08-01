package com.trukea.customer.beans.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -518681763308498641L;
	private long userAccountNo;
	private String username;
	private String mobileNo;
	private String password;
	private String roleName;
	private String status;
	private boolean nonLocked;
	private boolean enabled;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(long userAccountNo, String username, String mobileNo, String password, String roleName,
			String status) {
		this.userAccountNo = userAccountNo;
		this.username = username;
		this.mobileNo = mobileNo;
		this.password = password;
		this.roleName = roleName;
		this.status = status;

		this.authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.roleName));

		nonLocked = (this.status != null && this.status.equals("L")) ? false : true;
		enabled = (this.status != null && this.status.equals("N") || this.status.equals("D")) ? false : true;
	}
	
	public long getUserAccountNo() {
		return userAccountNo;
	}

	public void setUserAccountNo(long userAccountNo) {
		this.userAccountNo = userAccountNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	
	
	
	
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
