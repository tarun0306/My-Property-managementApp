package com.tarun.My_Property.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tarun.My_Property.app.entity.PropertyEntity;
import com.tarun.My_Property.app.entity.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity,Long>{
	

	Optional<UserEntity> findByOwnerEmailAndPassword(String email,String password);
	Optional<UserEntity> findByOwnerEmail(String email);
	
	

}
