package com.trukea.adtradingservice.mapper.post;

import java.util.ArrayList;
import java.util.List;

import com.trukea.adtradingservice.dto.common.CategoryDto;
import com.trukea.adtradingservice.dto.common.ImageDto;
import com.trukea.adtradingservice.dto.post.ClassifiedDto;
import com.trukea.adtradingservice.dto.post.DirectSellPostDto;
import com.trukea.adtradingservice.entities.Post;
import com.trukea.adtradingservice.entities.PostImage;

public class PostMapper {
	
	
	public static ClassifiedDto mapPostToClassifiedDto(Post post) {
		ClassifiedDto classifiedDto = null;
		List<ImageDto> postImages = null;
		CategoryDto categoryDto = null;
		ImageDto imageDto = null;

		classifiedDto = new ClassifiedDto();
		classifiedDto.setPostId(post.getPostId());
		classifiedDto.setTitle(post.getTitle());
		classifiedDto.setDescription(post.getDescription());
		classifiedDto.setPostedDate(post.getPostedDate());
		classifiedDto.setPrice(post.getPrice());
		categoryDto = new CategoryDto();
		categoryDto.setCategoryId(post.getCategory().getCategoryId());
		categoryDto.setCategoryName(post.getCategory().getCategoryName());
		categoryDto.setDescription(post.getCategory().getDescription());
		classifiedDto.setCategory(categoryDto);
		postImages = new ArrayList<ImageDto>();

		for (PostImage postImage : post.getPostImages()) {
			imageDto = new ImageDto();
			imageDto.setImageId(postImage.getImage().getImageId());
			postImages.add(imageDto);
		}
		classifiedDto.setPostImages(postImages);

		return classifiedDto;
	}

	public static DirectSellPostDto mapPostToDirectSellPostDto(Post post) {
		DirectSellPostDto directSellPostDto = null;
		List<ImageDto> postImages = null;
		CategoryDto categoryDto = null;
		ImageDto imageDto = null;

		directSellPostDto = new DirectSellPostDto();
		directSellPostDto.setPostId(post.getPostId());
		directSellPostDto.setTitle(post.getTitle());
		directSellPostDto.setDescription(post.getDescription());
		directSellPostDto.setPostedDate(post.getPostedDate());
		directSellPostDto.setPrice(post.getPrice());
		
		categoryDto = new CategoryDto();
		categoryDto.setCategoryId(post.getCategory().getCategoryId());
		categoryDto.setCategoryName(post.getCategory().getCategoryName());
		categoryDto.setDescription(post.getCategory().getDescription());
		
		directSellPostDto.setCategory(categoryDto);
		postImages = new ArrayList<ImageDto>();

		for (PostImage postImage : post.getPostImages()) {
			imageDto = new ImageDto();
			imageDto.setImageId(postImage.getImage().getImageId());
			postImages.add(imageDto);
		}
		directSellPostDto.setPostImages(postImages);

		return directSellPostDto;
	}


}
