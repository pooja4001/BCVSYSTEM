package com.cg.iter.backgroundverification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.backgroundverification.dto.EmployeeDocumentDto;
import com.cg.iter.backgroundverification.dto.EmployeeDocumentDtoList;
import com.cg.iter.backgroundverification.service.BcgService;

@RestController
@RequestMapping("/background")
public class BackgroundVerificationUploadController {
	@Autowired
	BcgService bcgService;
	
	@PostMapping(value = "/searchid/{Id}")
    @ResponseBody
	public EmployeeDocumentDtoList searchById(@PathVariable("Id") int Id ) {
    	return bcgService.getEmpId(Id);

	}
	
	@PostMapping(value = "/getDoccument/{Id}")
    @ResponseBody
	public EmployeeDocumentDtoList getDoccument(@PathVariable("Id") int Id ) {
    	return bcgService.getDoccument(Id);

	}
	
	@PostMapping(value = "/searchname/{name}")
    @ResponseBody
	public EmployeeDocumentDtoList searchByName(@PathVariable("name") String name ) {
    	return bcgService.getEmpByName(name);

	}
	@PostMapping(value = "/approvestatus/{Id}")
    @ResponseBody
    public String approvestatus(@PathVariable("Id") int Id) {
		return "approvestatus";
	}
	
	@PostMapping(value = "/rejectstatus/{Id}")
    @ResponseBody
    public String rejectstatus(@PathVariable("Id") int Id) {
		return "rejectstatus";
	}
	
	
}
