package com.cg.iter.backgroundverification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.backgroundverification.dto.EmployeeDocumentDto;

public interface EmployeeDocumentRepository extends JpaRepository<EmployeeDocumentDto, Integer> {
	List<EmployeeDocumentDto> findByEmpId(int empId);

}
