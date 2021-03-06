package com.trukea.accountservice.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trukea.accountservice.entities.ApiUser;
import com.trukea.accountservice.repositories.ApiUserRepository;
import com.trukea.accountservice.security.beans.UserDetailsImpl;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private ApiUserRepository apiUserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApiUser apiUser = null;
		UserDetails userDetails = null;

		apiUser = apiUserRepository.findByApiKey(username);
		if (apiUser == null) {
			throw new UsernameNotFoundException("api key not found");
		}
		userDetails = new UserDetailsImpl(apiUser.getApiKey(), apiUser.getSecret(),
				apiUser.getApiUserRole().getRoleName(), apiUser.getStatus());
		return userDetails;
	}
	

}
