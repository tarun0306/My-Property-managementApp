package com.tarun.My_Property.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.tarun.My_Property.app.entity.PropertyEntity;


public interface PropertyRepository extends CrudRepository<PropertyEntity,Long>{
	
	

}
