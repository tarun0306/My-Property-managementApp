package com.tarun.My_Property.app.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv) {
		
		List<ErrorModel> errorList = new ArrayList<>();
		ErrorModel errorModel = null;
		List<FieldError> fieldErrorList = manv.getBindingResult().getFieldErrors();
		
		for(FieldError fe :fieldErrorList) {
			
			errorModel = new ErrorModel();
			errorModel.setCode(fe.getCode());
			errorModel.setMessage(fe.getDefaultMessage());
			errorList.add(errorModel);
			
			
		}
		return new ResponseEntity<List<ErrorModel>>(errorList,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex){
		
		
		System.out.println("BusinessException is thrown");
		return new ResponseEntity<List<ErrorModel>>(bex.getErrors(),HttpStatus.BAD_REQUEST);
		
	}

}
