package com.tarun.My_Property.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.My_Property.app.dto.CalculatorDTO;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculaterController {
	
	//http://ocalhost:8080/api/v1/calculator/add?num1=9&num2=990
	@GetMapping("/add")
	public Double add(@RequestParam("num1")Double num1 ,@RequestParam("num2")Double num2) {
		return num1+num2;
	}
	
	//http://localhost:8080/api/v1/calculator/add?num1=25&num2=35
	
	@GetMapping("/sub/{num1}/{num2}")
	public Double sub (@PathVariable("num1")Double num1 , @PathVariable("num2")Double num2) {
		Double res = null;
		
		if(num1>num2) {
			res = num1 - num2;
		} 
		else {
			res = num2 - num1;
		}
		return res;
	}
	
	@PostMapping("/mul")
	public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calDTO) {
		
		Double res = null;
		res = calDTO.getNum1()*calDTO.getNum2()*calDTO.getNum3()*calDTO.getNum4();
		       	
		return new ResponseEntity<Double>(res,HttpStatus.CREATED);
		
	}
}
