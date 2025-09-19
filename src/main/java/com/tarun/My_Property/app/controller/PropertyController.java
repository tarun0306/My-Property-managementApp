package com.tarun.My_Property.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.My_Property.app.dto.PropertyDto;
import com.tarun.My_Property.app.service.PropertyService;

@RestController
@RequestMapping("api/v1")
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	//RESTFUL API is Just mappo
	//http://localhost:8080/api/v1/hello

	
	@PostMapping("/properties")
	public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto) {
		
		propertyDto = propertyService.saveProperty(propertyDto);
		
		ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto,HttpStatus.CREATED);
		return responseEntity;
	}
	@GetMapping("/allproperties")
	public ResponseEntity<List<PropertyDto>>getAllProperties() {
		List<PropertyDto> propertyList = propertyService.getAllProperties();
		ResponseEntity<List<PropertyDto>> responseEntity = new ResponseEntity<>(propertyList,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping("/property/{id}")
	public PropertyDto getPropertyById(@PathVariable("id") Long id) {
		
		PropertyDto propertyDetails= propertyService.getPropertyById(id);
		return propertyDetails;
	}
	
}
