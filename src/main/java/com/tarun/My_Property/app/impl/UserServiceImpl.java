package com.tarun.My_Property.app.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarun.My_Property.app.converter.UserConverter;
import com.tarun.My_Property.app.dto.UserDto;
import com.tarun.My_Property.app.entity.UserEntity;
import com.tarun.My_Property.app.exception.BusinessException;
import com.tarun.My_Property.app.exception.ErrorModel;
import com.tarun.My_Property.app.repository.UserRepository;
import com.tarun.My_Property.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserConverter  userConverter; 
	@Override
	public UserDto register(UserDto userdto) {
		
		Optional<UserEntity> optUe = userRepo.findByOwnerEmail(userdto.getOwnerEmail());
		if(optUe.isPresent()) {
			List<ErrorModel> errorModelList  = new ArrayList<>();
			ErrorModel error = new ErrorModel();
			error.setCode("Existing User");
			error.setCode("PLEASE CHECK AGAING USER ALREADY EXISTED");
			errorModelList.add(error);
			throw new BusinessException(errorModelList);
		}
		UserEntity userEntity = userConverter.convertDtotoEntity(userdto);
		userEntity = userRepo.save(userEntity);
		UserDto dto = userConverter.convertEntitytoDto(userEntity);
		return dto;
	}

	@Override
	public UserDto login(String email, String password) {
		
		Optional<UserEntity> pty = userRepo.findByOwnerEmailAndPassword(email, password);
		UserDto dto  = null;
			if(pty.isPresent()) {
				dto = userConverter.convertEntitytoDto(pty.get());
			}else {
				List<ErrorModel> errorModelList = new ArrayList<>();
				ErrorModel err = new ErrorModel();
				err.setCode("INVALID_LOGIN");
				err.setMessage("Incorrect Email or Password");
				errorModelList.add(err);
				
				throw new BusinessException(errorModelList);
			}
			return dto;
			
	}

}
