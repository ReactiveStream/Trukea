package com.trukea.adtradingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trukea.adtradingservice.entities.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
	
	
	@Query( "from Image i where i.imageId=?1" )
	Image getImage(long id);

}
