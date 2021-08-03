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
@Table(name="classified_types")
@Setter
@Getter
public class ClassifiedType  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7780438512142754552L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="classified_type_id")
	public long classifiedTypeId;
	@Column(name="classified_type_nm")
	public String classifiedTypeName;
	public String description;
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;
	

}
