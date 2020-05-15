package com.cg.iter.backgroundverification.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cg.iter.backgroundverification.dto.EmployeeDocumentDto;

public interface EmployeeService {
	void storeDocument(List<MultipartFile> files, String docTypeId, HttpServletRequest request) throws Exception;

	List<EmployeeDocumentDto> viewStatus(int empId);
}
