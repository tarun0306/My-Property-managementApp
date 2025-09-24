package com.tarun.My_Property.app.converter;

import org.springframework.stereotype.Component;


import com.tarun.My_Property.app.dto.UserDto;

import com.tarun.My_Property.app.entity.UserEntity;

@Component
public class UserConverter {

	public UserDto convertEntitytoDto(UserEntity pe) {
		
		UserDto dto = new UserDto();
		dto.setId(pe.getId());
		dto.setUserName(pe.getUserName());
		dto.setOwnerEmail(pe.getOwnerEmail());
		dto.setPhone(pe.getPhone());
		//dto.setPassword(pe.getPassword());
		
		return dto; 
		
	}
	
	
	public UserEntity convertDtotoEntity(UserDto udt) {
		
		UserEntity ue= new UserEntity();
		ue.setId(udt.getId());
		ue.setUserName(udt.getUserName());
		ue.setOwnerEmail(udt.getOwnerEmail());
		ue.setPhone(udt.getPhone());
		//ue.setPassword(udt.getPassword());
		
		return ue;
	}
}


