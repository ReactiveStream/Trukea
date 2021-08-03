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



@Setter
@Getter
@Entity
@Table(name = "product_images")
public class ProductImage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4297858064581580746L;

	@Id
	@Column(name = "product_image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long productImageId;

	@ManyToOne
	@JoinColumn(name = "product_id")
	protected Product product;

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
