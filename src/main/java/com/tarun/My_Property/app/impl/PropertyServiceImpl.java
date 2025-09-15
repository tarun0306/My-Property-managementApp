package com.tarun.My_Property.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarun.My_Property.app.converter.PropertyConverter;
import com.tarun.My_Property.app.dto.PropertyDto;
import com.tarun.My_Property.app.service.PropertyService;
import com.tarun.My_Property.app.repository.PropertyRepository;
import com.tarun.My_Property.app.entity.PropertyEntity;
@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertyRepository propertyRepo;
	
	@Autowired
	private PropertyConverter propertyConverter;
	@Override
	public PropertyDto saveProperty(PropertyDto propertyDto) {
		
		PropertyEntity pe  = propertyConverter.convertDTOtoEntity(propertyDto);		
		pe = propertyRepo.save(pe);
		PropertyDto dto = propertyConverter.cpnvertEnitytoDTO(pe);
		return dto;
		
	
	
		
	}

}
