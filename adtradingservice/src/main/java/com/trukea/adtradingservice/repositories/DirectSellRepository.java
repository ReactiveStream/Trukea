package com.trukea.adtradingservice.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trukea.adtradingservice.entities.DirectSellPost;

public interface DirectSellRepository  extends JpaRepository<DirectSellPost,Long>{
	
	List<DirectSellPost> findByStatusLike(String status, Sort sort);

}
