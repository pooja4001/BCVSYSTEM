package com.cg.iter.backgroundverification.dto;

import java.util.List;

public class EmployeeDocumentDtoList {
	
	 private List<EmployeeDocumentDto> data;

	public List<EmployeeDocumentDto> getData() {
		return data;
	}

	public void setData(List<EmployeeDocumentDto> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "EmployeeDocumentDtoList [data=" + data + "]";
	}
	 
	 

}
