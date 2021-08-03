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
@Table(name = "product_exchange_request")
public class ProductExchangeRequest implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3279489148713546856L;

	@Id
	@Column(name = "exchange_request_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long exchangeRequestNo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_product_id")
	
	protected Product customerProduct;
	@Column(name = "store_product_id")
	protected long storeProductId;
	@Column(name = "exchange_request_placed_dt")
	protected Date exchangeRequestPlacedDate;
	@Column(name = "customer_product_service_area_id")
	protected long customerProductServiceAreaId;
	@Column(name = "customer_product_address_id")
	protected long customerProductAddressId;
	protected String status;
	@Column(name = "created_dt")
	protected Date createdDate;
	@Column(name = "created_by")
	protected String createdBy;
	@Column(name = "last_modified_dt")
	protected Date lastModifiedDate;
	@Column(name = "last_modified_by")
	protected String lastModifiedBy;

}
