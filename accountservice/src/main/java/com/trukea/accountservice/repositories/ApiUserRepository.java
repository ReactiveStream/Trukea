package com.trukea.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trukea.accountservice.entities.ApiUser;

public interface ApiUserRepository extends JpaRepository<ApiUser, Long>  {
	ApiUser findByApiKey(String apiKey);

}
