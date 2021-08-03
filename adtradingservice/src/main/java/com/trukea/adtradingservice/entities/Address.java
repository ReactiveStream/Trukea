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
@Table(name="address")
@Setter
@Getter
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4488160337699788689L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	protected long addressId;
	@Column(name="address_line1")
	protected String addressLine1;
	@Column(name="address_line2")
	protected String addressLine2;
	protected String city;
	protected String state;
	protected long zip;
	protected String country;
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;
}
