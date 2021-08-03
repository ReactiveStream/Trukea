package com.trukea.adtradingservice.api.exchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trukea.adtradingservice.dto.post.ExchangeProductDto;
import com.trukea.adtradingservice.exchange.service.ExchangeProductService;



@RestController
@RequestMapping("/exchangeproduct")
public class ManageExchangeProductApiService {
	
	
	@Autowired
	private ExchangeProductService exchangeProductService;

	@GetMapping(value = "/{status}/{days}/{size}/recent", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ExchangeProductDto> getRecentExchangeProducts(@PathVariable("status") String status,
			@PathVariable("days") int days, @PathVariable("size") int size) {
		return exchangeProductService.getRecentExchangeProducts(status, days, size);
	}


}
