package com.trukea.customer.service.classified;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trukea.customer.dto.post.ClassifiedDto;


@FeignClient(name = "classifiedService", url = "${adsTradingService.url}/classified")
public interface ClassifiedService {
	
	
	@GetMapping(value = "/{days}/{size}/{status}/recent", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ClassifiedDto> getRecentClassifieds(@PathVariable("size") int size, @PathVariable("days") int days,
			@PathVariable("status") String status);

}
