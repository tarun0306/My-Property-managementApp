package com.tarun.My_Property.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.My_Property.app.dto.UserDto;
import com.tarun.My_Property.app.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserContorller {
	@Autowired
	private UserService userService;
	@PostMapping("/user")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(userService.register(userDto),HttpStatus.CREATED);
		return responseEntity;
	}
	@PostMapping("/userlogin")
	public ResponseEntity<UserDto> userLogin(@RequestBody UserDto userDto) {
		ResponseEntity<UserDto> responseEntity =new ResponseEntity<>(userService.login(userDto.getOwnerEmail(), userDto.getPassword()),HttpStatus.OK);
		return responseEntity;
	}

}
