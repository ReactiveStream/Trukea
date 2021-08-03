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
@Table(name="contact_details")
@Setter
@Getter
public class ContactDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6771344663936985960L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contact_details_id")
	protected long contactDetailsId;
	@Column(name="primary_contact_no")
	protected  String primaryContactNo;
	@Column(name="secondary_contact_no")
	protected String secondaryContactNo;
	@Column(name="primary_email_address")
	protected String primaryEmailAddress;
	@Column(name="secondary_email_address")
	protected String secondaryEmailAddress;
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;
	
	

}
