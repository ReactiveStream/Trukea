package com.trukea.adtradingservice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "direct_sell_post")
@PrimaryKeyJoinColumn(name = "post_id")
public class DirectSellPost extends Post
{
	private static final long serialVersionUID = 5145491320493873713L;
	
	@Column(name = "product_nm")
	protected String productName;
	protected String model;
	protected String manufacturer;
	protected int year;
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;

}
