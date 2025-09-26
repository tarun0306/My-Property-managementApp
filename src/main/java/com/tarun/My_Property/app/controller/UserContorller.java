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

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class UserContorller {
	@Autowired
	private UserService userService;
	@PostMapping("/user")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto){
		return new ResponseEntity<>(userService.register(userDto),HttpStatus.CREATED);
	}
	@PostMapping("/userlogin")
	public ResponseEntity<UserDto> userLogin(@Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.login(userDto.getOwnerEmail(), userDto.getPassword()),HttpStatus.OK);
	}


}
