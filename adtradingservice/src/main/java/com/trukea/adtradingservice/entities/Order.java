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
@Table(name="post_order")
@Setter
@Getter
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8890607270685336308L;
	
	@Id
	@Column(name = "order_id")
	protected long orderId;
	@Column(name = "post_id")
	protected long postId;
	@Column(name = "order_created_dt")
	protected Date orderCreatedDate;
	protected double amount;
	@Column(name = "amount_paid")
	protected double amount_paid;
	@Column(name = "amount_due")
	protected double amount_due;

}
