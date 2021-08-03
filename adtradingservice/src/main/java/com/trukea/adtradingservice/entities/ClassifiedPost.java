package com.trukea.adtradingservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "classified_post")
@PrimaryKeyJoinColumn(name = "post_id")
public class ClassifiedPost extends Post {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3376595079414982232L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "classified_type_id")
	protected ClassifiedType classifiedType;
	@Column(name = "expired_dt")
	protected Date expiryDate;
	@Column(name = "classified_fee")
	protected long classifiedFee;
	
	
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;
	

}
