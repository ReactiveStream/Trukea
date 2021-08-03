package com.trukea.customer.util.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trukea.customer.service.adstrading.AdsTradingService;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	
	@Autowired
	public AdsTradingService adsTradingService;
	
	@GetMapping(value="/{imageid}",produces = { MediaType.IMAGE_PNG_VALUE })
	public byte[] getImageContent(@PathVariable("imageid") long imageid) {
		
		return adsTradingService.getImage(imageid).getImageFileContent();
		
		
	}

}
