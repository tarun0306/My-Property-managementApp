package com.tarun.My_Property.app.service;



import java.util.List;

import com.tarun.My_Property.app.dto.PropertyDto;

public interface PropertyService {
	
	PropertyDto saveProperty(PropertyDto propertyDto);
	List<PropertyDto> saveProperties(List<PropertyDto> propertiesLis);
	List<PropertyDto> getAllProperties();
	PropertyDto updateProperty(PropertyDto propertyDto, Long id);
	PropertyDto propertyByid(Long id);
	PropertyDto updateDes(PropertyDto propertyDto,Long id);
	PropertyDto updateemail(PropertyDto propertyDto,Long id);
	PropertyDto updatetitle(PropertyDto propertyDto,Long id);
	PropertyDto updateprice(PropertyDto propertyDto,Long id);
	void deleteProperty(Long id);
	
}
