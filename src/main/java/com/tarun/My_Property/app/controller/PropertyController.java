package com.tarun.My_Property.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.My_Property.app.dto.PropertyDto;
import com.tarun.My_Property.app.dto.UserDto;
import com.tarun.My_Property.app.service.PropertyService;
import com.tarun.My_Property.app.service.UserService;

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
		
		return new ResponseEntity<>(propertyDto,HttpStatus.CREATED);
	}
	
	@PostMapping("/saveallproperties")
	public ResponseEntity<List<PropertyDto>> saveProperties(@RequestBody List<PropertyDto> propertyList) {	
		propertyList = propertyService.saveProperties(propertyList);
		 return new ResponseEntity<>(propertyList,HttpStatus.CREATED);
	
	}
	@GetMapping("/allproperties")
	public ResponseEntity<List<PropertyDto>>getAllProperties() {
		List<PropertyDto> propertyList = propertyService.getAllProperties();
		return new ResponseEntity<>(propertyList,HttpStatus.OK);
	}
	
	@PutMapping("/properties/{id}")
	public ResponseEntity<PropertyDto>updateProperty(@RequestBody PropertyDto propertyDto ,@PathVariable Long id) {
		return new ResponseEntity<>(propertyService.updateProperty(propertyDto, id),HttpStatus.CREATED);
	}
	@GetMapping("/property/{id}")
	public ResponseEntity<PropertyDto> getPropertyById(@PathVariable Long id) {
		return new ResponseEntity<>(propertyService.propertyByid(id),HttpStatus.OK);
	}
	@PatchMapping("/properties/update-description/{id}")
	public ResponseEntity<PropertyDto> updateDes(@RequestBody PropertyDto propertyDto,@PathVariable Long id){
		return new ResponseEntity<>(propertyService.updateDes(propertyDto, id),HttpStatus.ACCEPTED);
	}
	@PatchMapping("/properties/update-price/{id}")
	public ResponseEntity<PropertyDto> updateprice(@RequestBody PropertyDto propertyDto,@PathVariable Long id){
		return new ResponseEntity<>(propertyService.updateprice(propertyDto, id),HttpStatus.ACCEPTED);
	}
	@PatchMapping("/properties/update-email{id}")
	public ResponseEntity<PropertyDto> updateemail(@RequestBody PropertyDto propertyDto,@PathVariable Long id){
		return new ResponseEntity<>(propertyService.updateemail(propertyDto, id),HttpStatus.ACCEPTED);
	}
	@PatchMapping("/properties/update-title/{id}")
	public ResponseEntity<PropertyDto> updatetitle(@RequestBody PropertyDto propertyDto,@PathVariable Long id){
		return new ResponseEntity<>(propertyService.updatetitle(propertyDto, id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/properties/{id}")
	public ResponseEntity<Object> deleteByid(@PathVariable Long id){
		propertyService.deleteProperty(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
