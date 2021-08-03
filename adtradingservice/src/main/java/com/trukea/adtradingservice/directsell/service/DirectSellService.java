package com.trukea.adtradingservice.directsell.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.trukea.adtradingservice.dto.post.DirectSellPostDto;
import com.trukea.adtradingservice.mapper.post.PostMapper;
import com.trukea.adtradingservice.repositories.DirectSellRepository;

@Service
public class DirectSellService {
	
	
	@Autowired
	public DirectSellRepository directSellRepository;
	
	
	
	public List<DirectSellPostDto>  getPopularDirectSellPosts(String status, int size){
		return directSellRepository
				.findByStatusLike(status, Pageable.ofSize(size).getSort().and(Sort.by(Direction.DESC, "views")))
				.stream().map((e) -> {
					DirectSellPostDto dto = null;

					dto = PostMapper.mapPostToDirectSellPostDto(e);
					dto.setProductName(e.getProductName());
					dto.setModel(e.getModel());
					dto.setManufacturer(e.getManufacturer());
					return dto;
				}).collect(Collectors.toList());

	}

}
