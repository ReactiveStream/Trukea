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
@Table(name = "category")
public class Category implements Serializable {
	@Id
	@Column(name = "category_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long categoryId;
	@Column(name = "category_nm")
	protected String categoryName;
	protected String description;
	@Column(name = "display_sequence_no")
	protected int displaySequenceNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_category_no", nullable = true)
	protected Category parentCategory;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_image_no")
	protected Image categoryImage;

	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;

}
