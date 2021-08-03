package com.trukea.adtradingservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="global_post_keys")
@Setter
@Getter
public class GlobalPostKeys implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6189454469860447140L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="key_id")
	protected long keyId;
	@Column(name="key_nm")
	protected String keyName;
	protected String description;
	protected String status;
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;


}
