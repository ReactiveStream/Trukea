package com.trukea.adtradingservice.api.classified;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trukea.adtradingservice.classified.service.ClassifiedService;
import com.trukea.adtradingservice.dto.post.ClassifiedDto;

@RestController
@RequestMapping("/classified")
public class ManageClassifiedApiService {
	
	
	@Autowired
	private ClassifiedService classifiedService;

	@GetMapping(value = "/{days}/{size}/{status}/recent", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ClassifiedDto> getRecentClassifieds(@PathVariable("size") int size, @PathVariable("days") int days,
			@PathVariable("status") String status) {
		System.out.println("adtradingservice classifiedapi");
		return classifiedService.getClassiedDtos(status, days, size);
	}

}
