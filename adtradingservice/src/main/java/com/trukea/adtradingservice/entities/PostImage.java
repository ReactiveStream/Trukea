package com.trukea.adtradingservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="post_images")
@Setter
@Getter
public class PostImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -839104723470550992L;
	
	
	@Id
	@Column(name = "post_image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long postImageId;
	

	@ManyToOne
	@JoinColumn(name = "post_id")
	protected Post post;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "image_id")
	protected Image image;
	
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;

}
