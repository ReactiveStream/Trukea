package com.trukea.customer.service.exchange;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trukea.customer.dto.post.ExchangeProductDto;



@FeignClient(name = "exchangeProduct", url = "${adsTradingService.url}/exchangeproduct")
public interface ExchangeProductService {
	
	@GetMapping(value = "/{status}/{days}/{size}/recent", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<ExchangeProductDto> getRecentExchangeProducts(@PathVariable("status") String status,
			@PathVariable("days") int days, @PathVariable("size") int size);

}
