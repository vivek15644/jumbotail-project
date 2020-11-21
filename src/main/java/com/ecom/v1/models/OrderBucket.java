package com.ecom.v1.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ecom.v1.enums.BucketState;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
public class OrderBucket {

	@Id
	@GeneratedValue
	private long id;
	private long userId;
	private BucketState bucketState;

	@OneToMany(cascade = CascadeType.ALL)
	private List<FinalProduct> finalProductList;
	private LocalDateTime creationTime;
	private LocalDateTime lmt;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public BucketState getBucketState() {
		return bucketState;
	}

	public void setBucketState(BucketState bucketState) {
		this.bucketState = bucketState;
	}

	public List<FinalProduct> getFinalProductList() {
		return finalProductList;
	}

	public void setFinalProductList(List<FinalProduct> finalProductList) {
		this.finalProductList = finalProductList;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getLmt() {
		return lmt;
	}

	public void setLmt(LocalDateTime lmt) {
		this.lmt = lmt;
	}

	public void addNewProduct(FinalProduct finalProduct) {
		finalProductList.add(finalProduct);
	}

	public void removeProduct(long finalProductId) {
		FinalProduct productTobeDeleted = finalProductList.stream().filter(f -> f.getFpId() == finalProductId)
				.findFirst().orElse(null);
		if (productTobeDeleted != null) {
			finalProductList.remove(productTobeDeleted);
		}
	}

}
