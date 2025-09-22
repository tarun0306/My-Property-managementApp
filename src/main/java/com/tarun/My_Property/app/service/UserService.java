package com.tarun.My_Property.app.service;

import com.tarun.My_Property.app.dto.UserDto;

public interface UserService {
	
	UserDto register(UserDto userdto);
	UserDto login(String email,String password);

}
