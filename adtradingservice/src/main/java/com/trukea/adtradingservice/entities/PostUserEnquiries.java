package com.trukea.adtradingservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="post_user_enquiries")
@Setter
@Getter
public class PostUserEnquiries implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1956776051823120635L;
	
	
	
	@Id
	@Column(name = "classified_user_enquiries_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long classifiedUserEnquiriesId;
	
	@Column(name="mobile_no")
	protected String mobileNo;
	@Column(name="email_address")
	protected String emailAddress;
	@Column(name="contact_nm")
	protected String contactName;
	protected String description;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	protected Post post;
	
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;

}
