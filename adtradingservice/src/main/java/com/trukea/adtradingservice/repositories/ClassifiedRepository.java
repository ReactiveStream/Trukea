package com.trukea.adtradingservice.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trukea.adtradingservice.entities.ClassifiedPost;

public interface ClassifiedRepository extends JpaRepository<ClassifiedPost,Long> {
	
	
	
	@Query("from ClassifiedPost cp where   cp.status like ?1")
	List<ClassifiedPost> getClassifieds(String status,Date date,Pageable size);
	
	

}
