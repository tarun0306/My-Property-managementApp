package com.tarun.My_Property.app.service;



import java.util.List;

import com.tarun.My_Property.app.dto.PropertyDto;

public interface PropertyService {
	
	public PropertyDto saveProperty(PropertyDto propertyDto);
	public List<PropertyDto> getAllProperties();
	public PropertyDto getPropertyById(Long id);
	
}
