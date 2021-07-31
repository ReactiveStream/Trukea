package com.trukea.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trukea.accountservice.entities.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Long>{
	
	
	UserRole findUserRoleByRoleName(String roleName);

}
