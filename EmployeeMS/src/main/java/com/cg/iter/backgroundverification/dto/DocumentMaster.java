package com.cg.iter.backgroundverification.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DocumentMaster 
{
	@Id
	private int doctypeId;
	private String documentCategory;
	public int getDoctypeId()
	{
		return doctypeId;
	}
	public void setDoctypeId(int doctypeId)
	{
		this.doctypeId = doctypeId;
	}
	public String getDocumentCategory() 
	{
		return documentCategory;
	}
	public void setDocumentCategory(String documentCategory) 
	{
		this.documentCategory = documentCategory;
	}
	@Override
	public String toString() {
		return "DocumentMaster [doctypeId=" + doctypeId + ", documentCategory=" + documentCategory + "]";
	}
}
