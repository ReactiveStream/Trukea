package com.trukea.adtradingservice.common.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trukea.adtradingservice.dto.common.CategoryDto;
import com.trukea.adtradingservice.dto.common.ImageDto;
import com.trukea.adtradingservice.entities.Image;
import com.trukea.adtradingservice.repositories.CategoryRepository;
import com.trukea.adtradingservice.repositories.ImageRepository;


@Service
public class AdsTradingService {
	
	
	@Autowired
	public CategoryRepository categoryRepository;
	
	@Autowired
	public ImageRepository imageRepository;
	
	@Transactional(readOnly = false)
	public List<CategoryDto> getParentCategories(int size) {
		return categoryRepository.getParentCategories(Pageable.ofSize(size)).stream().map(
				(category)->{
					CategoryDto categorydto=new CategoryDto();
					categorydto.setCategoryId(category.getCategoryId());
					categorydto.setCategoryName(category.getCategoryName());
					categorydto.setDescription(category.getDescription());
					if(category.getCategoryImage()!=null) {
					categorydto.setImageId(category.getCategoryImage().getImageId());
					}
					return categorydto;
				}
				).collect(Collectors.toList());	
	}
	
	
	@Transactional(readOnly = false)
	public ImageDto getImageDto(long id) {
		Image image=imageRepository.getImage(id);
		ImageDto imagedto=new ImageDto();
		imagedto.setImageFileContent(image.getImageFile());
		imagedto.setImageId(image.getImageId());
		imagedto.setContentType(image.getContentType());
		return imagedto;
	}
}
