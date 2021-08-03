package com.trukea.adtradingservice.exchange.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trukea.adtradingservice.dto.post.ExchangeProductDto;
import com.trukea.adtradingservice.dto.post.ProductDto;
import com.trukea.adtradingservice.entities.ProductImage;
import com.trukea.adtradingservice.repositories.ProductExchangeRequestRepository;

@Service
public class ExchangeProductService {
	
	
	@Autowired
	public ProductExchangeRequestRepository productExchangeRequestRepository;
	
	
	
	public List<ExchangeProductDto> getRecentExchangeProducts(String status, int days, int size){
		
		Date date=new Date(121,6,10,0,0,0);
		
		return productExchangeRequestRepository.findByExchangeRequestPlacedDateGreatedThanOrEqualsAndStatus(
				status,date, Pageable.ofSize(size)).stream().map((e) -> {
					ExchangeProductDto dto = null;
					ProductDto productDto = null;
					Set<ProductImage> productImages = null;
					List<Long> productImageIds = null;

					productDto = new ProductDto();
					productDto.setProductNo(e.getCustomerProduct().getProductId());
					productDto.setProductName(e.getCustomerProduct().getProductName());
					productDto.setModel(e.getCustomerProduct().getModel());
					productDto.setManufacturer(e.getCustomerProduct().getManufacturer());
					productDto.setDescription(e.getCustomerProduct().getDescription());
					productDto.setPrice(e.getCustomerProduct().getPrice());
					productDto.setCategoryName(e.getCustomerProduct().getCategory().getCategoryName());
					
					productImages = e.getCustomerProduct().getProductImages();
					productImageIds = new ArrayList<>();
					for (ProductImage productImage : productImages) {
						productImageIds.add(productImage.getImage().getImageId());
					}
					productDto.setProductImages(productImageIds);

					dto = new ExchangeProductDto();
					dto.setExchangeProductId(e.getExchangeRequestNo());
					dto.setCustomerProduct(productDto);
					dto.setExchangeRequestPlacedDate(e.getExchangeRequestPlacedDate());
					dto.setStoreProductId(e.getStoreProductId());

					return dto;
				}).collect(Collectors.toList());
		
	}
	
	
	

}
