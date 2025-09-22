package com.tarun.My_Property.app.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public PropertyDto updateProperty(PropertyDto propertyDto, Long id) {
		Optional<PropertyEntity> optEn = propertyRepo.findById(id);
		PropertyDto dto = null;
		if(optEn.isPresent()) {
			PropertyEntity pe = optEn.get();
			pe.setAddress(propertyDto.getAddress());
			
			pe.setDescription(propertyDto.getDescription());
			pe.setTitle(propertyDto.getTitle());
			pe.setPrice(propertyDto.getPrice());
			dto = propertyConverter.cpnvertEnitytoDTO(pe);
			propertyRepo.save(pe);
		
		}
		return dto;
	}
	@Override
	public PropertyDto propertyByid(Long id) {
		Optional<PropertyEntity> optEn = propertyRepo.findById(id);
		PropertyDto dto = null;
		if(optEn.isPresent()) {
			PropertyEntity pe = optEn.get();
			dto = propertyConverter.cpnvertEnitytoDTO(pe);
		}
		return dto;
	}
	@Override
	public PropertyDto updateDes(PropertyDto propertyDto, Long id) {
		Optional<PropertyEntity> optEn = propertyRepo.findById(id);
		PropertyDto dto = null;
		if(optEn.isPresent()) {
			PropertyEntity pe = optEn.get();
			pe.setDescription(propertyDto.getDescription());
			dto = propertyConverter.cpnvertEnitytoDTO(pe);
			propertyRepo.save(pe);
		}
		return dto;
	}
	@Override
	public PropertyDto updateemail(PropertyDto propertyDto, Long id) {
		// TODO Auto-generated method stub
		Optional<PropertyEntity> optEn = propertyRepo.findById(id);
		PropertyDto  dto= null;
		if(optEn.isPresent()) {
			PropertyEntity pe = optEn.get();
			
			dto = propertyConverter.cpnvertEnitytoDTO(pe);
			propertyRepo.save(pe);
		}
		return dto;
	}
	@Override
	public PropertyDto updateprice(PropertyDto propertyDto, Long id) {
		Optional<PropertyEntity> optEn = propertyRepo.findById(id);
		PropertyDto  dto= null;
		if(optEn.isPresent()) {
			PropertyEntity pe = optEn.get();
			pe.setPrice(propertyDto.getPrice());
			dto = propertyConverter.cpnvertEnitytoDTO(pe);
			propertyRepo.save(pe);
		}
		return dto;
	}
	@Override
	public PropertyDto updatetitle(PropertyDto propertyDto, Long id) {
		Optional<PropertyEntity> optEn = propertyRepo.findById(id);
		PropertyDto  dto= null;
		if(optEn.isPresent()) {
			PropertyEntity pe = optEn.get();
			pe.setTitle(propertyDto.getTitle());
			dto = propertyConverter.cpnvertEnitytoDTO(pe);
			propertyRepo.save(pe);
		}
		return dto;
	}
	@Override
	public void deleteProperty(Long id) {
		propertyRepo.deleteById(id);
	}
	@Override
	public List<PropertyDto> saveProperties(List<PropertyDto> propertiesLis) {
		for(PropertyDto pd : propertiesLis) {
			PropertyEntity pe  = propertyConverter.convertDTOtoEntity(pd);
			pe = propertyRepo.save(pe);
		}
		return propertiesLis;
	}
		
	}

	
	
