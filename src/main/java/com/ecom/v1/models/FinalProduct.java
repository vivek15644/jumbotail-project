package com.ecom.v1.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FinalProduct {
	private long id;
	private String product;
	private int quantity;

	@ManyToOne(cascade = CascadeType.ALL)
	private OrderBucket orderBucket;

	@Id
	@GeneratedValue
	public long getFpId() {
		return id;
	}

	public void setFpId(long fpId) {
		this.id = fpId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
