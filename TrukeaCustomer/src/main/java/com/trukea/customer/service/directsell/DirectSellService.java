package com.trukea.customer.service.directsell;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trukea.customer.dto.post.DirectSellPostDto;

@FeignClient(name = "directSellService", url = "${adsTradingService.url}/directsell")
public interface DirectSellService {
	
	@GetMapping(value = "/{status}/{size}/popular", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<DirectSellPostDto> getPopularDirectSell(@PathVariable("status") String status,
			@PathVariable("size") int size);

}
