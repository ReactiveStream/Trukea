package com.trukea.adtradingservice.api.directsell;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trukea.adtradingservice.directsell.service.DirectSellService;
import com.trukea.adtradingservice.dto.post.DirectSellPostDto;

@RestController
@RequestMapping("/directsell")
public class ManageDirectSellApiService {
	
	@Autowired
	private DirectSellService directSellService;

	@GetMapping(value = "/{status}/{size}/popular", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DirectSellPostDto> getPopularDirectSell(@PathVariable("status") String status,
			@PathVariable("size") int size) {
		return directSellService.getPopularDirectSellPosts(status, size);
	}


}
