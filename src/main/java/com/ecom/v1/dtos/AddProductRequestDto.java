package com.ecom.v1.dtos;

import com.ecom.v1.models.FinalProduct;

public class AddProductRequestDto {
	private FinalProduct finalProduct;

	public FinalProduct getFinalProduct() {
		return finalProduct;
	}

	public void setFinalProduct(FinalProduct finalProduct) {
		this.finalProduct = finalProduct;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getOrderBucketId() {
		return orderBucketId;
	}

	public void setOrderBucketId(long orderBucketId) {
		this.orderBucketId = orderBucketId;
	}

	private long userId;
	private long orderBucketId;
}
