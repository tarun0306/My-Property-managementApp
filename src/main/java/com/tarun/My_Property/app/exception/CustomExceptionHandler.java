package com.tarun.My_Property.app.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv) {
		
		List<ErrorModel> errorList = new ArrayList<>();
		ErrorModel errorModel = null;
		List<FieldError> fieldErrorList = manv.getBindingResult().getFieldErrors();
		
		for(FieldError fe :fieldErrorList) {
			logger.debug("Inside field Validation {} : {}", fe.getField(),fe.getDefaultMessage());
			logger.info("Inside field Validation {} : {}", fe.getField(),fe.getDefaultMessage());
			errorModel = new ErrorModel();
			errorModel.setCode(fe.getCode());
			errorModel.setMessage(fe.getDefaultMessage());
			errorList.add(errorModel);
			
			
		}
		return new ResponseEntity<List<ErrorModel>>(errorList,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex){
		for(ErrorModel em : bex.getErrors()) {
			logger.debug("BusinessException thrown  level - debug{} : {}",em.getCode(),em.getMessage());
			logger.info("BusinessException thrown {} level - info : {}",em.getCode(),em.getMessage());
			logger.warn("BusinessException thrown  level - warn {} : {}",em.getCode(),em.getMessage());
			logger.error("BusinessException thrown  level-error {} : {}",em.getCode(),em.getMessage());
		}		
		
		return new ResponseEntity<List<ErrorModel>>(bex.getErrors(),HttpStatus.BAD_REQUEST);
		
	}

}
