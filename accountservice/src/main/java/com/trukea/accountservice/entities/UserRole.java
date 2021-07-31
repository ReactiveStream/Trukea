package com.trukea.accountservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_role")
@Data
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	protected long userRoleId;
	@Column(name="role_nm")
	protected String roleName;
	protected String description;
	@Column(name="created_by")
	protected String createdBy;
	@Column(name="created_dt")
	protected Date createdDate;
	@Column(name="last_modified_by")
	protected String lastModifiedBy;
	@Column(name="last_modified_dt")
	protected Date lastModifiedDate;
	

}
