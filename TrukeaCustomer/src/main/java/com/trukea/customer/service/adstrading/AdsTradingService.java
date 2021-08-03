package com.trukea.customer.service.adstrading;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trukea.customer.dto.adstrading.ImageDto;
import com.trukea.customer.dto.adstrading.CategoryDto;

@FeignClient(name = "AdsTradingService", url = "${adsTradingService.url}/adsTrading/")
public interface AdsTradingService {

	
	@GetMapping(value = "/parent/{size}/categories", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<CategoryDto> getParentCategories(@PathVariable("size") int size);
	
	@GetMapping(value = "/{imageId}/image", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ImageDto getImage(@PathVariable("imageId") long imageId);

}
