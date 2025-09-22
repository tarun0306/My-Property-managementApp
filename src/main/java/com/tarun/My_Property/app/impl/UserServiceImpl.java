package com.tarun.My_Property.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarun.My_Property.app.dto.UserDto;
import com.tarun.My_Property.app.repository.UserRepository;
import com.tarun.My_Property.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDto register(UserDto userdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
