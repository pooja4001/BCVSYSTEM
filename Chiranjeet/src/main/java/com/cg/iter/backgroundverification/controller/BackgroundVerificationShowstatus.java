package com.cg.iter.backgroundverification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.iter.backgroundverification.dto.EmployeeDocumentDto;
import com.cg.iter.backgroundverification.service.BcgService;
import com.cg.iter.backgroundverification.service.EmployeeService;

@Controller
public class BackgroundVerificationShowstatus {
	@Autowired
	BcgService bcgService;
	
	@PostMapping(value = "/searchid")
    @ResponseBody
	public List<EmployeeDocumentDto> searchById(@PathVariable("id") int id ) {
    	return bcgService.getEmpId(id);

	}
	
	@PostMapping(value = "/getDoccument")
    @ResponseBody
	public List<EmployeeDocumentDto> getDoccument(@PathVariable("id") int id ) {
    	return bcgService.getDoccument(id);

	}
	
	@PostMapping(value = "/searchname")
    @ResponseBody
	public List<EmployeeDocumentDto> searchByName(@PathVariable("name") String name ) {
    	return bcgService.getEmpByName(name);

	}
	@PostMapping(value = "/approvestatus")
    @ResponseBody
    public String approvestatus(@PathVariable("id") int id) {
		return "approvestatus";
	}
	
	@PostMapping(value = "/rejectstatus")
    @ResponseBody
    public String rejectstatus(@PathVariable("id") int id) {
		return "rejectstatus";
	}
}
