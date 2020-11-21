package com.ecom.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.v1.dtos.AddProductRequestDto;
import com.ecom.v1.dtos.RemoveFinalProductReqDto;
import com.ecom.v1.manager.OrderBucketManager;
import com.ecom.v1.models.OrderBucket;

@RestController
@RequestMapping("/order-bucket")
public class OrderBucketController {

	@Autowired
	OrderBucketManager orderBucketManager;

	@PostMapping("/add-product")
	public OrderBucket addProduct(@RequestBody AddProductRequestDto requestDto) {
		OrderBucket bucketAfterOperation = orderBucketManager.addProduct(requestDto.getFinalProduct(),
				requestDto.getOrderBucketId(), requestDto.getUserId());
		return bucketAfterOperation;
	}

	@PostMapping("/remove-product")
	public OrderBucket removeProduct(@RequestBody RemoveFinalProductReqDto requestDto) {
		OrderBucket bucketAfterOperation = orderBucketManager.deleteProduct(requestDto.getFinalProductId(),
				requestDto.getOrderBucketId());
		return bucketAfterOperation;
	}

	@GetMapping("/{orderBucketId}")
	public OrderBucket getBucket(@PathVariable long orderBucketId) {
		return orderBucketManager.getOrderBucket(orderBucketId);
	}
}
