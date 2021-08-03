package com.trukea.adtradingservice.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trukea.adtradingservice.entities.ProductExchangeRequest;

public interface ProductExchangeRequestRepository  extends JpaRepository<ProductExchangeRequest,Long> {
	
	
	@Query("from ProductExchangeRequest per where  per.status like ?1")
	List<ProductExchangeRequest> findByExchangeRequestPlacedDateGreatedThanOrEqualsAndStatus( String status,Date inDate,
			Pageable pageable);

}
