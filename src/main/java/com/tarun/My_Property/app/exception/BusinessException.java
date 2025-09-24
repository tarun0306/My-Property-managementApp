package com.tarun.My_Property.app.exception;

import java.util.List;
//Custom Execption class
public class BusinessException  extends RuntimeException{
	
	private List<ErrorModel> errors;
	public BusinessException() {}
	public BusinessException(List<ErrorModel> errors) {
		this.errors= errors;
	}
	public List<ErrorModel> getErrors() {
		return errors;
	}
	public void setErrors(List<ErrorModel> errors) {
		this.errors = errors;
	}
	
}
