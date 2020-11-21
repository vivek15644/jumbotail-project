package com.ecom.v1.manager;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.v1.enums.BucketState;
import com.ecom.v1.models.FinalProduct;
import com.ecom.v1.models.OrderBucket;
import com.ecom.v1.mpr.OrderBucketPersistaneJpaRepositories;

@Service
public class OrderBucketManager {

	@Autowired
	OrderBucketPersistaneJpaRepositories orderBucketJpaRepo;

	/**
	 * 
	 * @param fp
	 * @param bucketId
	 * @return OrderBucket
	 */
	public OrderBucket addProduct(FinalProduct fp, long bucketId, long userId) {
		OrderBucket bucketAfterOperation = null;
		System.out.println("adding new product");
		try {
			OrderBucket currentBucket = orderBucketJpaRepo.findById(bucketId);
			System.out.println("current bucket:" + currentBucket);
			if (currentBucket == null)
				currentBucket = createEmptyBucket(userId);
			currentBucket.addNewProduct(fp);

			bucketAfterOperation = orderBucketJpaRepo.save(currentBucket);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occurred while adding product: " + e.getMessage() + e.getStackTrace());
		}
		return bucketAfterOperation;

	}

	private OrderBucket createEmptyBucket(long userId) {
		LocalDateTime now = LocalDateTime.now();
		// check if any active bucket is not present
		OrderBucket orderBucket = new OrderBucket();
		orderBucket.setUserId(userId);
		orderBucket.setBucketState(BucketState.FRESH);
		orderBucket.setFinalProductList(new ArrayList<FinalProduct>());
		orderBucket.setCreationTime(now);
		orderBucket.setLmt(now);
		return orderBucket;
	}

	// delete final product
	public OrderBucket deleteProduct(long finalProductId, long bucketId) {
		OrderBucket bucketAfterOperation = null;
		try {
			OrderBucket currentBucket = orderBucketJpaRepo.findById(bucketId);
			System.out.println("current bucket:" + currentBucket);
			if (currentBucket == null) {
				System.out.println("bucket not found");
			} else {
				currentBucket.removeProduct(finalProductId);
				bucketAfterOperation = orderBucketJpaRepo.save(currentBucket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("delete operation success");
		return bucketAfterOperation;

	}

	// modify quantity of final product
	public OrderBucket modifyQuantity(long productId, int quantity, long bucketId) {
		OrderBucket bucketAfterOperation = null;
		boolean quantityUpdateSuccess = false;
		// TO DO

		return bucketAfterOperation;
	}

	/**
	 * 
	 * @param orderBucketId
	 * @return OrderBucket
	 */
	public OrderBucket getOrderBucket(long orderBucketId) {
		OrderBucket resultBucket = null;
		try {
			resultBucket = orderBucketJpaRepo.findById(orderBucketId);
		} catch (Exception e) {
			System.out.println("Exception occurred while getting order Bucket: " + e.getMessage());
		}
		return resultBucket;
	}
}
