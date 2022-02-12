package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.TmsService;
import com.model.Employee;



@RestController
public class ItemController {
	
	@Autowired
	TmsService tmsService;
	
	@GetMapping("/")
	@ResponseBody
	public String getMessage()
	{
		tmsService.save(new Employee());
		
		return "Hello World";
	}

	
	

}
