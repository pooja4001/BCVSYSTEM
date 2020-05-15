package com.cg.iter.backgroundverification.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.backgroundverification.dto.EmployeeDocumentDto;
import com.cg.iter.backgroundverification.dto.EmployeeDocumentDtoList;
import com.cg.iter.backgroundverification.dto.LoginDto;
import com.cg.iter.backgroundverification.dto.VerficationDto;
import com.cg.iter.backgroundverification.repository.EmployeeDocumentRepository;
import com.cg.iter.backgroundverification.repository.LoginRepository;
import com.cg.iter.backgroundverification.repository.VerificationDtoRepository;
import com.cg.iter.backgroundverification.service.BcgService;

@Service
public class BcgServiceImpl implements BcgService {
	
	@Autowired
	EmployeeDocumentRepository empRepo;
	
	@Autowired
	VerificationDtoRepository verRepo;
	
	@Autowired
	LoginRepository loginRepo;

	@Override
	public EmployeeDocumentDtoList getEmpId(int id) {
		List<EmployeeDocumentDto> data=empRepo.findByEmpId(id);
		EmployeeDocumentDtoList eData=new EmployeeDocumentDtoList();
		eData.setData(data);
		return eData;
	}

	@Override
	public EmployeeDocumentDtoList getEmpByName(String name) {
		LoginDto empdata=loginRepo.findByEmpName(name);
		List<EmployeeDocumentDto> data=empRepo.findByEmpId(empdata.getEmpId());
		EmployeeDocumentDtoList eData=new EmployeeDocumentDtoList();
		eData.setData(data);
		return eData;
	}

	

	@Override
	public EmployeeDocumentDtoList getDoccument(int empId) {
		List<EmployeeDocumentDto> data=empRepo.findByEmpId(empId);
		EmployeeDocumentDtoList eData=new EmployeeDocumentDtoList();
		eData.setData(data);
		return eData;
	}
}
