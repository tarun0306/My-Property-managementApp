package com.tarun.My_Property.app.converter;

import org.springframework.stereotype.Component;

import com.tarun.My_Property.app.dto.PropertyDto;
import com.tarun.My_Property.app.entity.PropertyEntity;

@Component
public class PropertyConverter {
	
	public PropertyEntity convertDTOtoEntity(PropertyDto propertyDto) {
		PropertyEntity pe = new PropertyEntity();
		pe.setTitle(propertyDto.getTitle());
		pe.setAddress(propertyDto.getAddress());
		pe.setDescription(propertyDto.getDescription());
		pe.setPrice(propertyDto.getPrice());
		
		return pe;
	}
	
	public PropertyDto cpnvertEnitytoDTO(PropertyEntity pe) {
		
		PropertyDto pdt = new PropertyDto();
		pdt.setId(pe.getId());
		pdt.setTitle(pe.getTitle());
		pdt.setAddress(pe.getAddress());
		pdt.setDescription(pe.getDescription());
		
		pdt.setPrice(pe.getPrice());
		
		return pdt;
		
	}

}
