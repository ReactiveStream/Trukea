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
@Table(name="post_keys")
@Setter
@Getter
public class PostKeys implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553533790084759531L;
	@Id
	@Column(name = "post_key_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long postKeyId;
	
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	protected Post post;
	
	@ManyToOne
	@JoinColumn(name = "key_id")
	protected GlobalPostKeys globalPostKey;
	
	@Column(name="key_value")
	protected String keyValue;
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;
	

}
