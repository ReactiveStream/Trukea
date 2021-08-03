package com.trukea.adtradingservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "payment_details")
@Setter
@Getter
public class PaymentDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5890877445507021643L;
	
	
	@Id
	@Column(name = "payment_id")
	protected String paymentId;
	@Column(name = "post_id")
	protected long postId;
	@Column(name = "order_id")
	protected String orderId;
	@Column(name = "payment_dt")
	protected Date paymentDate;
	protected String status;

}
