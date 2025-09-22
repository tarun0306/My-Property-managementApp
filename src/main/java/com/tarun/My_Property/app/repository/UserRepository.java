package com.tarun.My_Property.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.tarun.My_Property.app.entity.PropertyEntity;
import com.tarun.My_Property.app.entity.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity,Long>{
	
	

}
