package com.ecom.v1.dtos;

public class RemoveFinalProductReqDto {
	private long finalProductId;

	public long getFinalProductId() {
		return finalProductId;
	}

	public void setFinalProductId(long finalProductId) {
		this.finalProductId = finalProductId;
	}

	public long getOrderBucketId() {
		return orderBucketId;
	}

	public void setOrderBucketId(long orderBucketId) {
		this.orderBucketId = orderBucketId;
	}

	private long orderBucketId;
}
