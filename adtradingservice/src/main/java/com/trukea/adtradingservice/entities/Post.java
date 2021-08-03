package com.trukea.adtradingservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="post")
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class Post implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7186490443776377753L;
	
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long postId;
	protected String title;
	protected String description;
	@Column(name = "posted_dt")
	protected Date postedDate;

	@Column(name = "post_owner_id")
	protected long postOwnerId;

	@ManyToOne
	@JoinColumn(name = "post_address_id")
	protected Address address;

	@ManyToOne
	@JoinColumn(name = "contact_details_id")
	protected ContactDetails contactDetais;

	@Column(name = "service_area_id")
	protected long serviceAreaId;

	protected long views;
	protected double price;
	protected String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	protected Category category;
	@ManyToOne
	@JoinColumn(name = "post_type_id")
	protected PostType postType;
	
	
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
	protected Set<PostImage> postImages;

	@OneToMany(mappedBy = "post")
	protected Set<PostKeys> postKeys;

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	protected Set<PostUserEnquiries> postUserEnquiries;

	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;


}
