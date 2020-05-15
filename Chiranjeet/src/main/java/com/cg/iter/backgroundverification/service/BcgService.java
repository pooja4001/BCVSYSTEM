package com.cg.iter.backgroundverification.service;

import java.util.List;

import com.cg.iter.backgroundverification.dto.EmployeeDocumentDto;
import com.cg.iter.backgroundverification.dto.EmployeeDocumentDtoList;

public interface BcgService {
	
	EmployeeDocumentDtoList getDoccument(int empId);

	EmployeeDocumentDtoList getEmpId(int id);

	EmployeeDocumentDtoList getEmpByName(String name);
	
	
}
