package com.trukea.customer.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trukea.customer.beans.security.UserDetailsImpl;
import com.trukea.customer.dto.account.UserAccountDto;
import com.trukea.customer.service.account.AccountService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	public AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccountDto userAccountDto=null;
		UserDetails userDetails=null;
		
		userAccountDto=accountService.getUserAccountDtoByEmailAddress(username).getBody();
		
		userDetails=new UserDetailsImpl(userAccountDto.getUserAccountNo(),userAccountDto.getEmailAddress(), userAccountDto.getMobileNo(), userAccountDto.getPassword(), userAccountDto.getRoleName(),
				userAccountDto.getStatus());
		
		
		
		return userDetails;
	}

}
