package com.trukea.adtradingservice.classified.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trukea.adtradingservice.dto.post.ClassifiedDto;
import com.trukea.adtradingservice.dto.post.ClassifiedTypeDto;
import com.trukea.adtradingservice.entities.ClassifiedPost;
import com.trukea.adtradingservice.mapper.post.PostMapper;
import com.trukea.adtradingservice.repositories.ClassifiedRepository;

@Service
public class ClassifiedService {
	
	
	@Autowired
	public ClassifiedRepository classifiedRepository;
	
	
	
	@Transactional(readOnly = false)
	public List<ClassifiedDto> getClassiedDtos(String status,int  days,int size) {
		List<ClassifiedPost> listOfClassifieds=null;
		List<ClassifiedDto> listOfClassifiedsDto=null;
		
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DATE, -days);
		//Date date=calendar.getTime();
		Date date=new Date(121,5,1,0,0,0);
		
		System.out.println(date);
		listOfClassifieds=classifiedRepository.getClassifieds(status, date, Pageable.ofSize(size));
		System.out.println(listOfClassifieds);
		listOfClassifiedsDto=listOfClassifieds.stream().map((classifiedPost) -> {
			ClassifiedDto dto = null;
			ClassifiedTypeDto classifiedTypeDto = null;

			dto = PostMapper.mapPostToClassifiedDto(classifiedPost);
			dto.setExpiryDate(classifiedPost.getExpiryDate());
			classifiedTypeDto = new ClassifiedTypeDto();
			classifiedTypeDto.setClassifiedTypeId(classifiedPost.getClassifiedType().getClassifiedTypeId());
			classifiedTypeDto.setClassifiedTypeName(classifiedPost.getClassifiedType().getClassifiedTypeName());

			dto.setClassifiedTypeDto(classifiedTypeDto);
			return dto;
		}).collect(Collectors.toList());
		return listOfClassifiedsDto;
		
		
		
		
		
		
		
		
	}
	

}
