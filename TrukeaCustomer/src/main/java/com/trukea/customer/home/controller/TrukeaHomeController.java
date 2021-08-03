package com.trukea.customer.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trukea.customer.dto.adstrading.CategoryDto;
import com.trukea.customer.dto.post.ClassifiedDto;
import com.trukea.customer.dto.post.DirectSellPostDto;
import com.trukea.customer.dto.post.ExchangeProductDto;
import com.trukea.customer.service.adstrading.AdsTradingService;
import com.trukea.customer.service.classified.ClassifiedService;
import com.trukea.customer.service.directsell.DirectSellService;
import com.trukea.customer.service.exchange.ExchangeProductService;

@Controller
public class TrukeaHomeController {
	
	
	@Autowired
	public AdsTradingService adsTradingService;
	
	
	@Autowired
	public ClassifiedService classifiedService;
	
	
	@Autowired
	private DirectSellService directSellService;
	@Autowired
	private ExchangeProductService exchangeProductService;
	
	
	@GetMapping("/trukeahome")
	public String showTrukeaHomePage(Model model) {
		List<DirectSellPostDto> popularDirectSellPosts = null;
		List<ExchangeProductDto> exchangeProducts=null;
		List<CategoryDto> categorydtos=adsTradingService.getParentCategories(3);
		List<ClassifiedDto> classifiedDtos=classifiedService.getRecentClassifieds(3, 63,"n");
		popularDirectSellPosts = directSellService.getPopularDirectSell("n", 3);
		exchangeProducts = exchangeProductService.getRecentExchangeProducts("n", 15, 3);
		
		model.addAttribute("categories", categorydtos);
		model.addAttribute("classifieds", classifiedDtos);
		model.addAttribute("directsellposts", popularDirectSellPosts);
		model.addAttribute("exchangeproducts", exchangeProducts);
		
		return "Trukea-Home";
		
	}

}
