package com.tarun.My_Property.app.impl;



import java.util.ArrayList;
import java.util.List;

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
	@Override
	public List<PropertyDto> getAllProperties() {
		List<PropertyEntity>listofProps= (List<PropertyEntity>)propertyRepo.findAll();
		List<PropertyDto> propList = new ArrayList<>();
		for(PropertyEntity pe :listofProps) {
			PropertyDto dto = propertyConverter.cpnvertEnitytoDTO(pe);
			propList.add(dto);
		}
		return propList;
	}
	@Override
	public PropertyDto getPropertyById(Long id) {
		List<PropertyEntity> pe =(List<PropertyEntity>) propertyRepo.findAll();
		
		for(PropertyEntity e : pe) {
			if(e.getId() == id) {
				 return propertyConverter.cpnvertEnitytoDTO(e);
			}
		}
		return null;
	}
}
