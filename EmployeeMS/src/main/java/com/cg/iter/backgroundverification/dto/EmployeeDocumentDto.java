package com.cg.iter.backgroundverification.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class EmployeeDocumentDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int docId;
	@Lob
	@Column(name = "docFile")
	private byte[] docData;

	public byte[] getDocData() {
		return docData;
	}

	private int empId;
	@Column(name = "docTypeId")
	private int docType;

	public void setDocData(byte[] docData) {
		this.docData = docData;
	}

	private int requestId;

	public int getEmpId() {
		return empId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getDocType() {
		return docType;
	}

	public void setDocType(int docType) {
		this.docType = docType;
	}
}
