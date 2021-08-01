package com.trukea.accountservice.security.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	
	private static final long serialVersionUID = -518681763308498641L;
	private String username;
	private String password;
	private String roleName;
	private String status;
	private boolean nonLocked;
	private boolean enabled;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(String username, String password, String roleName, String status) {
		this.username = username;
		this.password = password;
		this.roleName = roleName;
		this.status = status;

		this.authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.roleName));

		this.nonLocked = (this.status != null && this.status.equals("L")) ? false : true;
		this.enabled = (this.status != null && this.status.equals("N") || this.status.equals("D")) ? false : true;
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
