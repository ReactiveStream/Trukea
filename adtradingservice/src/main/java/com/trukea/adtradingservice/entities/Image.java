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
@Table(name="images")
@Setter
@Getter
public class Image implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6912773522216612117L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="image_id")
	protected long imageId;
	@Column(name="image_nm")
	protected String imageName;
	protected String description;
	@Column(name="image_file")
	protected byte[] imageFile;
	@Column(name="content_type")
	protected String contentType;
	
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;

}
