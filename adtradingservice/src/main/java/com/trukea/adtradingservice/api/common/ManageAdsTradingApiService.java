package com.trukea.adtradingservice.api.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trukea.adtradingservice.common.service.AdsTradingService;
import com.trukea.adtradingservice.dto.common.CategoryDto;
import com.trukea.adtradingservice.dto.common.ImageDto;

@RestController
@RequestMapping("/adsTrading")
public class ManageAdsTradingApiService {
	
	
	@Autowired
	public AdsTradingService adsTradingService;
	
	@GetMapping(value = "/parent/{size}/categories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CategoryDto>> getParentCategories(@PathVariable("size") int size){
		return ResponseEntity.ok(adsTradingService.getParentCategories(size));
	}
	
	
	@GetMapping(value = "/{imageId}/image", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ImageDto getImage(@PathVariable("imageId") long imageId) {
		return adsTradingService.getImageDto(imageId);
	}

}
