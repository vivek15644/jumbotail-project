package com.ecom.v1.mpr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.v1.models.OrderBucket;

@Repository
public interface OrderBucketPersistaneJpaRepositories extends JpaRepository<OrderBucket, Long> {

	OrderBucket findById(long id);
}
