package com.trukea.adtradingservice.repositories;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trukea.adtradingservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	
	
	@Query("from Category c where c.parentCategory is null order by c.displaySequenceNo")
	public List<Category> getParentCategories(Pageable pagesize);

}
